package dao;

import entity.Kasa;
import entity.BilgisayarBileseni;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KasaDAO extends DBConnection {

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

    public void create(Kasa a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into kasa (kampanya_id, boyut, marka, fiyat, stok) values(" + a.getKampanya().getKampanya_id() + ", '" + a.getBoyut()+ "', '" + a.getMarka() + "', " + a.getFiyat() + ", " + a.getStok() + ") ";
            st.executeUpdate(query);

            ResultSet rs = st.executeQuery("select max(urun_id) as mid from kasa");
            
            rs.next();
            int id = rs.getInt("mid");

            BilgisayarBileseni bb = new BilgisayarBileseni(id , a.getMarka(), a.getFiyat(), a.getStok(), a.getKampanya());

            this.getBbDao().create(bb);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(Kasa a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update kasa set kampanya_id = '" + a.getKampanya().getKampanya_id() + "', boyut = '" + a.getBoyut()+ "', marka = '" + a.getMarka() + "', fiyat = " + a.getFiyat() + ", stok = " + a.getStok()+ "where urun_id = " + a.getUrun_id();
            st.executeUpdate(query);
            
            ResultSet rs = st.executeQuery("select * from kasa where urun_id = " + a.getUrun_id());
            
            rs.next();
            int id = rs.getInt("urun_id");

            BilgisayarBileseni bb = new BilgisayarBileseni(id , a.getMarka(), a.getFiyat(), a.getStok(), a.getKampanya());

            this.getBbDao().update(bb);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(Kasa a) {
        try {
            Statement st = this.getConnection().createStatement();
            
            ResultSet rs = st.executeQuery("select * from kasa where urun_id = " + a.getUrun_id());
            rs.next();
            int id = rs.getInt("urun_id");
            
            BilgisayarBileseni bb = new BilgisayarBileseni(id , a.getMarka(), a.getFiyat(), a.getStok(), a.getKampanya());
            this.getBbDao().delete(bb);
            
            
            String query = "delete from kasa where urun_id = " + a.getUrun_id();
            st.executeUpdate(query);
            
            
            

            
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public List<Kasa> getList() {
        List<Kasa> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from kasa";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Kasa(rs.getInt("urun_id"), rs.getString("boyut"), rs.getString("marka"), rs.getFloat("fiyat"), rs.getInt("stok"), this.getKampanyaDAO().findById(rs.getInt("kampanya_id"))));

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
