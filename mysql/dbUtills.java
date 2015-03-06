package com.temp.mysql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by DV21 on 06-03-2015.
 */
public class dbUtills {

    private static dbConfig config;
    private static Connection connection;

    public static void initConfig() throws IOException {
        config = new dbConfig();
    }

    public static dbConfig getConfig() {
        return config;
    }

    public static void initDB() throws ClassNotFoundException, SQLException {
        Class.forName( config.getPropertyValue( config._DRIVERCLASS ) );
        connection = DriverManager.getConnection( config.getPropertyValue( config._DB_URL ) , config.getPropertyValue( config._DB_USERNAME ) ,
                            config.getPropertyValue( config._DB_PASSWORD ) );
    }
    public static Connection getConnection() {
        return connection;
    }
}
