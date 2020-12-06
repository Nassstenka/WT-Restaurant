package by.Anastasiya.restaurant.controller;

import by.Anastasiya.restaurant.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    private static final String REQUEST_PARAMETER_COMMAND = "command";
    private static final String LAST_REQUEST_PARAM = "lastRequest";

    public Controller() {
        super();
    }

    private final CommandProvider provider = new CommandProvider();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processGetRequest(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processPostRequest(req, resp);
    }

    private void processGetRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String commandName;
        Command executionCommand;

        commandName = req.getParameter(REQUEST_PARAMETER_COMMAND);

        executionCommand = provider.getCommand(commandName);
        executionCommand.execute(req,resp);

        req.getSession(true).setAttribute(LAST_REQUEST_PARAM, req.getRequestURI() + "?" + req.getQueryString());
    }

    private void processPostRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String commandName;
        Command executionCommand;

        commandName = req.getParameter(REQUEST_PARAMETER_COMMAND);
        executionCommand = provider.getCommand(commandName);

        executionCommand.execute(req,resp);
    }

}
