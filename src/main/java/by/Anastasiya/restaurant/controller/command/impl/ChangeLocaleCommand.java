package by.Anastasiya.restaurant.controller.command.impl;

import by.Anastasiya.restaurant.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeLocaleCommand implements Command {

    private static final String REDIRECT_COMMAND = "Controller?command=go_to_main";
    private static final String LAST_REQUEST_ATTR = "lastRequest";
    private static final String LOCAL_SESSION_ATTR = "local";
    private static final String LOCAL_REQ_ATTR = "local";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);
        session.setAttribute(LOCAL_SESSION_ATTR, req.getParameter(LOCAL_REQ_ATTR));

        if (session.getAttribute(LAST_REQUEST_ATTR) != null)
        {
            resp.sendRedirect(session.getAttribute(LAST_REQUEST_ATTR).toString());
        }
        else {
            resp.sendRedirect(REDIRECT_COMMAND);
        }

    }
}
