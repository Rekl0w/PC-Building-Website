package dao;

import entity.Monitor;
import entity.BilgisayarBileseni;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MonitorDAO extends DBConnection {

    private KampanyaDAO kampanyaDAO;
    private BilgisayarBileseniDAO bbDao;

    public BilgisayarBileseniDAO getBbDao() {
        if (this.bbDao == null) {
            bbDao = new BilgisayarBileseniDAO();
        }
        return bbDao;
    }

    public void setBbDao(BilgisayarBileseniDAO bbDao) {
        this.bbDao = bbDao;
    }

    public void create(Monitor a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into monitor (kampanya_id, boyut, ekran_yenileme_hizi, marka, fiyat, stok) values(" + a.getKampanya().getKampanya_id() + ", " + a.getEkran_yenileme_hizi()+ ", " + a.getBoyut()+ ", '" + a.getMarka() + "', " + a.getFiyat() + ", " + a.getStok() + ") ";
            st.executeUpdate(query); 

            ResultSet rs = st.executeQuery("select max(urun_id) as mid from monitor");
            
            rs.next();
            int id = rs.getInt("mid");

            BilgisayarBileseni bb = new BilgisayarBileseni(id , a.getMarka(), a.getFiyat(), a.getStok(), a.getKampanya());

            this.getBbDao().create(bb);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(Monitor a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update monitor set kampanya_id = '" + a.getKampanya().getKampanya_id() + "', boyut = " + a.getBoyut()+ ", marka = '" + a.getMarka() + "', fiyat = " + a.getFiyat() + ", stok = " + a.getStok()+ "where urun_id = " + a.getUrun_id();
            st.executeUpdate(query);
            
            ResultSet rs = st.executeQuery("select * from monitor where urun_id = " + a.getUrun_id());
            
            rs.next();
            int id = rs.getInt("urun_id");

            BilgisayarBileseni bb = new BilgisayarBileseni(id , a.getMarka(), a.getFiyat(), a.getStok(), a.getKampanya());

            this.getBbDao().update(bb);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(Monitor a) {
        try {
            Statement st = this.getConnection().createStatement();
            
            ResultSet rs = st.executeQuery("select * from monitor where urun_id = " + a.getUrun_id());
            rs.next();
            int id = rs.getInt("urun_id");
            
            BilgisayarBileseni bb = new BilgisayarBileseni(id , a.getMarka(), a.getFiyat(), a.getStok(), a.getKampanya());
            this.getBbDao().delete(bb);
            
            
            String query = "delete from monitor where urun_id = " + a.getUrun_id();
            st.executeUpdate(query);
            
            
            

            
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public List<Monitor> getList() {
        List<Monitor> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from monitor";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Monitor(rs.getInt("urun_id"), rs.getInt("boyut"), rs.getInt("ekran_yenileme_hizi"),rs.getString("marka"), rs.getFloat("fiyat"), rs.getInt("stok"), this.getKampanyaDAO().findById(rs.getInt("kampanya_id"))));

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return list;
    }

    public KampanyaDAO getKampanyaDAO() {
        if (this.kampanyaDAO == null) {
            this.kampanyaDAO = new KampanyaDAO();
        }
        return kampanyaDAO;
    }

    public void setKampanyaDAO(KampanyaDAO kampanyaDAO) {
        this.kampanyaDAO = kampanyaDAO;
    }

}
