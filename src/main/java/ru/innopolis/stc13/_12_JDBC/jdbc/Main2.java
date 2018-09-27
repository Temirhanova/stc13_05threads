package ru.innopolis.stc13._12_JDBC.jdbc;

import java.sql.*;

public class Main2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mobile",
                "postgres",
                "1234");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mobile WHERE model = ? AND price < ?");
        preparedStatement.setString(1,"c25");
        preparedStatement.setFloat(2, 20000);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.print("model=" + resultSet.getString("model"));
            System.out.print("; price=" + resultSet.getFloat("price"));
            System.out.println("; monufacturer_id=" + resultSet.getInt("monufacturer_id"));
        }
        connection.close();
    }
}
