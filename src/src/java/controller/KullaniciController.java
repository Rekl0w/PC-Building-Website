package controller;

import dao.KullaniciDAO;
import entity.Kullanici;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value ="kullaniciController")
@SessionScoped
public class KullaniciController implements Serializable {

    private Kullanici entity;
    private KullaniciDAO dao;
    private List<Kullanici> list;

    public void create() {
        this.getDao().create(entity);
        entity = new Kullanici();

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
