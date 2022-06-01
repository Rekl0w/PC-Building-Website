package controller;

import dao.MouseDAO;
import entity.Mouse;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value ="mouseController")
@SessionScoped
public class MouseController implements Serializable {

    private Mouse entity;
    private MouseDAO dao;
    private List<Mouse> list;
    
    
    private int page = 1;
    private int pageCount;

    public void next() {
        page++;
        if (page > this.getPageCount()) {
            page = 1;

        }
    }

    public void previous() {
        page--;
        if (page < 1) {
            page = this.getPageCount();

        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        List<Mouse> gList = this.getDao().getList();
        int size = gList.size();
        pageCount = (int) Math.ceil(size / 5);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Mouse();

    }

    public void update() {
        this.getDao().update(entity);
        entity = new Mouse();

    }

    public void delete(Mouse m) {
        this.getDao().delete(m);
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
        this.list = this.getDao().getList(page);
        return list;
    }

    public void setList(List<Mouse> list) {
        this.list = list;
    }

    public MouseController() {
    }

}
