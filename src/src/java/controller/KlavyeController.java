package controller;

import dao.KlavyeDAO;
import entity.Klavye;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value ="klavyeController")
@SessionScoped
public class KlavyeController implements Serializable {

    private Klavye entity;
    private KlavyeDAO dao;
    private List<Klavye> list;

    public void create() {
        this.getDao().create(entity);
        entity = new Klavye();

    }

    public void update() {
        this.getDao().update(entity);
        entity = new Klavye();

    }

    public void delete(Klavye k) {
        this.getDao().delete(k);
        entity = new Klavye();
        
    }

    public Klavye getEntity() {
        if (this.entity == null) {
            this.entity = new Klavye();
        }
        return entity;
    }

    public void setEntity(Klavye entity) {
        this.entity = entity;
    }

    public KlavyeDAO getDao() {
        if (this.dao == null) {
            this.dao = new KlavyeDAO();
        }
        return dao;
    }

    public void setDao(KlavyeDAO dao) {
        this.dao = dao;
    }

    public List<Klavye> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Klavye> list) {
        this.list = list;
    }

    public KlavyeController() {
    }

}
