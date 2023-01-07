package com.mjc.school.command.impl;

import com.mjc.school.command.Command;
import com.mjc.school.constants.Constants;
import com.mjc.school.controller.Controller;
import com.mjc.school.service.dto.NewsDto;

import java.util.Scanner;

public class ExitCommand extends Command {

    public ExitCommand(Controller<NewsDto> controller) {
        super(controller);
    }
    @Override
    public void execute(Scanner sc) {
        System.out.println(Constants.OPERATION_EXIT);
        System.exit(0);
    }
}
