package ru.innopolis.stc13._12_JDBC.realExample.dao;

import ru.innopolis.stc13._12_JDBC.realExample.ConnectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc13._12_JDBC.realExample.ConnectionManager.ConnectionManeger;
import ru.innopolis.stc13._12_JDBC.realExample.pojo.Manufacturer;
import ru.innopolis.stc13._12_JDBC.realExample.pojo.Mobile;

import java.sql.*;

public class MobileDaoJdbcImpl implements MobileDao {
    private static ConnectionManeger connectionManeger = ConnectionManagerJdbcImpl.getInstance();
    ManufacturerDao manufacturerDao = new ManufacturerDaoJdbcImpl();
    @Override
    public int add(Mobile mobile) {
        int i =0;
        try(Connection connection = connectionManeger.getConnection()) {
//            String generatedKeys[]= {"id"};
            Manufacturer manufacturer = manufacturerDao.getById(mobile.getManufacturer().getId());
            int idOfManufacrurer;
            if (manufacturer == null){
                idOfManufacrurer = manufacturerDao.add(mobile.getManufacturer());
            } else {
                idOfManufacrurer = manufacturer.getId();
            }
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mobile VALUES (DEFAULT, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, mobile.getModel());
            preparedStatement.setFloat(2, mobile.getPrice());
            preparedStatement.setInt(3, idOfManufacrurer);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if ( resultSet.next() ) {
                i = (int) resultSet.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return i;
    }

    @Override
    public Mobile getById(Integer id) {
        try(Connection connection = connectionManeger.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mobile WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Mobile mobile = new Mobile(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getFloat(3),
                        manufacturerDao.getById(resultSet.getInt(4))
                );
                return mobile;
            }
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Mobile mobile) {
        try(Connection connection = connectionManeger.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE mobile SET model = ?, price = ?, monufacturer_id = ? WHERE id = ?");
            preparedStatement.setString(1, mobile.getModel());
            preparedStatement.setFloat(2, mobile.getPrice());
            preparedStatement.setInt(3, mobile.getManufacturer().getId());
            preparedStatement.setInt(4, mobile.getId());
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
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM mobile WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
