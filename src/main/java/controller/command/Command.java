package controller.command;

import model.exception.CommandException;

public interface Command {
    public String execute(String request) throws CommandException;
}
