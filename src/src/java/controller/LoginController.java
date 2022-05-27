package controller;

import entity.Kullanici;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private Kullanici kullanici;

    public LoginController() {
    }

    public Kullanici getKullanici() {
        if (kullanici == null) {
            kullanici = new Kullanici();
        }
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public void login() {
        if (kullanici.getAd_soyad().equals("test") && kullanici.getSifre().equals("test")) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser", kullanici);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Username of Password is Wrong!"));
        }
    }

}
