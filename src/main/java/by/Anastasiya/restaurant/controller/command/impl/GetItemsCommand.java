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

public class GetItemsCommand implements Command {

    private static final String REQUEST_PARAMETER_CATEGORY_ID = "category";
    private static final String REDIRECT_COMMAND_ERROR = "Controller?command=go_to_catalog";
    private static final String ITEMS_PAGE_URI = "WEB-INF/jsp/items.jsp";
    private static final String ITEM_LIST_ATTR = "itemList";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IDishService dishService = serviceFactory.getItemService();
        try {
            int categoryId = Integer.parseInt(req.getParameter(REQUEST_PARAMETER_CATEGORY_ID));

            req.setAttribute(ITEM_LIST_ATTR, dishService.getItemsByCategory(categoryId));
            RequestDispatcher dispatcher = req.getRequestDispatcher(ITEMS_PAGE_URI);
            dispatcher.forward(req, resp);
        } catch (ServiceException | NumberFormatException e) {
            resp.sendRedirect(REDIRECT_COMMAND_ERROR);
        }
    }
}
