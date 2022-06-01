package controller;

import dao.RamDAO;
import entity.Ram;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "ramController")
@SessionScoped
public class RamController implements Serializable {

    private Ram entity;
    private RamDAO dao;
    private List<Ram> list;

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
        List<Ram> gList = this.getDao().getList();
        int size = gList.size();
        pageCount = (int) Math.ceil(size / 5) + 1;
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

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
        this.list = this.getDao().getList(page);
        return list;
    }

    public void setList(List<Ram> list) {
        this.list = list;
    }

    public RamController() {
    }

}
