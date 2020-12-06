package by.Anastasiya.restaurant.controller;

import by.Anastasiya.restaurant.controller.CommandName;
import by.Anastasiya.restaurant.controller.command.Command;
import by.Anastasiya.restaurant.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignInCommand());
        repository.put(CommandName.REGISTRATION, new RegistrationCommand());
        repository.put(CommandName.SIGN_OUT, new SignOutCommand());
        repository.put(CommandName.CHANGE_LOCALE, new ChangeLocaleCommand());
        repository.put(CommandName.GO_TO_LOGIN, new GoToLoginCommand());
        repository.put(CommandName.GO_TO_REGISTER, new GoToRegistrationCommand());
        repository.put(CommandName.GO_TO_MAIN, new GoToMainPageCommand());
        repository.put(CommandName.GO_TO_MENU, new GoToMenuCommand());
        repository.put(CommandName.GET_ITEMS, new GetItemsCommand());
        repository.put(CommandName.SHOW_ITEM, new ShowItemCommand());
        repository.put(CommandName.ADD_TO_ORDER, new AddToOrderCommand());
        repository.put(CommandName.DEL_FROM_ORDER, new DeleteFromOrderCommand());
        repository.put(CommandName.GET_ORDER, new GetOrderCommand());
        repository.put(CommandName.CONFIRM_ORDER, new ConfirmOrderCommand());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequestCommand());
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        }
        catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
