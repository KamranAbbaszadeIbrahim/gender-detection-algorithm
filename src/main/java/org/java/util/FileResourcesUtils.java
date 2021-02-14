package org.java.util;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;

@Slf4j
public class FileResourcesUtils {
    public InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            log.error("Class: FileResourcesUtils, fileName: {}, file not found", fileName);
            throw new IllegalArgumentException("file not found " + fileName);
        } else {
            log.debug("Class: FileResourcesUtils, fileName: {}, file found", fileName);
            return inputStream;
        }
    }
}
