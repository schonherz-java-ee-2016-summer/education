package hu.schonherz.training.managedbeans.application;

import hu.schonherz.training.vo.MessageVO;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by ikant on 2016. 08. 06..
 */
@ManagedBean(name = "messages")
@ApplicationScoped
public class MBMessages {
    private Collection<MessageVO> messages = new LinkedList<>();

    public Collection<MessageVO> getMessages() {
        return messages;
    }

    public void setMessages(Collection<MessageVO> messages) {
        this.messages = messages;
    }
}
