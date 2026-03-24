package com.fitlog.fitlogai.model;

import java.io.Serializable;

public class Routine implements Serializable {

    private String name;

    public Routine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}