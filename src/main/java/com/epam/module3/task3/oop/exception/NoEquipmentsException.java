package com.epam.module3.task3.oop.exception;

public class NoEquipmentsException extends Exception {
    public String getMessage() {
        return "[NoEquipmentsException]: There is no electronics in your list";
    }
}
