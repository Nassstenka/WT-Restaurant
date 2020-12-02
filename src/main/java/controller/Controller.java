package controller;

import controller.command.Command;

public class Controller {
    private final CommandProvider provider = new CommandProvider();
    private final char paramDelimiter = ' ';

    public String ExecuteTask(String request) {
        String commandName;
        Command executionCommand;

        commandName = request.substring(0, request.indexOf(paramDelimiter));
        executionCommand = provider.getCommand(commandName);

        String response = null;
        response = executionCommand.execute(request);

        return response;
    }
}
