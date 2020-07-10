package com.zb.servlet;

import com.zb.dao.OrderDao;
import com.zb.pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/orderDelete")
public class OrderDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id =Integer.parseInt(request.getParameter("id"));
        System.out.println();
        Order order = new Order();
        order.setId(id);
        OrderDao orderDao = new OrderDao();
        try {
            orderDao.deleteOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/orderList");

    }
}
