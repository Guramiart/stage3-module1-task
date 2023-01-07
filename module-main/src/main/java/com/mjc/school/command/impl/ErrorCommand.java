package com.mjc.school.command.impl;

import com.mjc.school.command.Command;
import com.mjc.school.constants.Constants;
import com.mjc.school.constants.ServiceConstants;
import com.mjc.school.controller.Controller;
import com.mjc.school.dto.NewsDTO;

import java.util.Scanner;

public class ErrorCommand extends Command {

    public ErrorCommand(Controller<NewsDTO> controller) {
        super(controller);
    }
    @Override
    public void execute(Scanner sc) {
        System.out.println(Constants.OPERATION_ERROR);
    }
}
