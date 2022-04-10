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
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<BilgisayarBileseni> list) {
        this.list = list;
    }

    public BilgisayarBileseniController() {
    }

}

