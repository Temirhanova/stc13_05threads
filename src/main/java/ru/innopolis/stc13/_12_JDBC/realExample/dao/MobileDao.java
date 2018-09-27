package ru.innopolis.stc13._12_JDBC.realExample.dao;

import ru.innopolis.stc13._12_JDBC.realExample.pojo.Mobile;

public interface MobileDao {
    int add(Mobile mobile);
    Mobile getById(Integer id);
    boolean update(Mobile mobile);
    boolean deleteById(Integer id);
}
