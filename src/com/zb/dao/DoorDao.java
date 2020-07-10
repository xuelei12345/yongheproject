package com.zb.dao;

import com.zb.pojo.Door;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
* 门店信息数据库操作
* */
public class DoorDao {
    public List<Door> findAll() throws Exception {
        Connection conn = DBUtils.getConnectionByDataSource();
        String sql = "select * from tb_door";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        Door door = null;
        List<Door> list = new ArrayList<Door>();
        while(rs.next()){
            door=new Door();
            door.setId(rs.getInt("id"));
            door.setName(rs.getString("name"));
            door.setTel(rs.getString("tel"));
            door.setAddr(rs.getString("addr"));

            list.add(door);

        }
        /*System.out.println(list);*/
        return list;

    }
    public void addDoor(Door door) throws SQLException {
        Connection conn = DBUtils.getConnectionByDataSource();
        String sql = "insert into tb_door values (null,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,door.getName());
        ps.setString(2,door.getTel());
        ps.setString(3,door.getAddr());
        ps.executeUpdate();

    }
    public void deleteDao(Door door) throws SQLException {
        Connection conn = DBUtils.getConnectionByDataSource();
        String sql = "delete from tb_door where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,door.getId());
        ps.executeUpdate();
    }
    public List<Door> selectDoorById(Door door) throws SQLException {
        Connection conn = DBUtils.getConnectionByDataSource();
        String sql = "select * from tb_door where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,door.getId());
        ResultSet rs=ps.executeQuery();
        Door doora = null;
        List<Door> list = new ArrayList<Door>();
        while(rs.next()){
            doora=new Door();

            doora.setName(rs.getString("name"));
            doora.setTel(rs.getString("tel"));
            doora.setAddr(rs.getString("addr"));
            doora.setId(rs.getInt("id"));

            list.add(doora);

        }
        /*System.out.println(list);*/
        return list;

    }
    public void updateDoor(Door door) throws SQLException {
        Connection conn = DBUtils.getConnectionByDataSource();
        String sql = "update tb_door set name = ?,tel = ?,addr = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,door.getName());
        ps.setString(2,door.getTel());
        ps.setString(3,door.getAddr());
        ps.setInt(4,door.getId());
        ps.executeUpdate();

    }
}
