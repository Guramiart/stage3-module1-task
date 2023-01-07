package com.mjc.school.command.impl;

import com.mjc.school.command.Command;
import com.mjc.school.constants.Constants;
import com.mjc.school.constants.ServiceConstants;
import com.mjc.school.controller.Controller;
import com.mjc.school.dto.NewsDTO;
import com.mjc.school.exception.ServiceException;

import java.util.Scanner;

public class DeleteCommand extends Command {

    public DeleteCommand(Controller<NewsDTO> controller) {
        super(controller);
    }

    @Override
    public void execute(Scanner sc) {
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.println(Constants.OPERATION_DELETE);
                System.out.println(Constants.RESP_NEWS_ID);
                Long id = getNumberFromScanner("News", sc);
                System.out.println(controller.delete(id));
                isValid = true;
            }
            catch (ServiceException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
