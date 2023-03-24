package services;

import storage.CountStorage;

import java.util.Scanner;

public class UserInterface {
    private final Counter counter;

    public UserInterface(Counter counter) {
        this.counter = counter;
    }

    private void printInterface() {
        System.out.println("Введите команду:");
        System.out.println("/inc для увеличения счётчика на 1.");
        System.out.println("/stop для завершения работы приложения.");
        System.out.println("/reset для обнуления счётчика");
    }

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface(new Counter(new CountStorage()));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Текущее значение счётчика: " + userInterface.counter.getCount() + "\n");
        while (true) {
            userInterface.printInterface();
            String command = scanner.nextLine();
            switch (command) {
                case "/inc" -> {
                    userInterface.counter.increment();
                    System.out.println("Новое состояние счётчика: " + userInterface.counter.getCount());
                }
                case "/stop" -> {
                    System.out.println("Состояние счётчика: " + userInterface.counter.getCount());
                    return;
                }
                case "/reset" -> {
                    userInterface.counter.reset();
                    System.out.println("Новое состояние счётчика: " + userInterface.counter.getCount());
                }
                default -> System.out.println("Такой команды не существует. Попробуйте ещё раз." + "\n");
            }
        }
    }
}
