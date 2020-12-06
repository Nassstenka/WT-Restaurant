package by.Anastasiya.restaurant.controller.command.impl;

import by.Anastasiya.restaurant.controller.command.Command;
import by.Anastasiya.restaurant.model.exception.ServiceException;
import by.Anastasiya.restaurant.model.service.IOrderService;
import by.Anastasiya.restaurant.model.service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GetOrderCommand implements Command {

    private static final String CART_PAGE_URI = "WEB-INF/jsp/cart.jsp";
    private static final String REDIRECT_COMMAND_ERROR = "Controller?command=go_to_login";
    private static final String ORDER_ID_SESSION_ATTR = "orderId";
    private static final String ORDER_ATTR = "order";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IOrderService orderService = serviceFactory.getOrderService();
        HttpSession session = req.getSession();

        if (session.getAttribute(ORDER_ID_SESSION_ATTR) != null) {
            try {
                int orderId = (int) session.getAttribute(ORDER_ID_SESSION_ATTR);
                req.setAttribute(ORDER_ATTR, orderService.getOrder(orderId));
            } catch (ServiceException | NumberFormatException e) {
                resp.sendRedirect(REDIRECT_COMMAND_ERROR);
            }
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(CART_PAGE_URI);
        dispatcher.forward(req, resp);

    }
}
