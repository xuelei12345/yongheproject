package com.zb.dao;

import com.zb.pojo.Order;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public List<Order> findAll() throws Exception {
        Connection conn = DBUtils.getConnectionByDataSource();
        String sql = "select * from tb_order";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        Order order = null;
        List<Order> list = new ArrayList<Order>();
        while(rs.next()){
            order=new Order();
            order.setId(rs.getInt("id"));
            order.setDoor_id(rs.getInt("door_id"));
            order.setOrder_no(rs.getString("order_no"));
            order.setOrder_type(rs.getString("order_type"));
            order.setPnum(rs.getInt("pnum"));
            order.setCashier(rs.getString("cashier"));
            order.setOrder_time(rs.getTimestamp("order_time"));
            order.setPay_time(rs.getTimestamp("pay_time"));
            order.setPay_type(rs.getString("pay_type"));
            order.setPrice(rs.getDouble("price"));
            list.add(order);

        }
        /*System.out.println(list);*/
        return list;

    }

    public void addOrder(Order order) throws SQLException {
        Connection conn = DBUtils.getConnectionByDataSource();
        String sql = "insert into tb_order values (null,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,order.getDoor_id());
        ps.setString(2,order.getOrder_no());
        ps.setString(3,order.getOrder_type());
        ps.setInt(4,order.getPnum());
        ps.setString(5,order.getCashier());
        ps.setDate(6, new java.sql.Date(order.getOrder_time().getTime()));
        ps.setDate(7, new java.sql.Date(order.getPay_time().getTime()));
        ps.setString(8,order.getPay_type());
        ps.setDouble(9,order.getPrice());
        ps.executeUpdate();

    }


    public void deleteOrder(Order order) throws SQLException {
        Connection conn = DBUtils.getConnectionByDataSource();
        String sql = "delete from tb_order where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,order.getId());
        ps.executeUpdate();
    }

    public List<Order> selectOrderById(Order order) throws SQLException {
        Connection conn = DBUtils.getConnectionByDataSource();
        String sql = "select * from tb_order where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,order.getId());
        ResultSet rs=ps.executeQuery();
        Order ordera = null;
        List<Order> list = new ArrayList<Order>();
        while(rs.next()){
            ordera=new Order();


            ordera.setDoor_id(rs.getInt("door_id"));
            ordera.setOrder_no(rs.getString("order_no"));
            ordera.setOrder_type(rs.getString("order_type"));
            ordera.setPnum(rs.getInt("pnum"));
            ordera.setCashier(rs.getString("cashier"));
            ordera.setOrder_time(rs.getTimestamp("order_time"));
            ordera.setPay_time(rs.getTimestamp("pay_time"));
            ordera.setPay_type(rs.getString("pay_type"));
            ordera.setPrice(rs.getDouble("price"));
            ordera.setId(rs.getInt("id"));
            list.add(ordera);

        }
        /*System.out.println(list);*/
        return list;

    }
    public void updateOrder(Order order) throws SQLException {
        Connection conn = DBUtils.getConnectionByDataSource();
        String sql = "update tb_order set door_id = ?,order_no = ?,order_type = ?,pnum = ?,cashier = ?,order_time = ?,pay_time = ?,pay_type = ?,price = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,order.getDoor_id());
        ps.setString(2,order.getOrder_no());
        ps.setString(3,order.getOrder_type());
        ps.setInt(4,order.getPnum());
        ps.setString(5,order.getCashier());
        ps.setDate(6, new java.sql.Date(order.getOrder_time().getTime()));
        ps.setDate(7, new java.sql.Date(order.getPay_time().getTime()));
        ps.setString(8,order.getPay_type());
        ps.setDouble(9,order.getPrice());
        ps.setInt(10,order.getId());
        ps.executeUpdate();

    }
}
