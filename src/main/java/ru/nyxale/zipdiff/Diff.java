package ru.nyxale.zipdiff;

import java.util.List;
import java.util.Optional;

/**
 * Статистика по архивам : Кол-во новых новых файлов, удаленных файлов, измененных файлов
 * Статистика по измененным файлам : Кол-во новых Node, кол-во удаленных Node, кол-во измененных Node
 + развернутое описание по измененным Node : тело Node из архива 1 + тело node из архива 2
 */
public class Diff {
    public int newFilesCount;
    public int deletedFilesCount;
    public int modifiedFilesCont;
    public String oldFileName;
    public String newFileName;
    public int oldFileEntitiesCount;
    public int newFileEntitiesCount;
    public int newNodeCount;
    public int deletedNodeCount;
    public int modifiedNodeCount;
    public List<String> nodeBodies;

    public Diff(){}

    public Diff(int newFilesCount, int deletedFilesCount, int modifiedFilesCont, String oldFileName, String newFileName,
                int newNodeCount, int deletedNodeCount, int modifiedNodeCount, List<String> nodeBodies) {
        this.newFilesCount = newFilesCount;
        this.deletedFilesCount = deletedFilesCount;
        this.modifiedFilesCont = modifiedFilesCont;
        this.oldFileName = oldFileName;
        this.newFileName = newFileName;
        this.newNodeCount = newNodeCount;
        this.deletedNodeCount = deletedNodeCount;
        this.modifiedNodeCount = modifiedNodeCount;
        this.nodeBodies = nodeBodies;
    }

    @Override
    public String toString() {
        return "Diff{" +
            "newFilesCount=" + newFilesCount +
            ", deletedFilesCount=" + deletedFilesCount +
            ", modifiedFilesCont=" + modifiedFilesCont +
            ", oldFileName='" + oldFileName + '\'' +
            ", newFileName='" + newFileName + '\'' +
            ", oldFileEntitiesCount=" + oldFileEntitiesCount +
            ", newFileEntitiesCount=" + newFileEntitiesCount +
            ", newNodeCount=" + newNodeCount +
            ", deletedNodeCount=" + deletedNodeCount +
            ", modifiedNodeCount=" + modifiedNodeCount +
            ", nodeBodies=" + nodeBodies +
            '}';
    }
}
