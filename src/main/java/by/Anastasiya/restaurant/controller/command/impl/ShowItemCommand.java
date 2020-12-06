package by.Anastasiya.restaurant.controller.command.impl;

import by.Anastasiya.restaurant.controller.command.Command;
import by.Anastasiya.restaurant.model.exception.ServiceException;
import by.Anastasiya.restaurant.model.service.IDishService;
import by.Anastasiya.restaurant.model.service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowItemCommand implements Command {

    private static final String REQUEST_PARAMETER_ITEM_ID = "id";
    private static final String ITEM_ATTR = "item";
    private static final String REDIRECT_COMMAND_ERROR = "Controller?command=go_to_catalog";
    private static final String ITEM_PAGE_URI = "WEB-INF/jsp/itemInfo.jsp";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IDishService itemService = serviceFactory.getItemService();

        try {
            int itemId = Integer.parseInt(req.getParameter(REQUEST_PARAMETER_ITEM_ID));
            itemService.getItem(itemId);

            req.setAttribute(ITEM_ATTR, itemService.getItem(itemId));
            RequestDispatcher dispatcher = req.getRequestDispatcher(ITEM_PAGE_URI);
            dispatcher.forward(req, resp);

        } catch (ServiceException | NumberFormatException e) {
            resp.sendRedirect(REDIRECT_COMMAND_ERROR);
        }
    }
}