package hu.schonherz.training.managedbeans.request;

import hu.schonherz.training.managedbeans.application.MBMessages;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "addMessage")
@RequestScoped
public class MBAddMessage {

    @ManagedProperty(value = "#{messages}")
    private MBMessages messages;

    public MBMessages getMessages() {
        return messages;
    }

    public void setMessages(MBMessages messages) {
        this.messages = messages;
    }
}
