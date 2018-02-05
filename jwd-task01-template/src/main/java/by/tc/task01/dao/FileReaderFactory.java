package by.tc.task01.dao;

import by.tc.task01.dao.impl.ApplianceFileReaderImpl;

public class FileReaderFactory {// этот класс явно не предназначен для использования вне дао, и тогда ему не место в этом пакете
    private static final FileReaderFactory instance = new FileReaderFactory();

    private final ApplianceFileReader applianceFileReader = new ApplianceFileReaderImpl();

    private FileReaderFactory() {
    }

    public ApplianceFileReader getFileReader() {
        return applianceFileReader;
    }

    public static FileReaderFactory getInstance() {
        return instance;
    }
}
