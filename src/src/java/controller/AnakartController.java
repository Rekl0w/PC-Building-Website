package controller;

import dao.AnakartDAO;
import entity.Anakart;
import jakarta.inject.Named;
import jakarta.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class AnakartController implements Serializable {

    private Anakart entity;
    private AnakartDAO dao;
    private List<Anakart> list;

    public void create() {
        this.getDao().create(entity);
        entity = new Anakart();

    }

    public void update() {
        this.getDao().update(entity);
        entity = new Anakart();

    }

    public void delete() {
        this.getDao().delete(entity);
        entity = new Anakart();

    }

    public Anakart getEntity() {
        if (this.entity == null) {
            this.entity = new Anakart();
        }
        return entity;
    }

    public void setEntity(Anakart entity) {
        this.entity = entity;
    }

    public AnakartDAO getDao() {
        if (this.dao == null) {
            this.dao = new AnakartDAO();
        }
        return dao;
    }

    public void setDao(AnakartDAO dao) {
        this.dao = dao;
    }

    public List<Anakart> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Anakart> list) {
        this.list = list;
    }

    public AnakartController() {
    }

}
