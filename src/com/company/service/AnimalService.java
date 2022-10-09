package com.company.service;

import com.company.repository.AnimalRepository;
import com.company.repository.Repository;


public class AnimalService implements Service { // Сервис для работы с репозиторием

    private final Repository tree;

    public AnimalService(String negativeAnimal, String positiveAnimal, String distinction) {
        this.tree = new AnimalRepository(negativeAnimal, positiveAnimal, distinction);
    }

    @Override
    public boolean isEnd(boolean route) {
        if (tree.hasNextDistinction(route)) {
            tree.next(route);
            return false;
        } else return true;
    }

    @Override
    public String getDistinction() {
        return tree.getDistinction();
    }

    @Override
    public String getAnimalByRoute(boolean route) {
        return tree.getAnimalByRoute(route);
    }

    @Override
    public boolean saveAnimal(String newAnimal, String newDistinction, boolean route){
        return tree.saveAnimal(newAnimal, newDistinction, route);
    }

    @Override
    public void drop() {
        tree.drop();
    }
}
