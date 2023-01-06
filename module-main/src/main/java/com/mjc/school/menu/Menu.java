package com.mjc.school.menu;

import com.mjc.school.command.impl.ErrorCommand;
import com.mjc.school.controller.Controller;
import com.mjc.school.dto.NewsDTO;
import com.mjc.school.factory.OperationFactory;

import java.util.Scanner;

public class Menu {

    private final Controller<NewsDTO> controller;

    public Menu(Controller<NewsDTO> controller) {
        this.controller = controller;
    }

    public void run() {
        try(Scanner sc = new Scanner(System.in)) {
            while (true) {
                try {
                    OperationFactory.getOperationList().forEach(System.out::println);
                    OperationFactory.getCommand(sc, controller).execute(sc);
                } catch (NumberFormatException e) {
                    new ErrorCommand(controller).execute(sc);
                }
            }
        }
    }

}
