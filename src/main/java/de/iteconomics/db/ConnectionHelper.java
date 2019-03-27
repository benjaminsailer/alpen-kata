package de.iteconomics.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

    private static final String URL = "jdbc:h2:mem:mountains;";
    private static final String URL_INIT = "jdbc:h2:mem:mountains;INIT=RUNSCRIPT FROM 'classpath:init.sql'";

    private static ConnectionHelper instance;

    private ConnectionHelper() {
        try {
            System.out.println("Loading driver...");
            Class.forName("org.h2.Driver");
            System.out.println("Initializing Tables...");
            if (getConnection(URL_INIT) == null) {
                throw new SQLException("Error on dbinit");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("driver load or dbinit failed", e);
        }
    }

    public static ConnectionHelper getInstance() {
        if (instance == null) {
            instance = new ConnectionHelper();
        }
        return instance;
    }

    public Connection getConnection() {
        return getConnection(URL);
    }

    private Connection getConnection(String url) {
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException("connection retrieval failed for url " + url, e);
        }
    }

}
