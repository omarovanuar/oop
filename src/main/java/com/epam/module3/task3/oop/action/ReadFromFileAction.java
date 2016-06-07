package com.epam.module3.task3.oop.action;

import com.epam.module3.task3.oop.entity.Electronics;
import com.epam.module3.task3.oop.interfacee.ReadInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileAction implements ReadInterface {
    private static final String FILE_PATH = "C:\\Users\\Anuar_Omarov\\IdeaProjects\\oop\\electronics-list.txt";
    private File file = new File(FILE_PATH);
    private int id;
    private String tempString;
    private List<Electronics> list = new ArrayList<>();

    @Override
    public void read() throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((tempString = bufferedReader.readLine()) != null) {
            String[] strings = tempString.split(":");
            id = Integer.valueOf(strings[0]);
            list = CreateListFromArrayAction.create(strings);
        }
        fileReader.close();
        bufferedReader.close();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public List<Electronics> getList() {
        return list;
    }
}
