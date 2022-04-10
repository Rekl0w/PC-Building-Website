package controller;

import dao.MonitorDAO;
import entity.Monitor;
import jakarta.inject.Named;
import jakarta.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class MonitorController implements Serializable {

    private Monitor entity;
    private MonitorDAO dao;
    private List<Monitor> list;

    public void create() {
        this.getDao().create(entity);
        entity = new Monitor();

    }

    public void update() {
        this.getDao().update(entity);
        entity = new Monitor();

    }

    public void delete(Monitor m) {
        this.getDao().delete(m);
        entity = new Monitor();

    }

    public Monitor getEntity() {
        if (this.entity == null) {
            this.entity = new Monitor();
        }
        return entity;
    }

    public void setEntity(Monitor entity) {
        this.entity = entity;
    }

    public MonitorDAO getDao() {
        if (this.dao == null) {
            this.dao = new MonitorDAO();
        }
        return dao;
    }

    public void setDao(MonitorDAO dao) {
        this.dao = dao;
    }

    public List<Monitor> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Monitor> list) {
        this.list = list;
    }

    public MonitorController() {
    }

}
