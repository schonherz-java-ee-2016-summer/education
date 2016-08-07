package hu.schonherz.training.managedbeans.request;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by ikant on 2016. 08. 06..
 */
@ManagedBean(name = "login")
@RequestScoped
public class MBLogin {
    private static final String CHAT = "chat";

    public String doLogin() {
        return CHAT;
    }

}
