package controller;

import dao.MouseDAO;
import entity.Mouse;
import jakarta.inject.Named;
import jakarta.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class MouseController implements Serializable {

    private Mouse entity;
    private MouseDAO dao;
    private List<Mouse> list;

    public void create() {
        this.getDao().create(entity);
        entity = new Mouse();

    }

    public void update() {
        this.getDao().update(entity);
        entity = new Mouse();

    }

    public void delete() {
        this.getDao().delete(entity);
        entity = new Mouse();

    }

    public Mouse getEntity() {
        if (this.entity == null) {
            this.entity = new Mouse();
        }
        return entity;
    }

    public void setEntity(Mouse entity) {
        this.entity = entity;
    }

    public MouseDAO getDao() {
        if (this.dao == null) {
            this.dao = new MouseDAO();
        }
        return dao;
    }

    public void setDao(MouseDAO dao) {
        this.dao = dao;
    }

    public List<Mouse> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Mouse> list) {
        this.list = list;
    }

    public MouseController() {
    }

}
