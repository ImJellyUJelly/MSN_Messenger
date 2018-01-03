package Client.Business;

import Client.Business.Enums.MessageStatusType;

import java.util.Date;

public class Message {
    private String text;
    private Date sendTime;
    private IUser sender;
    private IUser receiver;
    private MessageStatusType status;

    public Message(String text, IUser sender, IUser receiver) {
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
        this.sendTime = new Date();
        status = MessageStatusType.Concept;
    }
}
