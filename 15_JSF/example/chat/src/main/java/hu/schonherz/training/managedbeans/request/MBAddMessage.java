package hu.schonherz.training.managedbeans.request;

import hu.schonherz.training.managedbeans.application.MBMessages;
import hu.schonherz.training.managedbeans.session.MBUser;
import hu.schonherz.training.vo.MessageVO;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.Date;

@ManagedBean(name = "addMessage")
@RequestScoped
public class MBAddMessage {

    private String message;

    @ManagedProperty(value = "#{messages}")
    private MBMessages messages;
    @ManagedProperty(value = "#{userBean}")
    private MBUser user;

    public void addMessage() {
        MessageVO messageVO = createMessage();
        messages.getMessages().add(messageVO);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("New message added!"));
        this.message = null;
    }

    private MessageVO createMessage() {
        return new MessageVO(user.getName(), new Date(), message);
    }

    public MBMessages getMessages() {
        return messages;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessages(MBMessages messages) {
        this.messages = messages;
    }

    public MBUser getUser() {
        return user;
    }

    public void setUser(MBUser user) {
        this.user = user;
    }
}
