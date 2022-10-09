package com.company.repository;


public interface Repository<E> extends Dropping{

    E getDistinction();
    E getAnimalByRoute(boolean route);
    boolean saveAnimal(E animal, E distinction, boolean route);

    boolean hasNextDistinction(boolean route);

    void next(boolean route);

}
