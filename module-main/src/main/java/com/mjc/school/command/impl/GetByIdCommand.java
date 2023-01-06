package com.mjc.school.command.impl;

import com.mjc.school.command.Command;
import com.mjc.school.constants.Constants;
import com.mjc.school.controller.Controller;
import com.mjc.school.dto.NewsDTO;

import java.util.Scanner;

public class GetByIdCommand extends Command {

    public GetByIdCommand(Controller<NewsDTO> controller) {
        super(controller);
    }
    @Override
    public void execute(Scanner sc) {
        System.out.println(Constants.OPERATION_GET_BY_ID);
        System.out.println(Constants.RESP_NEWS_ID);
        String line = sc.nextLine();
        System.out.println(controller.getNewsById(Long.parseLong(line)));
    }
}
