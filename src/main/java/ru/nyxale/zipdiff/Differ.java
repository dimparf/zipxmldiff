package ru.nyxale.zipdiff;

import java.util.List;

public interface Differ {

    List<String> processDiffFiles(List<FileFromZip> modifiedFiles, List<FileFromZip> oldFiles);
}
