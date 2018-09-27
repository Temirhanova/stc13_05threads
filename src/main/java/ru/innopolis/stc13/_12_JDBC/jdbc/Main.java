package ru.innopolis.stc13._12_JDBC.jdbc;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mobile",
                "postgres",
                "1234");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM mobile");
        while (resultSet.next()) {
            System.out.print("model=" + resultSet.getString("model"));
            System.out.print("; price=" + resultSet.getFloat("price"));
            System.out.println("; monufacturer_id=" + resultSet.getInt("monufacturer_id"));
        }
        connection.close();
    }
}
