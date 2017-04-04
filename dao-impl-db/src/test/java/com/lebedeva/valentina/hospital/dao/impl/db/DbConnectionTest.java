package com.lebedeva.valentina.hospital.dao.impl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectionTest {
    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hospital", "postgres", "postgres");
            System.out.println("Соединение установлено.");

            Statement createStatement = con.createStatement();
            createStatement.execute("select * from department order by id");
            

           
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                   // System.out.println("Соединение закрыто.");
                }
            } catch (SQLException e) {
            }
        }
    }
}
