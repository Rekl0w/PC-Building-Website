package controller;

import dao.IslemciDAO;
import entity.Islemci;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value ="islemciController")
@SessionScoped
public class IslemciController implements Serializable {

    private Islemci entity;
    private IslemciDAO dao;
    private List<Islemci> list;

    public void create() {
        this.getDao().create(entity);
        entity = new Islemci();

    }

    public void update() {
        this.getDao().update(entity);
        entity = new Islemci();

    }

    public void delete(Islemci i) {
        this.getDao().delete(i);
        entity = new Islemci();

    }

    public Islemci getEntity() {
        if (this.entity == null) {
            this.entity = new Islemci();
        }
        return entity;
    }

    public void setEntity(Islemci entity) {
        this.entity = entity;
    }

    public IslemciDAO getDao() {
        if (this.dao == null) {
            this.dao = new IslemciDAO();
        }
        return dao;
    }

    public void setDao(IslemciDAO dao) {
        this.dao = dao;
    }

    public List<Islemci> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Islemci> list) {
        this.list = list;
    }

    public IslemciController() {
    }

}
