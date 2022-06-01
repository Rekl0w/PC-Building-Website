package dao;

import entity.Anakart;
import entity.BilgisayarBileseni;
import entity.Kampanya;
import entity.Kullanici;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BilgisayarBileseniDAO extends DBConnection {

    private KampanyaDAO kampanyaDAO;

    public void create(BilgisayarBileseni a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into bilgisayar_bileseni (urun_id, kampanya_id, marka,fiyat, stok) values(" + a.getUrun_id() + " , " + a.getKampanya().getKampanya_id() + ",'" + a.getMarka() + "', " + a.getFiyat() + ", " + a.getStok() + ")";
            st.executeUpdate(query);

            ResultSet rs = st.executeQuery("select max(urun_id) as mid from bilgisayar_bileseni");

            rs.next();
            int id = rs.getInt("mid");

            for (Kullanici k : a.getKullanicilar()) {
                query = "insert into siparis_verir (urun_id, kullanici_id) values (" + id + ", " + k.getKullanici_id() + ")";
                st.executeUpdate(query);
            }

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(BilgisayarBileseni a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update bilgisayar_bileseni set marka ='" + a.getMarka() + "', kampanya_id = " + a.getKampanya().getKampanya_id() + ", stok = " + a.getStok() + " where urun_id = " + a.getUrun_id();
            st.executeUpdate(query);

            st.executeUpdate("delete from siparis_verir where urun_id = " + a.getUrun_id());
            for (Kullanici k : a.getKullanicilar()) {
                query = "insert into siparis_verir (urun_id, kullanici_id) values (" + a.getUrun_id() + ", " + k.getKullanici_id() + ")";
                st.executeUpdate(query);
            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(BilgisayarBileseni a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query1 = "delete from siparis_verir where urun_id = " + a.getUrun_id();
            st.executeUpdate(query1);

            String query2 = "delete from bilgisayar_bileseni where urun_id = " + a.getUrun_id();
            st.executeUpdate(query2);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public List<BilgisayarBileseni> getList() {
        List<BilgisayarBileseni> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from bilgisayar_bileseni";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new BilgisayarBileseni(rs.getInt("urun_id"), rs.getString("marka"), rs.getInt("stok"), this.getKampanyaDAO().findById(rs.getInt("kampanya_id"))));

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }
        return list;

    }

    public List<BilgisayarBileseni> getList(int page) {
        int offset = (page - 1) * 5;
        List<BilgisayarBileseni> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from bilgisayar_bileseni limit 5 offset " + offset);

            while (rs.next()) {
                list.add(new BilgisayarBileseni(rs.getInt("urun_id"), rs.getString("marka"), rs.getInt("stok"), this.getKampanyaDAO().findById(rs.getInt("kampanya_id"))));

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }
        return list;

    }

    public List<Kullanici> getKullanicis(int urun_id) {

        List<Kullanici> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from kullanici where kullanici_id in (select kullanici_id from kullanici where urun_id=" + urun_id + ")";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Kullanici(rs.getInt("kullanici_id"), rs.getString("ad_soyad"), rs.getString("sifre")));

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
