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

@WebServlet("/doorUpdate")
public class DoorUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id =new Integer(request.getParameter("id"));
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String addr = request.getParameter("addr");
        Door door = new Door();
        door.setId(id);
        System.out.println(id);
        door.setName(name);
        door.setTel(tel);
        door.setAddr(addr);
        DoorDao doorDao = new DoorDao();
        try {
            doorDao.updateDoor(door);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/doorList");
    }
}
