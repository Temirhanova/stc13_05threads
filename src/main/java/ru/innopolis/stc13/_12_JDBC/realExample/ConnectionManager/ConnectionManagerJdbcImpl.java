package ru.innopolis.stc13._12_JDBC.realExample.ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerJdbcImpl implements ConnectionManeger{
    private static ConnectionManeger connectionManeger;

    private ConnectionManagerJdbcImpl() {
    }

    public static ConnectionManeger getInstance() {
        if(connectionManeger == null) {
            connectionManeger = new ConnectionManagerJdbcImpl();
        }
        return connectionManeger;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mobile",
                    "postgres",
                    "1234");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
