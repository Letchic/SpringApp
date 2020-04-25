package com.letchic.services;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@Service("writeService")
public class Writter {

    public static void writeToCsvFile(List<String> thingsToWrite, String separator, String fileName) {
        boolean alreadyExists = new File(fileName).exists();
        try (FileWriter writer = new FileWriter(fileName,true)) {
            if (alreadyExists)  writer.append(System.lineSeparator());
            for (String string : thingsToWrite) {
                writer.append(string);
                writer.append(separator);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
