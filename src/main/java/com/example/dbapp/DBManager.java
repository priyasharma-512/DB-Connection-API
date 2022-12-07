package com.example.dbapp;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class DBManager {


    public Connection connection;
    public DBManager() throws SQLException{
        getConnection();
        create();
    }

    public Connection getConnection() throws SQLException {
        if(connection==null)
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root", "rootroot");
        }
        return connection;
    }

    public void create() throws SQLException {
        String sql = "create table if not exists studentinfo(id int primary key auto_increment, age INT, name VARCHAR(30))";
        Statement st = connection.createStatement();
        boolean b = st.execute(sql);
        System.out.println(b);
    }

    public void insertinfo(student s) throws SQLException {
        String sql = "insert into studentinfo(age,name) values("+s.getAge()+",'"+s.getName()+"')";
        Statement st = connection.createStatement();
        int rows =  st.executeUpdate(sql);
        System.out.println(rows);
    }

    public void getinfo() throws SQLException {
        String sql = "select * from studentinfo";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while(rs.next())
        {
            String name = rs.getString("name");
            String age = rs.getString("age");
            String id = rs.getString("id");

            System.out.println(name+ " " +age+ " " +id);
        }

    }
}
