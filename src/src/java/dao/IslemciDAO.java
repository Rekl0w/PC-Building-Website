package dao;

import entity.Islemci;
import entity.BilgisayarBileseni;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IslemciDAO extends DBConnection {

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

    public void create(Islemci a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into islemci (kampanya_id, cekirdek_sayisi, hiz, marka, fiyat, stok) values(" + a.getKampanya().getKampanya_id() + ", '" + a.getCekirdek_sayisi() + "', " + a.getHiz() + ", '" + a.getMarka() + "', " + a.getFiyat() + ", " + a.getStok() + ") ";
            st.executeUpdate(query);

            ResultSet rs = st.executeQuery("select max(urun_id) as mid from islemci");

            rs.next();
            int id = rs.getInt("mid");

            BilgisayarBileseni bb = new BilgisayarBileseni(id, a.getMarka(), a.getFiyat(), a.getStok(), a.getKampanya());

            this.getBbDao().create(bb);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(Islemci a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update islemci set kampanya_id = '" + a.getKampanya().getKampanya_id() + "', cekirdek_sayisi ='" + a.getCekirdek_sayisi() + "', hiz = " + a.getHiz() + ", marka = '" + a.getMarka() + "', fiyat = " + a.getFiyat() + ", stok = " + a.getStok() + "where urun_id = " + a.getUrun_id();
            st.executeUpdate(query);

            ResultSet rs = st.executeQuery("select * from islemci where urun_id = " + a.getUrun_id());

            rs.next();
            int id = rs.getInt("urun_id");

            BilgisayarBileseni bb = new BilgisayarBileseni(id, a.getMarka(), a.getFiyat(), a.getStok(), a.getKampanya());

            this.getBbDao().update(bb);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(Islemci a) {
        try {
            Statement st = this.getConnection().createStatement();

            ResultSet rs = st.executeQuery("select * from islemci where urun_id = " + a.getUrun_id());
            rs.next();
            int id = rs.getInt("urun_id");

            BilgisayarBileseni bb = new BilgisayarBileseni(id, a.getMarka(), a.getFiyat(), a.getStok(), a.getKampanya());
            this.getBbDao().delete(bb);

            String query = "delete from islemci where urun_id = " + a.getUrun_id();
            st.executeUpdate(query);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public List<Islemci> getList() {
        List<Islemci> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from islemci order by urun_id asc");

            while (rs.next()) {
                list.add(new Islemci(rs.getInt("urun_id"), rs.getInt("cekirdek_sayisi"), rs.getInt("hiz"), rs.getString("marka"), rs.getFloat("fiyat"), rs.getInt("stok"), this.getKampanyaDAO().findById(rs.getInt("kampanya_id"))));

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<Islemci> getList(int page) {
        int offset = (page - 1) * 5;
        List<Islemci> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from islemci order by urun_id asc limit 5 offset " + offset);

            while (rs.next()) {
                list.add(new Islemci(rs.getInt("urun_id"), rs.getInt("cekirdek_sayisi"), rs.getInt("hiz"), rs.getString("marka"), rs.getFloat("fiyat"), rs.getInt("stok"), this.getKampanyaDAO().findById(rs.getInt("kampanya_id"))));

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
