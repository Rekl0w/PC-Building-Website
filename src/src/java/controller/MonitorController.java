package controller;

import dao.MonitorDAO;
import entity.Monitor;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value ="monitorController")
@SessionScoped
public class MonitorController implements Serializable {

    private Monitor entity;
    private MonitorDAO dao;
    private List<Monitor> list;
    
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
        List<Monitor> gList = this.getDao().getList();
        int size = gList.size();
        pageCount = (int) Math.ceil(size / 5);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

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
        this.list = this.getDao().getList(page);
        return list;
    }

    public void setList(List<Monitor> list) {
        this.list = list;
    }

    public MonitorController() {
    }

}
