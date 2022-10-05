package com.company;


import java.util.Set;

public interface Playing<E> {

    Set<E> getDistinction();
    E getAnimalByDistinction(E distinction);
    boolean saveAnimal(E animal, E distinction);
}
