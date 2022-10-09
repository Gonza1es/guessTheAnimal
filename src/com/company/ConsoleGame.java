package com.company;


import com.company.service.AnimalService;
import com.company.service.Service;

import java.util.Scanner;

public class ConsoleGame {

    private final Service service = new AnimalService("кит", "кот", "живет на суше");
    Scanner scanner = new Scanner(System.in);

    public void play() {
        String thisAnimal = "Это животное ";
        boolean answer;
        System.out.print("Сыграем в игру? (да/нет): ");
        while (playerAnswer()) {
            System.out.println("Загадай животное, а я попробую угадать...");
            do {
                System.out.print(thisAnimal + service.getDistinction() + "? ");  // Ходит по дереву, пока не наткнется
                answer = playerAnswer();                                        // на узел, указывающий на животных
            } while (!service.isEnd(answer));

            String currentAnimal = service.getAnimalByRoute(answer);               // Предлагает животное
            System.out.print(thisAnimal + currentAnimal + "? ");
            if (playerAnswer()) service.drop();                          // Если угадал, откатывает курсор в начальное состояние
            else {                                                       // Иначе предлагает ввести загаданное животное
                System.out.print("Какое животное ты загадал? ");
                String newAnimal = scanner.nextLine();
                System.out.format("Чем %s отличается от %s: ", newAnimal, currentAnimal);
                String newDistinction = scanner.nextLine();
                boolean exit;
                do {
                    exit = service.saveAnimal(newAnimal, newDistinction, answer);
                    if (!exit) {
                        System.out.print("Такое отличие уже есть. Попробуй придумать другое: ");
                        newDistinction = scanner.nextLine();
                    }
                } while (!exit);
            }
            System.out.print("Сыгрыем еще раз? ");
        }
        System.out.println("Пока");
        scanner.close();
    }

    /*
        Метод ввода корректного ответа
     */
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
