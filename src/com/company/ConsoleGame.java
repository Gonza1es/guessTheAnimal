package com.company;


import java.util.Scanner;

public class ConsoleGame {

    private AnimalService animalService = new AnimalService("Кит", "Кот", "Живет на суше");
    Scanner scanner = new Scanner(System.in);

    public void play() {
        System.out.print("Давай сыграем в игру?: ");
        playerAnswer();

    }

    private void playerAnswer() {
        String answer = scanner.nextLine();
        switch (answer) {
            case "да" -> System.out.println("да");
            case "нет" -> System.out.println("нет");
            default -> System.out.println("неправильный ответ");
        }
    }

}
