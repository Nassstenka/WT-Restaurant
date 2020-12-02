package controller.command;

import model.exception.CommandException;
import model.exception.ServiceException;
import model.service.ServiceFactory;
import model.service.UserService;

public class SignInCommand implements Command {

    public String execute(String request) throws CommandException {
        String login = null;
        String password = null;

        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();
        try {
            userService.signIn(login, password);
        } catch (ServiceException e) {
           //!! e.printStackTrace();
        }
        response = "Welcome";
        return response;
    }
}
