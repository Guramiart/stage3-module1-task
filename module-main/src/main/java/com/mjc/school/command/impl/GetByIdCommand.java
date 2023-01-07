package com.mjc.school.command.impl;

import com.mjc.school.command.Command;
import com.mjc.school.constants.Constants;
import com.mjc.school.controller.Controller;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exception.ServiceException;

import java.util.Scanner;

public class GetByIdCommand extends Command {

    public GetByIdCommand(Controller<NewsDto> controller) {
        super(controller);
    }
    @Override
    public void execute(Scanner sc) {
        boolean isValid = false;
        while(!isValid) {
            try {
                System.out.println(Constants.OPERATION_GET_BY_ID);
                System.out.println(Constants.RESP_NEWS_ID);
                Long newsId = getNumberFromScanner("News", sc);
                System.out.println(controller.readById(newsId));
                isValid = true;
            } catch (ServiceException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
