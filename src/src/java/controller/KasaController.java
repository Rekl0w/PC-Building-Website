package controller;

import dao.KasaDAO;
import entity.Kasa;
import jakarta.inject.Named;
import jakarta.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class KasaController implements Serializable {

    private Kasa entity;
    private KasaDAO dao;
    private List<Kasa> list;

    public void create() {
        this.getDao().create(entity);
        entity = new Kasa();

    }

    public void update() {
        this.getDao().update(entity);
        entity = new Kasa();

    }

    public void delete(Kasa k) {
        this.getDao().delete(k);
        entity = new Kasa();
        
    }

    public Kasa getEntity() {
        if (this.entity == null) {
            this.entity = new Kasa();
        }
        return entity;
    }

    public void setEntity(Kasa entity) {
        this.entity = entity;
    }

    public KasaDAO getDao() {
        if (this.dao == null) {
            this.dao = new KasaDAO();
        }
        return dao;
    }

    public void setDao(KasaDAO dao) {
        this.dao = dao;
    }

    public List<Kasa> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Kasa> list) {
        this.list = list;
    }

    public KasaController() {
    }

}
