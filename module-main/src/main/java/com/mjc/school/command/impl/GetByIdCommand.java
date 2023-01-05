package com.mjc.school.command.impl;

import com.mjc.school.command.Command;
import com.mjc.school.controller.Controller;
import com.mjc.school.dto.NewsDTO;

import java.util.Scanner;

public class GetByIdCommand extends Command {

    public GetByIdCommand(Controller<NewsDTO> controller) {
        super(controller);
    }
    @Override
    public void execute(Scanner sc) {
        System.out.println("Get by Id command");
    }
}
