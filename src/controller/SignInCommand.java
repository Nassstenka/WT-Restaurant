package controller;

import exception.ServiceException;
import service.ServiceFactory;
import service.UserService;

public class SignInCommand implements Command{
    @Override
    public String execute(String request) {
        String login = null;
        String password = null;

        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();
        try {
            userService.signIn(login, password);
            response = "Welcome";
        }
        catch (ServiceException e) {
            response = "Error during the authorization";
        }
        return response;
    }
}
