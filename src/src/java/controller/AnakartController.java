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
        List<Anakart> gList = this.getDao().getList();
        int size = gList.size();
        pageCount = (int) Math.ceil(size / 5);
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
        this.list = this.getDao().getList(page);
        return list;
    }

    public void setList(List<Anakart> list) {
        this.list = list;
    }

    public AnakartController() {
    }

}
