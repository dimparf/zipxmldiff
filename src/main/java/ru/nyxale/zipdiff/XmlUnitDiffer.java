package ru.nyxale.zipdiff;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.XML;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Comparison;
import org.xmlunit.diff.ComparisonListener;
import org.xmlunit.diff.ComparisonResult;
import org.xmlunit.diff.DOMDifferenceEngine;
import org.xmlunit.diff.DefaultNodeMatcher;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.Difference;
import org.xmlunit.diff.DifferenceEngine;
import org.xmlunit.diff.DifferenceEvaluators;
import org.xmlunit.diff.ElementSelectors;
import org.xmlunit.xpath.JAXPXPathEngine;

public class XmlUnitDiffer implements Differ {

    @Override
    public Optional<List<String>> processDiffFiles(List<FileFromZip> modifiedFiles, List<FileFromZip> oldFiles) {
        XmlReader xmlReader = new XmlReader();
        List<String> diff = new ArrayList<>();
        List<FileFromZip> oldFilesExistInModList = oldFiles
            .stream()
            .filter(oldFile -> modifiedFiles
                .stream()
                .anyMatch(modifiedFile -> modifiedFile.fileName.equalsIgnoreCase(oldFile.fileName))).collect(Collectors.toList());

        return oldFilesExistInModList.stream().map(oldFile -> {
            try {
                String oldFileContent = xmlReader.readXmlFile(oldFile);
                //this is safe .get(0)
                FileFromZip newFile = modifiedFiles
                    .stream()
                    .filter(modifiedFile -> modifiedFile.fileName.equalsIgnoreCase(oldFile.fileName)).collect(Collectors.toList()).get(0);
                String newFileContent = xmlReader.readXmlFile(newFile);
                System.out.println(String.format("Process files: %s and %s", oldFile.fileName, newFile.fileName));
                return processDiff(oldFileContent, newFileContent);
            } catch (IOException ioe) {
                return diff;
            }
        }).findFirst();
    }

    /**
     * Process diff for two files
     */
    private List<String> processDiff(String oldFileContent, String newFileContent) {
        List<String> differentNodesAsJson = new ArrayList<>();
        Diff myDiff = DiffBuilder
            .compare(oldFileContent)
            .withTest(newFileContent)
            .checkForSimilar()
            .withNodeMatcher(new DefaultNodeMatcher(ElementSelectors.byNameAndText))
            .build();

        Iterable<Difference> differences = myDiff.getDifferences();
        for (Difference difference : differences) {
            if (difference.getComparison().getControlDetails().getTarget() != null) {
                Node testNode = difference.getComparison().getControlDetails().getTarget();
                String selector = difference.getComparison().getControlDetails().getXPath();
                Iterable<Node> nodes = new JAXPXPathEngine().selectNodes(selector, testNode);
                for (Node node : nodes) {
                    differentNodesAsJson.add(XML.toJSONObject(nodeToString(node)).toString());
                }
            }
            if (difference.getComparison().getTestDetails().getTarget() != null) {
                Node testNode = difference.getComparison().getTestDetails().getTarget();
                String selector = difference.getComparison().getTestDetails().getXPath();
                Iterable<Node> nodes = new JAXPXPathEngine().selectNodes(selector, testNode);
                for (Node node : nodes) {
                    differentNodesAsJson.add(XML.toJSONObject(nodeToString(node)).toString());
                }
            }

            System.out.println("Difference: " + difference.toString());
            System.out.println("----------------------------------------------------------");
        }
        return differentNodesAsJson;
    }

    private String nodeToString(Node node) {
        StringWriter sw = new StringWriter();
        try {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.transform(new DOMSource(node), new StreamResult(sw));
        } catch (TransformerException te) {
            System.out.println("nodeToString Transformer Exception");
        }
        return sw.toString();
    }


}
