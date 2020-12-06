package by.Anastasiya.restaurant.controller.command.impl;

import by.Anastasiya.restaurant.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToMainPageCommand implements Command {

    private static final String MAIN_PAGE_URI = "index.jsp";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE_URI);
        dispatcher.forward(req, resp);
    }
}