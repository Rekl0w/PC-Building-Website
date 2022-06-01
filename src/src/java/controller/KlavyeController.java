package controller;

import dao.KlavyeDAO;
import entity.Klavye;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value ="klavyeController")
@SessionScoped
public class KlavyeController implements Serializable {

    private Klavye entity;
    private KlavyeDAO dao;
    private List<Klavye> list;
    
    
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
        List<Klavye> gList = this.getDao().getList();
        int size = gList.size();
        pageCount = (int) Math.ceil(size / 5);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Klavye();

    }

    public void update() {
        this.getDao().update(entity);
        entity = new Klavye();

    }

    public void delete(Klavye k) {
        this.getDao().delete(k);
        entity = new Klavye();
        
    }

    public Klavye getEntity() {
        if (this.entity == null) {
            this.entity = new Klavye();
        }
        return entity;
    }

    public void setEntity(Klavye entity) {
        this.entity = entity;
    }

    public KlavyeDAO getDao() {
        if (this.dao == null) {
            this.dao = new KlavyeDAO();
        }
        return dao;
    }

    public void setDao(KlavyeDAO dao) {
        this.dao = dao;
    }

    public List<Klavye> getList() {
        this.list = this.getDao().getList(page);
        return list;
    }

    public void setList(List<Klavye> list) {
        this.list = list;
    }

    public KlavyeController() {
    }

}
