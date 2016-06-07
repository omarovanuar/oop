package com.epam.module3.task3.oop.interfacee;

import com.epam.module3.task3.oop.entity.Electronics;

import java.io.IOException;
import java.util.List;

public interface ReadInterface {
    void read() throws IOException;
    int getId();
    List<Electronics> getList();
}
