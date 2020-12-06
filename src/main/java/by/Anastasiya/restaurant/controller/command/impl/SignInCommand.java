package by.Anastasiya.restaurant.controller.command.impl;

import by.Anastasiya.restaurant.controller.command.Command;
import by.Anastasiya.restaurant.model.beans.User;
import by.Anastasiya.restaurant.model.exception.ServiceException;
import by.Anastasiya.restaurant.model.service.IOrderService;
import by.Anastasiya.restaurant.model.service.IUserService;
import by.Anastasiya.restaurant.model.service.ServiceFactory;
import by.Anastasiya.restaurant.model.service.impl.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignInCommand implements Command {

    private static final String REQUEST_PARAMETER_USERNAME = "username";
    private static final String REQUEST_PARAMETER_LOGIN = "password";
    private static final String REDIRECT_COMMAND_SUCCESS = "Controller?command=go_to_main&login=success";
    private static final String REDIRECT_COMMAND_ERROR = "Controller?command=go_to_login&login=fail";
    private static final String ORDER_ID_SESSION_ATTR = "orderId";
    private static final String USER_SESSION_ATTR = "user";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String login = req.getParameter(REQUEST_PARAMETER_USERNAME);
        byte[] password = req.getParameter(REQUEST_PARAMETER_LOGIN).getBytes();

        User authorizedUser;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IUserService userService = serviceFactory.getUserService();
        IOrderService orderService = serviceFactory.getOrderService();
        HttpSession session = req.getSession(true);


        try {
            authorizedUser = userService.signIn(login, password);

            if (authorizedUser == null) {
                resp.sendRedirect(REDIRECT_COMMAND_ERROR);
                return;
            }

            int currentOrderId = orderService.getCurrentOrderId(authorizedUser.getUserId());

            session.setAttribute(USER_SESSION_ATTR, authorizedUser);

            if (currentOrderId > 0) {
                session.setAttribute(ORDER_ID_SESSION_ATTR, currentOrderId);
            }

            resp.sendRedirect(REDIRECT_COMMAND_SUCCESS);

        } catch (ServiceException e) {
            // log
            resp.sendRedirect(REDIRECT_COMMAND_ERROR);
        }

    }
}