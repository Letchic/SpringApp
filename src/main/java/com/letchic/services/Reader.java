package com.letchic.services;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("readService")
public class Reader {
        public List<String[]> readFromCsvFile(String separator, String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){

            List<String[]> list = new ArrayList<>();
            String line = "";
            while((line = reader.readLine()) != null){
                String[] array = line.split(separator);
                list.add(array);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
