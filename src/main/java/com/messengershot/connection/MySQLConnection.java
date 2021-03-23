package com.messengershot.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    public Connection getConnection(){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/messenger_shot","messenger_shot_apl", "W7nBwg2F3KlFts6EJhrA" );
            if(connection != null){
                System.out.println("Successful Connection");
            }

        }catch (SQLException sqlException){
            System.err.println("Error Connection....");
            System.err.println(sqlException.getMessage());
            System.out.println(sqlException);
        }
        return connection;
    }
}
