package dao;

import entity.Kullanici;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KullaniciDAO extends DBConnection {

    public void create(Kullanici k) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into kullanici (ad_soyad, sifre) values('"+ k.getAd_soyad() + "', '" + k.getSifre() + "') ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(Kullanici k) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update kullanici set ad_soyad ='" + k.getAd_soyad() + "', sifre = '" + k.getSifre() + "' where kullanici_id = " +k.getKullanici_id();
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(Kullanici k) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from kullanici where kullanici_id = " + k.getKullanici_id() ;
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }
    public boolean verifyLogin(Kullanici k){
        try {
            Statement st = getConnection().createStatement();
            String query = "SELECT * FROM kullanici WHERE ad_soyad='"+k.getAd_soyad()+"' AND sifre='"+k.getSifre()+"'";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                k.setKullanici_id(rs.getInt("kullanici_id"));
                k.setAd_soyad(rs.getString("ad_soyad"));
                k.setAd_soyad(rs.getString("sifre"));
                
                
            }
        } catch (Exception ex) {
            
            System.out.println(ex.getMessage());
        }
        
        if(k.getKullanici_id()!= 0){
            return true;
        }
        return false;
    }
    
    public List<Kullanici> getList() {
        List<Kullanici> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from kullanici order by kullanici_id asc ";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Kullanici(rs.getInt("kullanici_id"), rs.getString("ad_soyad"), rs.getString("sifre")));

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<Kullanici> getList(int page) {
        int offset = (page - 1) * 5;
        List<Kullanici> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanici order by kullanici_id asc limit 5 offset " + offset);

            while (rs.next()) {
                list.add(new Kullanici(rs.getInt("kullanici_id"), rs.getString("ad_soyad"), rs.getString("sifre")));

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    public Kullanici findById(int id){
        Kullanici k = null;
         try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from kullanici where kullanici_id" + id;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                k = new Kullanici(rs.getString("ad_soyad"), rs.getString("sifre"));
            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        
        return k;
    }

}
