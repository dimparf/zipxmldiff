package ru.nyxale.zipdiff;

import java.util.List;
import java.util.Optional;

public interface Differ {

    Optional<List<String>> processDiffFiles(List<FileFromZip> modifiedFiles, List<FileFromZip> oldFiles);
}
