package controller;

import dao.EkranKartiDAO;
import entity.EkranKarti;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value ="ekranKartiController")
@SessionScoped
public class EkranKartiController implements Serializable {

    private EkranKarti entity;
    private EkranKartiDAO dao;
    private List<EkranKarti> list;

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
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<EkranKarti> list) {
        this.list = list;
    }

    public EkranKartiController() {
    }

}
