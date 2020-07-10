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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



@WebServlet("/orderAdd")
public class OrderAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer door_id = Integer.parseInt(request.getParameter("door_id"));
        System.out.println(door_id);
        String order_no = request.getParameter("order_no");
        String order_type = request.getParameter("order_type");
        Integer pnum = Integer.parseInt(request.getParameter("pnum"));
        String cashier = request.getParameter("cashier");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date order_time = null;

        try {
            order_time = formatter.parse(request.getParameter("order_time"));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

     Date pay_time = null;

        try {
            pay_time = formatter.parse(request.getParameter("pay_time"));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        /*String order_time =request.getParameter("order_time");
        String  pay_time = request.getParameter("pay_time");*/
        String pay_type = request.getParameter("pay_type");
        Double price =Double.parseDouble(request.getParameter("price"));
        Order order = new Order();
        order.setDoor_id(door_id);
        order.setOrder_no(order_no);
        order.setOrder_type(order_type);
        order.setPnum(pnum);
        order.setCashier(cashier);
        order.setOrder_time(order_time);
        order.setPay_time(pay_time);
        order.setPay_type(pay_type);
        order.setPrice(price);
        OrderDao orderDao = new OrderDao();
        try {
            orderDao.addOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/orderList");
    }

    }

