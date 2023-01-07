package com.mjc.school;

import com.mjc.school.controller.impl.NewsController;
import com.mjc.school.menu.NewsManager;

public class Main {

    public static void main(String[] args) {
        NewsManager newsManager = new NewsManager(new NewsController());
        newsManager.run();
    }

}
