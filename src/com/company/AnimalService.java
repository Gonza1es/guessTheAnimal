package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnimalService implements Playing<String> {
    private final String rootAnimal;
    private Map<String, String> animalTable = new HashMap<>();

    public AnimalService(String rootAnimal, String animal, String distinction) {
        this.animalTable.put(distinction, animal);
        this.rootAnimal = rootAnimal;
    }

    @Override
    public Set<String> getDistinction() {
        return animalTable.keySet();
    }

    @Override
    public String getAnimalByDistinction(String distinction) {
        return animalTable.get(distinction);
    }

    @Override
    public boolean saveAnimal(String animal, String distinction) {
        if (animalTable.containsKey(distinction)) {
            return false;
        } else {
            animalTable.put(distinction, animal);
            return true;
        }
    }
}
