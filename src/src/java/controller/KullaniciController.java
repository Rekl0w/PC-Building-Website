package controller;

import dao.KullaniciDAO;
import entity.Kullanici;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import java.io.Serializable;
import java.util.List;

@Named(value = "kullaniciController")
@SessionScoped
public class KullaniciController implements Serializable {

    private Kullanici entity;
    private KullaniciDAO dao;
    private List<Kullanici> list;

    String buyukHarf = "(.*[A-Z].*)";
    String kucukHarf = "(.*[a-z].*)";
    String ozelKarakter = "(.*[@,#,$,%,_,-,.,,,+].*$)";

    public boolean validatePassword(FacesContext context, UIComponent cmp, Object value) throws ValidatorException {
        String v = (String) value;

        if (v.isEmpty()) {
            throw new ValidatorException(new FacesMessage("Şifre Alanı Boş Olamaz."));

        } else if (v.length() < 8) {

            throw new ValidatorException(new FacesMessage("En az 8 karakter girmeliniz."));

        } else if (v.length() > 15) {

            throw new ValidatorException(new FacesMessage("En fazla 15 karakter girebilirsiniz."));

        } else if (!v.matches(buyukHarf)) {
            throw new ValidatorException(new FacesMessage("Sifrenizde en az 1 tane büyük harf olmalıdır."));

        } else if (!v.matches(kucukHarf)) {

            throw new ValidatorException(new FacesMessage("Sifrenizde en az 1 tane küçük harf olmalıdır."));

        } else if (!v.matches(ozelKarakter)) {

            throw new ValidatorException(new FacesMessage("Sifrenizde en az 1 tane özel karakter olmalıdır."));

        }

        return true;
    }

    public boolean validateUser(FacesContext context, UIComponent cmp, Object value) throws ValidatorException {
        String v = (String) value;

        if (v.isEmpty()) {
            throw new ValidatorException(new FacesMessage("İsim Alanı Boş Olamaz."));

        } else if (v.length() < 5) {

            throw new ValidatorException(new FacesMessage("En az 5 karakter girmeliniz."));

        } else if (v.matches(ozelKarakter)) {

            throw new ValidatorException(new FacesMessage("İsiminizde özel karakter olamaz."));

        }
        return true;
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Kullanici();

        System.out.println("--------------REGISTERED-----------");

    }

    public void update() {
        this.getDao().update(entity);
        entity = new Kullanici();

    }

    public void delete(Kullanici k) {
        this.getDao().delete(k);
        entity = new Kullanici();

    }

    public Kullanici getEntity() {
        if (this.entity == null) {
            this.entity = new Kullanici();
        }
        return entity;
    }

    public void setEntity(Kullanici entity) {
        this.entity = entity;
    }

    public KullaniciDAO getDao() {
        if (this.dao == null) {
            this.dao = new KullaniciDAO();
        }
        return dao;
    }

    public void setDao(KullaniciDAO dao) {
        this.dao = dao;
    }

    public List<Kullanici> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Kullanici> list) {
        this.list = list;
    }

    public KullaniciController() {
    }

}
