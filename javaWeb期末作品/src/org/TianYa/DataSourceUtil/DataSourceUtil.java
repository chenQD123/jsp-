package org.TianYa.DataSourceUtil;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;

//c3p0连接池
public class DataSourceUtil {
    public static ComboPooledDataSource getDataSourceWithC3P0() {
        ComboPooledDataSource c3p0 = new ComboPooledDataSource();
        try {
            c3p0.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        c3p0.setJdbcUrl("jdbc:mysql://localhost:3306/mysql_shiyan1");
        c3p0.setUser("csy");
        c3p0.setPassword("123456789");
        return c3p0;

    }

    public static ComboPooledDataSource getDataSourceWithC3P0ByXml() {
        ComboPooledDataSource c3p0 = new ComboPooledDataSource("csy");
        return c3p0;

    }
}
