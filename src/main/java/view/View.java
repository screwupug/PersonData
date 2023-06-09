package view;

import controller.Controller;

import java.util.Scanner;

public class View {
    private Controller controller;
    private Scanner scanner;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Для выхода наберите exit");
            System.out.println("Введите ФИО, дату рождения в формате dd.mm.yyyy, номер телефона, и пол в формате f/m через пробел:");
            String prompt = scanner.nextLine();
            switch (prompt) {
                case "exit":
                    System.exit(0);
                default:
                   add(prompt);
            }
        }
    }

    private void add(String input) {
        try {
            if (controller.addData(input)) {
                System.out.println("Добавлено успешно\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
