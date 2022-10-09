package com.company.repository;

import java.util.HashSet;
import java.util.Set;

public class AnimalRepository implements Repository {  // Класс реализует бинарное дерево
    private final Node rootNode;
    private Node currentNode;
    Set<String> passedDistinctions;

    public AnimalRepository(String negativeAnimal, String positiveAnimal, String distinction) {
        rootNode = new Node();
        rootNode.setValue(distinction);
        rootNode.setNegative(new Node(negativeAnimal));
        rootNode.setPositive(new Node(positiveAnimal));
        currentNode = rootNode;
        passedDistinctions = new HashSet<>();
    }

    @Override
    public String getDistinction() {
        passedDistinctions.add(currentNode.getValue());
        return currentNode.getValue();
    }

    @Override
    public String getAnimalByRoute(boolean route) {
        if (route) return currentNode.getPositive().getValue();
        else return currentNode.getNegative().getValue();
    }

    @Override
    public boolean saveAnimal(String animal, String distinction, boolean route){
        if (isNewDistinction(distinction)) {
            Node newNode = new Node();
            newNode.setValue(distinction);
            newNode.setPositive(new Node(animal));
            if (route) {
                newNode.setNegative(currentNode.getPositive());
                currentNode.setPositive(newNode);
            } else {
                newNode.setNegative(currentNode.getNegative());
                currentNode.setNegative(newNode);
            }
            passedDistinctions.clear();
            drop();
            return true;
        } else return false;
    }

    @Override
    public boolean hasNextDistinction(boolean route) {
        if (route)
            return currentNode.getPositive().getPositive() != null;
        else return  currentNode.getNegative().getPositive() != null;

    }

    @Override
    public void next(boolean route) {
        if (route) currentNode = currentNode.getPositive();
        else currentNode = currentNode.getNegative();
    }
    @Override
    public void drop() {
        currentNode = rootNode;
    }

    private boolean isNewDistinction(String distinction) {
        return !passedDistinctions.contains(distinction);
    }
}
