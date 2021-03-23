package com.messengershot.connection;

import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnection {

    public Connection getConnection(){
        Connection connection = null;

        try(InputStream input = getClass().getResourceAsStream("/config_db.properties") ){

            Properties pros = new Properties();
            pros.load(input);

            // assign db parameters
            String url       = pros.getProperty("url");
            String user      = pros.getProperty("user");
            String password  = pros.getProperty("password");

            connection = DriverManager.getConnection(url,user, password );
            if(connection != null){
                System.out.println("Successful Connection");
            }

        }catch(IOException e) {
        System.out.println(e.getMessage());
            System.out.println(e);

        }catch (SQLException sqlException){
            System.err.println("Error Connection....");
            System.err.println(sqlException.getMessage());
            System.out.println(sqlException);
        }
        return connection;
    }
}
