package controller;

import dao.IslemciDAO;
import entity.Islemci;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value ="islemciController")
@SessionScoped
public class IslemciController implements Serializable {

    private Islemci entity;
    private IslemciDAO dao;
    private List<Islemci> list;
    
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
        List<Islemci> gList = this.getDao().getList();
        int size = gList.size();
        pageCount = (int) Math.ceil(size / 5) + 1;
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    

    public void create() {
        this.getDao().create(entity);
        entity = new Islemci();

    }

    public void update() {
        this.getDao().update(entity);
        entity = new Islemci();

    }

    public void delete(Islemci i) {
        this.getDao().delete(i);
        entity = new Islemci();

    }

    public Islemci getEntity() {
        if (this.entity == null) {
            this.entity = new Islemci();
        }
        return entity;
    }

    public void setEntity(Islemci entity) {
        this.entity = entity;
    }

    public IslemciDAO getDao() {
        if (this.dao == null) {
            this.dao = new IslemciDAO();
        }
        return dao;
    }

    public void setDao(IslemciDAO dao) {
        this.dao = dao;
    }

    public List<Islemci> getList(){
        this.list = this.getDao().getList(page);
        return list;
    }

    public void setList(List<Islemci> list) {
        this.list = list;
    }

    public IslemciController() {
    }

}
