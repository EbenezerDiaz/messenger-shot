package com.messengershot.dao;

import com.messengershot.connection.DBConnection;
import com.messengershot.connection.MySQLConnection;
import com.messengershot.domain.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

public class MessengerDAO {

    public static void addMessageDB(Message message){
        DBConnection dbConnection = new MySQLConnection();

        try(Connection connection = dbConnection.getConnection()){

            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO messages (message, message_author, message_date) VALUES (?, ?, ?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, message.getMessage());
                ps.setString(2, message.getMessageAuthor());
                ps.setDate(3, new java.sql.Date(message.getMessageDate().getTime()));

                ps.executeUpdate();
                System.out.println("Save message sussefull");

            }catch (SQLException e){
                System.out.println(e);
            }

        }catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }

    public static void readMessagesDB(){
        DBConnection dbConnection = new MySQLConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection connection = dbConnection.getConnection()){
            String query = "SELECT id_message, message, message_author, message_date FROM messages";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println("*****************************************");
                System.out.println("ID: " + rs.getInt("id_message"));
                System.out.println("Message: " + rs.getString("message"));
                System.out.println("Author: " + rs.getString("message_author"));
                System.out.println("Date: " + rs.getDate("message_date"));
                System.out.println();
            }

        }catch (SQLException sqlException){
            System.out.println("Data could not be retrieved");
            System.out.println(sqlException);
        }
    }

    public static void deleteMessageDB(Integer idMessage){
        DBConnection dbConnection = new MySQLConnection();

        try(Connection connection = dbConnection.getConnection()){
            PreparedStatement ps = null;
            try{
                String query = "DELETE FROM  messages WHERE id_message = ?";
                ps = connection.prepareStatement(query);
                ps.setInt(1,idMessage);

                ps.executeUpdate();
                System.out.println("Delete message sussefull");

            }catch (SQLException e){
                System.out.println("Data could not be deleted");
                System.out.println(e);
            }

        }catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }

    public static void updateMessageDB(Message message){
        DBConnection dbConnection = new MySQLConnection();

        try(Connection connection = dbConnection.getConnection()){
            PreparedStatement ps = null;
            try{
                String query = "UPDATE messages SET message = ? WHERE id_message = ?";
                ps = connection.prepareStatement(query);
                ps.setString(1, message.getMessage());
                ps.setInt(2,message.getIdMessage());

                ps.executeUpdate();
                System.out.println("Update message sussefull");

            }catch (SQLException e){
                System.out.println("Data could not be updated");
                System.out.println(e);
            }

        }catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }
}
