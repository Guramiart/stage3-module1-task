package com.mjc.school.command.impl;

import com.mjc.school.command.Command;
import com.mjc.school.constants.Constants;
import com.mjc.school.controller.Controller;
import com.mjc.school.dto.NewsDTO;

import java.util.Scanner;

public class UpdateCommand extends Command {

    public UpdateCommand(Controller<NewsDTO> controller) {
        super(controller);
    }
    @Override
    public void execute(Scanner sc) {
        System.out.println(Constants.OPERATION_UPDATE);
        System.out.println(Constants.RESP_NEWS_ID);
        String id = sc.nextLine();
        System.out.println(Constants.RESP_TITLE);
        String title = sc.nextLine();
        System.out.println(Constants.RESP_CONTENT);
        String content = sc.nextLine();
        System.out.println(Constants.RESP_AUTHOR_ID);
        String authorId = sc.nextLine();
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setId(Long.parseLong(id));
        newsDTO.setTitle(title);
        newsDTO.setContent(content);
        newsDTO.setAuthorId(Long.parseLong(authorId));
        System.out.println(controller.update(newsDTO));
    }
}
