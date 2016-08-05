package hu.schonhertz.training.jsf.managed.session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by ikant on 2016. 08. 04..
 */
@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionManagedBean implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
