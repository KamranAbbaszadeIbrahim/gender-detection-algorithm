package org.java.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public abstract class ResourceReaderUtils {
    public static List<String> bufferedResourceReaderToList(String fileName) {
        List<String> list = new LinkedList<>();
        try {
            final FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();
            final BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                        fileResourcesUtils.getFileFromResourceAsStream(fileName), StandardCharsets.UTF_8));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close();
        }catch (final IllegalArgumentException | IOException iae){
            log.error("Class: ResourceReaderUtils, fileName: {}, file is not converted into list, catched exception message: {}", fileName, iae.getMessage());
            return new LinkedList<>();
        }
        log.debug("Class: ResourceReaderUtils, fileName: {}, file converted into list", fileName);
        return list;
    }
}
