package com.messengershot.app;

import com.messengershot.connection.MySQLConnection;

import java.sql.Connection;

public class main {

    public static void main (String args[]){

        MySQLConnection connection = new MySQLConnection();

        try(Connection cnx = connection.getConnection()){

        }catch (Exception e){
            System.out.println(e);
        }

    }
}
