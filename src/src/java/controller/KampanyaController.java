package controller;

import dao.KampanyaDAO;
import entity.Kampanya;
import jakarta.inject.Named;
import jakarta.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class KampanyaController implements Serializable {

    private Kampanya entity;
    private KampanyaDAO dao;
    private List<Kampanya> list;

    public void create() {
        this.getDao().create(entity);
        entity = new Kampanya();

    }

    public void update() {
        this.getDao().update(entity);
        entity = new Kampanya();

    }

    public void delete(Kampanya k) {
        this.getDao().delete(k);
        entity = new Kampanya();

    }

    public Kampanya getEntity() {
        if (this.entity == null) {
            this.entity = new Kampanya();
        }
        return entity;
    }

    public void setEntity(Kampanya entity) {
        this.entity = entity;
    }

    public KampanyaDAO getDao() {
        if (this.dao == null) {
            this.dao = new KampanyaDAO();
        }
        return dao;
    }

    public void setDao(KampanyaDAO dao) {
        this.dao = dao;
    }

    public List<Kampanya> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Kampanya> list) {
        this.list = list;
    }

    public KampanyaController() {
    }

}