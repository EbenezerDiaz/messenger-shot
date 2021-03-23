package com.messengershot.app;

import com.messengershot.connection.DBConnection;
import com.messengershot.connection.MySQLConnection;
import com.messengershot.service.MessengerService;

import java.sql.Connection;
import java.util.Scanner;

public class main {

    public static void main (String args[]){

        DBConnection connection = new MySQLConnection();

        try(Connection cnx = connection.getConnection()){

            Scanner scanner = new Scanner(System.in);
            int option = 0;

            do{
                System.out.println("---------------------------");
                System.out.println("Messages application");
                System.out.println("1. Create Message");
                System.out.println("2. Read Messages");
                System.out.println("3. Update Message");
                System.out.println("4. Delete Message");
                System.out.println("5. Exit");

                option = scanner.nextInt();

                switch (option){
                    case 1:
                        MessengerService.addMessageDB();
                        break;
                    case 2:
                        MessengerService.readMessagesDB();
                        break;
                    case 3:
                        MessengerService.updateMessageDB();
                        break;
                    case 4:
                        MessengerService.deleteMessageDB();
                        break;
                    case 5:
                        System.out.println("Bye !!!");
                        break;
                    default:
                        System.out.println("Invalid Option...");
                        break;
                }

            }while(option != 5);

        }catch (Exception e){
            System.out.println(e);
        }

    }
}
