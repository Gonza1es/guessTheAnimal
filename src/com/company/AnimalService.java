package com.company;

import com.company.repository.AnimalTree;
import com.company.repository.Repository;

public class AnimalService {

    private final Repository<String> tree;

    public AnimalService(String negativeAnimal, String positiveAnimal, String distinction) {
        this.tree = new AnimalTree(negativeAnimal, positiveAnimal, distinction);
    }

    public boolean isEnd(boolean route) {
        if (tree.hasNextDistinction(route)) {
            tree.next(route);
            return false;
        } else return true;
    }

    public String getDistinction() {
        return tree.getDistinction();
    }

    public String getAnimal(boolean route) {
        return tree.getAnimalByRoute(route);
    }

    public boolean save(String newAnimal, String newDistinction, boolean route){
        return tree.saveAnimal(newAnimal, newDistinction, route);
    }

    public void drop() {
        tree.drop();
    }
}
