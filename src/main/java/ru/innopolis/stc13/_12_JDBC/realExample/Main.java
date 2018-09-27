package ru.innopolis.stc13._12_JDBC.realExample;

import ru.innopolis.stc13._12_JDBC.realExample.dao.ManufacturerDao;
import ru.innopolis.stc13._12_JDBC.realExample.dao.ManufacturerDaoJdbcImpl;
import ru.innopolis.stc13._12_JDBC.realExample.dao.MobileDao;
import ru.innopolis.stc13._12_JDBC.realExample.dao.MobileDaoJdbcImpl;
import ru.innopolis.stc13._12_JDBC.realExample.pojo.Manufacturer;
import ru.innopolis.stc13._12_JDBC.realExample.pojo.Mobile;

public class Main {
    public static void main(String[] args) {
        Manufacturer manufacturer = new Manufacturer(0, "Apple", "USA");
        ManufacturerDao manufacturerDao = new ManufacturerDaoJdbcImpl();
        int add = manufacturerDao.add(manufacturer);
        manufacturerDao.getById(add);
        manufacturer.setName("Simense");
        manufacturerDao.update(manufacturer);
        manufacturerDao.deleteById(add);
        System.out.println(manufacturer);
        Mobile mobile = new Mobile(0,"Iphone 2", 25000F, manufacturer);
        MobileDao mobileDao = new MobileDaoJdbcImpl();
        int addMobile = mobileDao.add(mobile);
        mobileDao.getById(addMobile);
        System.out.println(mobile);
        mobile.setPrice(788F);
        mobileDao.update(mobile);
        System.out.println(mobile);
        mobileDao.deleteById(addMobile);
    }
}
