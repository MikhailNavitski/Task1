package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceFileReader;

import java.io.File;
import java.util.ResourceBundle;

public class ApplianceFileReaderImpl implements ApplianceFileReader {
    public File readingFile() {
        String filePath = ResourceBundle.getBundle("source_name").getString("source.name");
        File file = new File(filePath);
        return file;
    }
}
