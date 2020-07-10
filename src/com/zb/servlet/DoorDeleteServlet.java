package com.zb.servlet;

import com.zb.dao.DoorDao;
import com.zb.pojo.Door;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/doorDelete")
public class DoorDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id =Integer.parseInt(request.getParameter("id"));
        System.out.println();
        Door door = new Door();
        door.setId(id);
        DoorDao doorDao = new DoorDao();
        try {
            doorDao.deleteDao(door);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/doorList");

    }
}
