package controller;

import dao.SatinAlmaDAO;
import entity.SatinAlma;
import jakarta.inject.Named;
import jakarta.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class SatinAlmaController implements Serializable {

    private SatinAlma entity;
    private SatinAlmaDAO dao;
    private List<SatinAlma> list;

    public void create() {
        this.getDao().create(entity);
        entity = new SatinAlma();

    }

    public void update() {
        this.getDao().update(entity);
        entity = new SatinAlma();

    }

    public void delete(SatinAlma sa) {
        this.getDao().delete(sa);
        entity = new SatinAlma();

    }

    public SatinAlma getEntity() {
        if (this.entity == null) {
            this.entity = new SatinAlma();
        }
        return entity;
    }

    public void setEntity(SatinAlma entity) {
        this.entity = entity;
    }

    public SatinAlmaDAO getDao() {
        if (this.dao == null) {
            this.dao = new SatinAlmaDAO();
        }
        return dao;
    }

    public void setDao(SatinAlmaDAO dao) {
        this.dao = dao;
    }

    public List<SatinAlma> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<SatinAlma> list) {
        this.list = list;
    }

    public SatinAlmaController() {
    }

}
