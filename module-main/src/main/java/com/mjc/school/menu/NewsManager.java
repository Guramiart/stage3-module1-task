package com.mjc.school.menu;

import com.mjc.school.controller.Controller;
import com.mjc.school.dto.NewsDTO;
import com.mjc.school.factory.OperationFactory;

import java.util.Scanner;

public class NewsManager {

    private final Controller<NewsDTO> controller;

    public NewsManager(Controller<NewsDTO> controller) {
        this.controller = controller;
    }

    public void run() {
        try(Scanner sc = new Scanner(System.in)) {
            while (true) {
                OperationFactory.getOperationList().forEach(System.out::println);
                OperationFactory.getCommand(sc, controller).execute(sc);
            }
        }
    }

}
