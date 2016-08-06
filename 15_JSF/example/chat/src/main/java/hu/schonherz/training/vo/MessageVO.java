package hu.schonherz.training.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ikant on 2016. 08. 06..
 */
public class MessageVO implements Serializable {
    private String userName;
    private Date messageTime;
    private String message;

    public MessageVO(String userName, Date messageTime, String message) {
        this.userName = userName;
        this.messageTime = messageTime;
        this.message = message;
    }

    public MessageVO() {
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public String getMessage() {
        return message;
    }
}
