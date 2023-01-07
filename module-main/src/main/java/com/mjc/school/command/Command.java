package com.mjc.school.command;

import com.mjc.school.controller.Controller;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exception.ArgumentValidException;
import com.mjc.school.service.exception.ErrorCode;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Command {

    protected final Controller<NewsDto> controller;

    protected Command(Controller<NewsDto> controller) {
        this.controller = controller;
    }
    public abstract void execute(Scanner sc);

    protected Long getNumberFromScanner(String param, Scanner sc) throws ArgumentValidException {
        try {
            Long id = sc.nextLong();
            sc.nextLine();
            return id;
        } catch (InputMismatchException e) {
            sc.nextLine();
            throw new ArgumentValidException(String.format(
                    ErrorCode.NOT_NUMBER.getErrorMessage(), param));
        }
    }

}
