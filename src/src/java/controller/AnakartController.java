package controller;

import dao.AnakartDAO;
import entity.Anakart;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "anakartController")
@SessionScoped
public class AnakartController implements Serializable {

    private Anakart entity;
    private AnakartDAO dao;
    private List<Anakart> list;

    private int page = 1;
    private int pageSize = 3;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }

    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }

    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDao().count() / (double) pageSize);

        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Anakart();

    }

    public void update() {
        this.getDao().update(entity);
        entity = new Anakart();

    }

    public void delete(Anakart a) {
        this.getDao().delete(a);
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
        this.list = this.getDao().getList(page, pageSize);
        return list;
    }

    public void setList(List<Anakart> list) {
        this.list = list;
    }

    public AnakartController() {
    }

}
