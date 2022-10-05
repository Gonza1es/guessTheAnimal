package com.company;

public class Animal {
    private final String name;
    private final String distinction;

    public Animal(String name, String distinction) {
        this.name = name;
        this.distinction = distinction;
    }

    public String getName() {
        return name;
    }

    public String getDistinction() {
        return distinction;
    }
}
