package by.Anastasiya.restaurant.controller.command.impl;

import by.Anastasiya.restaurant.controller.command.Command;
import by.Anastasiya.restaurant.model.beans.Order;
import by.Anastasiya.restaurant.model.exception.ServiceException;
import by.Anastasiya.restaurant.model.service.IOrderService;
import by.Anastasiya.restaurant.model.service.ServiceFactory;
import by.Anastasiya.restaurant.model.service.impl.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ConfirmOrderCommand implements Command {

    private static final String REDIRECT_COMMAND = "Controller?command=get_cart";
    private static final String ORDER_ID_SESSION_ATTR = "orderId";
    private static final String CONFIRM_OK = "&confirm=ok&orderId=";
    private static final String CONFIRM_ERROR = "&confirm=error";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Order order;
        int orderId;

        try {
            orderId = (int) session.getAttribute(ORDER_ID_SESSION_ATTR);

            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            IOrderService orderService = serviceFactory.getOrderService();
            order = orderService.getOrder(orderId);

            orderService.confirmOrder(order);

            resp.sendRedirect(REDIRECT_COMMAND + CONFIRM_OK + orderId);

        } catch (ServiceException e) {
            resp.sendRedirect(REDIRECT_COMMAND + CONFIRM_ERROR);
        }

    }
}