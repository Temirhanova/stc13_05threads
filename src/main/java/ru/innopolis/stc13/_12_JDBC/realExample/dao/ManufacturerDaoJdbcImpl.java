package ru.innopolis.stc13._12_JDBC.realExample.dao;

import ru.innopolis.stc13._12_JDBC.realExample.ConnectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc13._12_JDBC.realExample.ConnectionManager.ConnectionManeger;
import ru.innopolis.stc13._12_JDBC.realExample.pojo.Manufacturer;
import ru.innopolis.stc13._12_JDBC.realExample.pojo.Mobile;

import java.sql.*;

public class ManufacturerDaoJdbcImpl implements ManufacturerDao {
    private static ConnectionManeger connectionManeger = ConnectionManagerJdbcImpl.getInstance();
    @Override
    public int add(Manufacturer manufacturer) {
        int i = 0;
        try(Connection connection = connectionManeger.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO manufacturer VALUES (DEFAULT, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, manufacturer.getName());
            preparedStatement.setString(2, manufacturer.getCountry());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if ( resultSet.next() ) {
                i = (int) resultSet.getInt("id");
                manufacturer.setId(i);
                System.out.println(i);}
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return i;
    }

    @Override
    public Manufacturer getById(Integer id) {
        try(Connection connection = connectionManeger.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM manufacturer WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Manufacturer manufacturer = new Manufacturer(0,
                        resultSet.getString(1),
                        resultSet.getString(2)
                );
                return manufacturer;
            }
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Manufacturer manufacturer) {
        try(Connection connection = connectionManeger.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE manufacturer SET name = ?, counry = ? WHERE id = ?");
            preparedStatement.setString(1, manufacturer.getName());
            preparedStatement.setString(2, manufacturer.getCountry());
            preparedStatement.setInt(3, manufacturer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(Integer id) {
        try(Connection connection = connectionManeger.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM manufacturer WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
