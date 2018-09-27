package ru.innopolis.stc13._12_JDBC.realExample.dao;

import ru.innopolis.stc13._12_JDBC.realExample.pojo.Manufacturer;

public interface ManufacturerDao {
    int add(Manufacturer manufacturer);
    Manufacturer getById(Integer id);
    boolean update(Manufacturer manufacturer);
    boolean deleteById(Integer id);
}
