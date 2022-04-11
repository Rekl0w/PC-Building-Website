package dao;

import entity.Klavye;
import entity.BilgisayarBileseni;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KlavyeDAO extends DBConnection {

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

    public void create(Klavye a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into klavye (kampanya_id, switch_modeli, marka, fiyat, stok) values(" + a.getKampanya().getKampanya_id() + ", '" + a.getSwitch_modeli()+ "', '" + a.getMarka() + "', " + a.getFiyat() + ", " + a.getStok() + ") ";
            st.executeUpdate(query);

            ResultSet rs = st.executeQuery("select max(urun_id) as mid from klavye");
            
            rs.next();
            int id = rs.getInt("mid");

            BilgisayarBileseni bb = new BilgisayarBileseni(id , a.getMarka(), a.getFiyat(), a.getStok(), a.getKampanya());

            this.getBbDao().create(bb);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(Klavye a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update klavye set kampanya_id = '" + a.getKampanya().getKampanya_id() + "', switch_modeli = '" + a.getSwitch_modeli()+ "', marka = '" + a.getMarka() + "', fiyat = " + a.getFiyat() + ", stok = " + a.getStok()+ "where urun_id = " + a.getUrun_id();
            st.executeUpdate(query);
            
            ResultSet rs = st.executeQuery("select * from klavye where urun_id = " + a.getUrun_id());
            
            rs.next();
            int id = rs.getInt("urun_id");

            BilgisayarBileseni bb = new BilgisayarBileseni(id , a.getMarka(), a.getFiyat(), a.getStok(), a.getKampanya());

            this.getBbDao().update(bb);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(Klavye a) {
        try {
            Statement st = this.getConnection().createStatement();
            
            ResultSet rs = st.executeQuery("select * from klavye where urun_id = " + a.getUrun_id());
            rs.next();
            int id = rs.getInt("urun_id");
            
            BilgisayarBileseni bb = new BilgisayarBileseni(id , a.getMarka(), a.getFiyat(), a.getStok(), a.getKampanya());
            this.getBbDao().delete(bb);
            
            
            String query = "delete from klavye where urun_id = " + a.getUrun_id();
            st.executeUpdate(query);
            
            
            

            
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public List<Klavye> getList() {
        List<Klavye> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from klavye";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Klavye(rs.getInt("urun_id"), rs.getString("switch_modeli"), rs.getString("marka"), rs.getFloat("fiyat"), rs.getInt("stok"), this.getKampanyaDAO().findById(rs.getInt("kampanya_id"))));

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
