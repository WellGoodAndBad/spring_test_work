package com.textparser.textparser;

import org.springframework.stereotype.Component;
import java.io.*;
import org.springframework.beans.factory.annotation.Value;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


@Component
public class TextToDoc {
    @Value("${fileName}")
    private String name;

    public String getName() {
        return name;
    }

    public void makeDoc(ArrayList<String> list) throws IOException {

        Path fileToDeletePath = Paths.get(getName());
        Files.deleteIfExists(fileToDeletePath);

        FileWriter file = new FileWriter(getName(), true);
        for (String i : list){
            if (i.length() > 38) {
                String[] list_words = i.split(" ");
                String row = "";
                for (String word: list_words){
                    row = row + " " + word;
                    if (row.length() > 38){
                        row.replace(word, "\n");
                        file.write(row + "\n");
                        row = word;
                    }
                }
            }
            else{
                file.write(i+"\n");
                }
        }
        file.close();
    }
}
