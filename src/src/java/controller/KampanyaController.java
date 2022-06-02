package controller;

import dao.KampanyaDAO;
import entity.Kampanya;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value ="kampanyaController")
@SessionScoped
public class KampanyaController implements Serializable {

    private Kampanya entity;
    private KampanyaDAO dao;
    private List<Kampanya> list;
    
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
        List<Kampanya> gList = this.getDao().getList();
        int size = gList.size();
        pageCount = (int) Math.ceil(size / 5) + 1;
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Kampanya();

    }

    public void update() {
        this.getDao().update(entity);
        entity = new Kampanya();

    }

    public void delete(Kampanya k) {
        this.getDao().delete(k);
        entity = new Kampanya();

    }

    public Kampanya getEntity() {
        if (this.entity == null) {
            this.entity = new Kampanya();
        }
        return entity;
    }

    public void setEntity(Kampanya entity) {
        this.entity = entity;
    }

    public KampanyaDAO getDao() {
        if (this.dao == null) {
            this.dao = new KampanyaDAO();
        }
        return dao;
    }

    public void setDao(KampanyaDAO dao) {
        this.dao = dao;
    }

    public List<Kampanya> getList() {
        //this.list = this.getDao().getList(page);
        this.list = this.getDao().getList(page);
        return list;
    }

    public void setList(List<Kampanya> list) {
        this.list = list;
    }

    public KampanyaController() {
    }

}