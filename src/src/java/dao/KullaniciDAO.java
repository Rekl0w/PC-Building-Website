package dao;

import entity.Kullanici;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KullaniciDAO extends DBConnection {

    public void create(Kullanici k) {
        try {
            Statement st = this.connect().createStatement();
            String query = "insert into kullanici (kullanici_id, ad_soyad, sifre) values('" + k.getKullanici_id() + "', '" + k.getAd_soyad() + "', '" + k.getSifre() + "') ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(Kullanici k) {
        try {
            Statement st = this.connect().createStatement();
            String query = "update kullanici set kullanici_id = '" + k.getKullanici_id() + "', ad_soyad ='" + k.getAd_soyad() + "', sifre = '" + k.getSifre() + "' ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(Kullanici k) {
        try {
            Statement st = this.connect().createStatement();
            String query = "delete from kullanici where kullanici_id = '" + k.getKullanici_id() + "'";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void getList() {
        List<Kullanici> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            String query = "select * from kullanici";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Kullanici(rs.getInt("kullanici_id"), rs.getString("ad_soyad"), rs.getString("sifre")));

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

}
