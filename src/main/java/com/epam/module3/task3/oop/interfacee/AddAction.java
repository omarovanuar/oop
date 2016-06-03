package com.epam.module3.task3.oop.interfacee;

import com.epam.module3.task3.oop.entity.Electronics;

import java.io.IOException;

public interface AddAction {
    Electronics addNewItem(int id) throws IOException;
}
