package com.mjc.school.command.impl;

import com.mjc.school.command.Command;
import com.mjc.school.constants.Constants;
import com.mjc.school.controller.Controller;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exception.ServiceException;

import java.util.Scanner;

public class UpdateCommand extends Command {

    public UpdateCommand(Controller<NewsDto> controller) {
        super(controller);
    }
    @Override
    public void execute(Scanner sc) {
        boolean isValid = false;
        while(!isValid) {
            try {
                System.out.println(Constants.OPERATION_UPDATE);
                System.out.println(Constants.RESP_NEWS_ID);
                Long newsId = getNumberFromScanner("News", sc);
                System.out.println(Constants.RESP_TITLE);
                String title = sc.nextLine();
                System.out.println(Constants.RESP_CONTENT);
                String content = sc.nextLine();
                System.out.println(Constants.RESP_AUTHOR_ID);
                Long authorId = getNumberFromScanner("Author", sc);
                NewsDto newsDTO = NewsDto.getBuilder()
                        .setId(newsId)
                        .setTitle(title)
                        .setContent(content)
                        .setAuthorId(authorId)
                        .build();
                System.out.println(controller.update(newsDTO));
                isValid = true;
            } catch (ServiceException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
