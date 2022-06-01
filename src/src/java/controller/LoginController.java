package controller;

import dao.KullaniciDAO;
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
    private KullaniciDAO kullaniciDAO;

    public KullaniciDAO getKullaniciDAO() {
        if (this.kullaniciDAO == null) {
            this.kullaniciDAO = new KullaniciDAO();
        }
        return kullaniciDAO;
    }

    public void setKullaniciDAO(KullaniciDAO kullaniciDAO) {
        this.kullaniciDAO = kullaniciDAO;
    }

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

    public String login() {
        if (getKullaniciDAO().verifyLogin(getKullanici())) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentUser", getKullanici());
            System.out.println("giris basarili");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Username or Password is Wrong!"));
            return "/panel/login?faces-redirect=true";
        }
        return "/index?faces-redirect=true";
         
    }

}
