package controller;

import dao.EkranKartiDAO;
import entity.EkranKarti;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "ekranKartiController")
@SessionScoped
public class EkranKartiController implements Serializable {

    private EkranKarti entity;
    private EkranKartiDAO dao;
    private List<EkranKarti> list;

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
        List<EkranKarti> gList =this.getDao().getList();
        int size = gList.size();
        pageCount = (int) Math.ceil(size / 5);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void create() {
        this.getDao().create(entity);
        entity = new EkranKarti();

    }

    public void update() {
        this.getDao().update(entity);
        entity = new EkranKarti();

    }

    public void delete(EkranKarti e) {
        this.getDao().delete(e);
        entity = new EkranKarti();

    }

    public EkranKarti getEntity() {
        if (this.entity == null) {
            this.entity = new EkranKarti();
        }
        return entity;
    }

    public void setEntity(EkranKarti entity) {
        this.entity = entity;
    }

    public EkranKartiDAO getDao() {
        if (this.dao == null) {
            this.dao = new EkranKartiDAO();
        }
        return dao;
    }

    public void setDao(EkranKartiDAO dao) {
        this.dao = dao;
    }

    public List<EkranKarti> getList() {
        this.list = this.getDao().getList(page);
        return list;
    }

    public void setList(List<EkranKarti> list) {
        this.list = list;
    }

    public EkranKartiController() {
    }

}
