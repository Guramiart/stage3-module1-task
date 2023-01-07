package com.mjc.school.command.impl;

import com.mjc.school.command.Command;
import com.mjc.school.constants.Constants;
import com.mjc.school.controller.Controller;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exception.ServiceException;

import java.util.Scanner;

public class CreateCommand extends Command {

    public CreateCommand(Controller<NewsDto> controller) {
        super(controller);
    }
    @Override
    public void execute(Scanner sc) {
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.println(Constants.OPERATION_CREATE);
                System.out.println(Constants.RESP_TITLE);
                String title = sc.nextLine();
                System.out.println(Constants.RESP_CONTENT);
                String content = sc.nextLine();
                System.out.println(Constants.RESP_AUTHOR_ID);
                Long authorId = getNumberFromScanner("Author", sc);
                NewsDto newsDTO = NewsDto.getBuilder()
                        .setTitle(title)
                        .setContent(content)
                        .setAuthorId(authorId)
                        .build();
                System.out.println(controller.create(newsDTO));
                isValid = true;
            } catch (ServiceException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
