package com.ersikthy.rentalroom.controller.menu;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ersikthy.rentalroom.controller.log.Output.*;

public class Menu {
    @FunctionalInterface
    public interface MenuAction {
        void execute();
    }

    static class MenuItem {
        private final String label;
        private final MenuAction action;

        public MenuItem(String label, MenuAction action) {
            this.label = label;
            this.action = action;
        }

        public String getLabel() {
            return label;
        }

        public Object run() {
            action.execute();
            return null;
        }
    }

    private final String title;
    private final List<MenuItem> items = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private Runnable listPrinter;
    private boolean shouldExit = false;

    public void setListPrinter(Runnable listPrinter) {
        this.listPrinter = listPrinter;
    }

    public Menu(String title) {
        this.title = title;
    }

    public void addOption(String label, MenuAction action) {
        items.add(new MenuItem(label, action));
    }

    public void requestBack() {
        this.shouldExit = true;
    }


    
    public void displayMenu() {
        shouldExit = false;
        while (true) {
            println("=========" + title + "=========", null);

            if (listPrinter != null) {
                listPrinter.run();
                println("------------------", null);
            }

            for (int i = 0; i < items.size(); i++) {
                printf("[%d].%s", (i + 1), items.get(i).getLabel() + "\n");
            }

            println("Type: exit to end this program or back to return", Color.GRAY);

            print("Enter here: ", null);
            String rawInput = scanner.nextLine().trim();

            if (rawInput.equalsIgnoreCase("exit")) {
                print("Exiting...", null);
                System.exit(0);
            }

            if (rawInput.equalsIgnoreCase("back")) {
                println("Returning...", null);
                break;
            }

            try {
                int input = Integer.parseInt(rawInput);

                if (input > 0 && input <= items.size()) {
                    items.get(input - 1).run();
                    if (shouldExit) break;
                } else {
                    sysLog("Unknow option");
                }
            } catch (NumberFormatException e) {
                sysLog("Please enter a valid number! \nOr type: \n- Back to return. \n- Exit to end program");
            }
        }
    }
}
