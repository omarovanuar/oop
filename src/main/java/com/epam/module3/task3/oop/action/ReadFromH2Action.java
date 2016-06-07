package com.epam.module3.task3.oop.action;

import com.epam.module3.task3.oop.entity.Electronics;
import com.epam.module3.task3.oop.interfacee.ReadInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReadFromH2Action implements ReadInterface {
    private int id;
    private List<Electronics> list = new ArrayList<>();

    @Override
    public void read() {
        ResourceBundle rb = ResourceBundle.getBundle("database");
        String driver = rb.getString("driver");
        String url = rb.getString("dbURL");
        String user = rb.getString("user");
        String password = rb.getString("password");
        try {
            Class.forName(driver);
            System.out.println("OK");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found");
        }
        Connection c = null;
        try {
            c = DriverManager.getConnection(url, user, password);
            System.out.println("Connect");
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }
        ResultSet rs = null;
        Statement st = null;
        ResultSetMetaData rsmd;
        try {
            st = c.createStatement();
            rs = st.executeQuery("SELECT * FROM ELECTRONICS");
            rsmd = rs.getMetaData();
            String[] strings = new String[7];
            while (rs.next()) {
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    strings[i] = rs.getString(i+1);
                }
                id = Integer.valueOf(strings[0]);
                list = CreateListFromArrayAction.create(strings);
            }
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {}
            try {
                if (st != null) st.close();
            } catch (SQLException e) {}
            try {
                if (c != null) c.close();
            } catch (SQLException e) {}
        }
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public List<Electronics> getList() {
        return list;
    }
}
