package com.mjc.school;

import com.mjc.school.controller.impl.NewsController;
import com.mjc.school.menu.Menu;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu(new NewsController());
        menu.run();
    }

}
