package by.Anastasiya.restaurant.controller.command.impl;

import by.Anastasiya.restaurant.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOutCommand implements Command {

    private static final String REDIRECT_COMMAND = "Controller?command=go_to_main";
    private static final String USER_SESSION_ATTR = "user";
    private static final String ORDER_ID_SESSION_ATTR = "orderId";


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.removeAttribute(USER_SESSION_ATTR);
        session.removeAttribute(ORDER_ID_SESSION_ATTR);
        resp.sendRedirect(REDIRECT_COMMAND);
    }
}
