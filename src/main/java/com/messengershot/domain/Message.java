package com.messengershot.domain;


import java.util.Date;

public class Message {

    Integer idMessage;
    String message;
    String messageAuthor;
    Date messageDate;

    public Message() {
    }

    public Message(String message, String messageAuthor, Date messageDate) {

        this.message = message;
        this.messageAuthor = messageAuthor;
        this.messageDate = messageDate;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageAuthor() {
        return messageAuthor;
    }

    public void setMessageAuthor(String messageAuthor) {
        this.messageAuthor = messageAuthor;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }
}
