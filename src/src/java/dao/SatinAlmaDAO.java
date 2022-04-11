package dao;

import entity.SatinAlma;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SatinAlmaDAO extends DBConnection {

    public void create(SatinAlma s) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into siparis_verir (siparis_id,kullanici_id,urun_id,tutar,tarih ) values(" + s.getSiparis_id() + "," + s.getKullanici_id() + "," + s.getUrun_id() + "," + s.getTutar() + ",'" + s.getTarih() + "')";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(SatinAlma s) {

        try {
            Statement st = this.getConnection().createStatement();
            String query = "update siparis_verir set kullanici_id=" + s.getKullanici_id() + ", urun_id=" + s.getUrun_id() + ", tutar=" + s.getTutar() + ", tarih='" + s.getTarih() + "'";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(SatinAlma s) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from siparis_verir where urun_id=" + s.getUrun_id();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<SatinAlma> getList() {

        List<SatinAlma> list = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();
            String query = "Select * from siparis_verir";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new SatinAlma(rs.getInt("siparis_id"), rs.getInt("kullanici_id"), rs.getInt("urun_id"), rs.getFloat("tutar"), rs.getString("tarih")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
