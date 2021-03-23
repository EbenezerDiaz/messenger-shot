package com.messengershot.service;

import com.messengershot.dao.MessengerDAO;
import com.messengershot.domain.Message;

import java.util.Date;
import java.util.Scanner;

public class MessengerService {

    public static void addMessageDB(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your message");
        String messageStr = scanner.nextLine();

        System.out.println("What is your name?");
        String author = scanner.nextLine();

        Message record = new Message() ;
        record.setMessage(messageStr);
        record.setMessageAuthor(author);
        record.setMessageDate(new Date());

        MessengerDAO.addMessageDB(record);
    }

    public static void readMessagesDB(){
        MessengerDAO.readMessagesDB();
    }

    public static void deleteMessageDB(){
        Scanner scanner = new Scanner(System.in);
        MessengerDAO.readMessagesDB();
        System.out.println("What messages do you want to delete?");
        Integer id = scanner.nextInt();
        MessengerDAO.deleteMessageDB(id);
    }

    public static void updateMessageDB(){
        Scanner scanner = new Scanner(System.in);
        MessengerDAO.readMessagesDB();
        System.out.println("What is your new message?");
        String messageStr = scanner.nextLine();
        System.out.println("What messages do you want to update?");
        Integer id = scanner.nextInt();


        Message record = new Message();
        record.setIdMessage(id);
        record.setMessage(messageStr);

        MessengerDAO.updateMessageDB(record);
    }
}
