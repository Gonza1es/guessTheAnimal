package com.company.interfaces;

public interface WorkingWithAnimals {
    String getDistinction();
    String getAnimalByRoute(boolean route);
    boolean saveAnimal(String animal, String distinction, boolean route);
}
