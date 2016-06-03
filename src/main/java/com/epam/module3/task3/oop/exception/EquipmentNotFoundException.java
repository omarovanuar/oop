package com.epam.module3.task3.oop.exception;

public class EquipmentNotFoundException extends Exception {
    private String title;

    public EquipmentNotFoundException(String title) {
        this.title = title;
    }

    public String getMessage() {
        return "[EquipmentNotFoundException]: Electronic equipment with the title: " + title + " was not found";
    }
}
