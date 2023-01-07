package com.mjc.school.factory;

import com.mjc.school.command.Command;
import com.mjc.school.command.impl.*;
import com.mjc.school.controller.Controller;
import com.mjc.school.service.dto.NewsDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OperationFactory {

    private enum OperationKind {
        GET_ALL(1, "Get all news") {
            @Override
            Command getCommand(Controller<NewsDTO> controller) {
                return new GetAllCommand(controller);
            }
        },
        GET_BY_ID(2, "Get news by id") {
            @Override
            Command getCommand(Controller<NewsDTO> controller) {
                return new GetByIdCommand(controller);
            }
        },
        CREATE(3, "Create news") {
            @Override
            Command getCommand(Controller<NewsDTO> controller) {
                return new CreateCommand(controller);
            }
        },
        UPDATE(4, "Update news") {
            @Override
            Command getCommand(Controller<NewsDTO> controller) {
                return new UpdateCommand(controller);
            }
        },
        DELETE(5, "Delete news") {
            @Override
            Command getCommand(Controller<NewsDTO> controller) {
                return new DeleteCommand(controller);
            }
        },
        EXIT(0, "Exit") {
            @Override
            Command getCommand(Controller<NewsDTO> controller) {
                return new ExitCommand(controller);
            }
        };

        private final int id;
        private final String name;
        OperationKind(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return id + " - " + name;
        }

        abstract Command getCommand(Controller<NewsDTO> controller);
    }

    public static Command getCommand(Scanner sc, Controller<NewsDTO> controller) {
        int id = Integer.parseInt(sc.nextLine());
        if(id >= 0 && id <= 5) {
            return Arrays.stream(OperationKind.values())
                    .filter(e -> id == e.id)
                    .findFirst()
                    .get()
                    .getCommand(controller);
        } else {
            return new ErrorCommand(controller);
        }
    }

    public static List<String> getOperationList() {
        return Arrays.stream(OperationKind.values()).map(OperationKind::toString).collect(Collectors.toList());
    }

}
