package controller;

import dao.KasaDAO;
import entity.Anakart;
import entity.Kasa;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value ="kasaController")
@SessionScoped
public class KasaController implements Serializable {

    private Kasa entity;
    private KasaDAO dao;
    private List<Kasa> list;
    
    
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
        List<Kasa> gList = this.getDao().getList();
        int size = gList.size();
        pageCount = (int) Math.ceil(size / 5);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public void create() {
        this.getDao().create(entity);
        entity = new Kasa();

    }

    public void update() {
        this.getDao().update(entity);
        entity = new Kasa();

    }

    public void delete(Kasa k) {
        this.getDao().delete(k);
        entity = new Kasa();
        
    }

    public Kasa getEntity() {
        if (this.entity == null) {
            this.entity = new Kasa();
        }
        return entity;
    }

    public void setEntity(Kasa entity) {
        this.entity = entity;
    }

    public KasaDAO getDao() {
        if (this.dao == null) {
            this.dao = new KasaDAO();
        }
        return dao;
    }

    public void setDao(KasaDAO dao) {
        this.dao = dao;
    }

    public List<Kasa> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Kasa> list) {
        this.list = list;
    }

    public KasaController() {
    }

    }
