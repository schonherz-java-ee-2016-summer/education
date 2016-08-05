package hu.schonhertz.training.jsf.managed.request;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by ikant on 2016. 08. 04..
 */
@ManagedBean(name = "bean")
@RequestScoped
public class RequestManagedBean {


    public String doAction() {
        return "saygoodbye";
    }
}
