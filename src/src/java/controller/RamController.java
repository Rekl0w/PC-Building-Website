package controller;

import dao.RamDAO;
import entity.Ram;
import jakarta.inject.Named;
import jakarta.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class RamController implements Serializable {

    private Ram entity;
    private RamDAO dao;
    private List<Ram> list;

    public void create() {
        this.getDao().create(entity);
        entity = new Ram();

    }

    public void update() {
        this.getDao().update(entity);
        entity = new Ram();

    }

    public void delete(Ram r) {
        this.getDao().delete(r);
        entity = new Ram();

    }

    public Ram getEntity() {
        if (this.entity == null) {
            this.entity = new Ram();
        }
        return entity;
    }

    public void setEntity(Ram entity) {
        this.entity = entity;
    }

    public RamDAO getDao() {
        if (this.dao == null) {
            this.dao = new RamDAO();
        }
        return dao;
    }

    public void setDao(RamDAO dao) {
        this.dao = dao;
    }

    public List<Ram> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Ram> list) {
        this.list = list;
    }

    public RamController() {
    }

}
