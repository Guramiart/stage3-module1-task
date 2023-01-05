package com.mjc.school.command;

import com.mjc.school.controller.Controller;
import com.mjc.school.dto.NewsDTO;

import java.util.List;
import java.util.Scanner;

public abstract class Command {

    protected final Controller<NewsDTO> controller;

    protected Command(Controller<NewsDTO> controller) {
        this.controller = controller;
    }
    public abstract void execute(Scanner sc);

}
