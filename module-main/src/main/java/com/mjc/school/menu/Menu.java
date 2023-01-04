package com.mjc.school.menu;

import com.mjc.school.controller.Controller;
import com.mjc.school.dto.NewsDTO;

import java.util.Scanner;

public class Menu {

    private final Controller<NewsDTO> controller;

    public Menu(Controller<NewsDTO> controller) {
        this.controller = controller;
    }

    public void run() {
        try(Scanner sc = new Scanner(System.in)) {

        }
    }

}
