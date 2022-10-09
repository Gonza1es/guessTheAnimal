package com.company;


import java.util.Scanner;

public class ConsoleGame {

    private final AnimalService service = new AnimalService("кит", "кот", "живет на суше");
    Scanner scanner = new Scanner(System.in);

    public void play() {
        String thisAnimal = "Это животное ";
        boolean answer;
        System.out.print("Сыграем в игру? (да/нет): ");
        while (playerAnswer()) {
            System.out.println("Загадай животное, а я попробую угадать...");
            do {
                System.out.print(thisAnimal + service.getDistinction() + "? ");
                answer = playerAnswer();
            } while (!service.isEnd(answer));

            String currentAnimal = service.getAnimal(answer);
            System.out.print(thisAnimal + currentAnimal + "? ");
            if (playerAnswer()) service.drop();
            else {
                System.out.print("Какое животное ты загадал? ");
                String newAnimal = scanner.nextLine();
                System.out.format("Чем %s отличается от %s: ", newAnimal, currentAnimal);
                String newDistinction = scanner.nextLine();
                boolean exit;
                do {
                    exit = service.save(newAnimal, newDistinction, answer);
                    if (!exit) {
                        System.out.print("Такое отличие уже есть. Попробуй придумать другое: ");
                        newDistinction = scanner.nextLine();
                    }
                } while (!exit);
            }
            System.out.print("Сыгрыем еще раз? ");
        }
        System.out.println("Пока");
    }

    private boolean playerAnswer() {
        boolean isCorrect = false;
        String answer = scanner.nextLine();
        while (!isCorrect) {
            if (answer.equals("да") || answer.equals("нет"))
                isCorrect = true;
            else {
                System.out.print("Можно ответить только \"да\" или \"нет\". Попробуй еще раз: ");
                answer = scanner.nextLine();
            }
        }
        return answer.equals("да");
    }

}
