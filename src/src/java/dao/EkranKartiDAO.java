package dao;

import entity.EkranKarti;
import entity.BilgisayarBileseni;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EkranKartiDAO extends DBConnection {

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

    public void create(EkranKarti a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into ekran_karti (kampanya_id, model, bellek, marka, fiyat, stok) values(" + a.getKampanya().getKampanya_id() + ", '" + a.getModel() + "', " + a.getBellek() + ", '" + a.getMarka() + "', " + a.getFiyat() + ", " + a.getStok() + ") ";
            st.executeUpdate(query);

            ResultSet rs = st.executeQuery("select max(urun_id) as mid from ekran_karti");

            rs.next();
            int id = rs.getInt("mid");

            BilgisayarBileseni bb = new BilgisayarBileseni(id, a.getMarka(), a.getFiyat(), a.getStok(), a.getKampanya());

            this.getBbDao().create(bb);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(EkranKarti a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update ekran_karti set kampanya_id = '" + a.getKampanya().getKampanya_id() + "', model ='" + a.getModel() + "', bellek = " + a.getBellek() + ", marka = '" + a.getMarka() + "', fiyat = " + a.getFiyat() + ", stok = " + a.getStok() + "where urun_id = " + a.getUrun_id();
            st.executeUpdate(query);

            ResultSet rs = st.executeQuery("select * from ekran_karti where urun_id = " + a.getUrun_id());

            rs.next();
            int id = rs.getInt("urun_id");

            BilgisayarBileseni bb = new BilgisayarBileseni(id, a.getMarka(), a.getFiyat(), a.getStok(), a.getKampanya());

            this.getBbDao().update(bb);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(EkranKarti a) {
        try {
            Statement st = this.getConnection().createStatement();

            ResultSet rs = st.executeQuery("select * from ekran_karti where urun_id = " + a.getUrun_id());
            rs.next();
            int id = rs.getInt("urun_id");

            BilgisayarBileseni bb = new BilgisayarBileseni(id, a.getMarka(), a.getFiyat(), a.getStok(), a.getKampanya());
            this.getBbDao().delete(bb);

            String query = "delete from ekran_karti where urun_id = " + a.getUrun_id();
            st.executeUpdate(query);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public List<EkranKarti> getList(int page) {
        int offset = (page - 1) * 5;
        List<EkranKarti> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from ekran_karti limit 5 offset " + offset);
            while (rs.next()) {
                list.add(new EkranKarti(rs.getInt("urun_id"), rs.getString("model"), rs.getInt("bellek"), rs.getString("marka"), rs.getFloat("fiyat"), rs.getInt("stok"), this.getKampanyaDAO().findById(rs.getInt("kampanya_id"))));

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<EkranKarti> getList() {
        
        List<EkranKarti> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from ekran_karti");

            while (rs.next()) {
                list.add(new EkranKarti(rs.getInt("urun_id"), rs.getString("model"), rs.getInt("bellek"), rs.getString("marka"), rs.getFloat("fiyat"), rs.getInt("stok"), this.getKampanyaDAO().findById(rs.getInt("kampanya_id"))));

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
