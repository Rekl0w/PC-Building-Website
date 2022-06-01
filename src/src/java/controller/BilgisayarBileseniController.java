package controller;

import dao.BilgisayarBileseniDAO;
import entity.BilgisayarBileseni;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "bilgisayarBileseniController")
@SessionScoped
public class BilgisayarBileseniController implements Serializable {

    private BilgisayarBileseni entity;
    private BilgisayarBileseniDAO dao;
    private List<BilgisayarBileseni> list;

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
        List<BilgisayarBileseni> gList = this.getDao().getList();
        int size = gList.size();
        pageCount = (int) Math.ceil(size / 5) + 1;
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void create() {
        this.getDao().create(entity);
        entity = new BilgisayarBileseni();

    }

    public void update() {
        this.getDao().update(entity);
        entity = new BilgisayarBileseni();

    }

    public void delete(BilgisayarBileseni b) {
        this.getDao().delete(b);
        entity = new BilgisayarBileseni();

    }

    public BilgisayarBileseni getEntity() {
        if (this.entity == null) {
            this.entity = new BilgisayarBileseni();
        }
        return entity;
    }

    public void setEntity(BilgisayarBileseni entity) {
        this.entity = entity;
    }

    public BilgisayarBileseniDAO getDao() {
        if (this.dao == null) {
            this.dao = new BilgisayarBileseniDAO();
        }
        return dao;
    }

    public void setDao(BilgisayarBileseniDAO dao) {
        this.dao = dao;
    }

    public List<BilgisayarBileseni> getList() {
        this.list = this.getDao().getList(page);
        return list;
    }

    public void setList(List<BilgisayarBileseni> list) {
        this.list = list;
    }

    public BilgisayarBileseniController() {
    }

}
