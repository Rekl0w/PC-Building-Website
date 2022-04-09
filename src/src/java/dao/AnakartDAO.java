/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Anakart;
import java.sql.Statement;

/**
 *
 * @author musabeytekin
 */
public class AnakartDAO extends DBConnection {

    public void create(Anakart a) {
        try {
            Statement st = this.connect().createStatement();
            String query = "insert into anakart (kampanya_id, cpu_soketi_markasi, bellek_saat_hizi, marka, fiyat, stok) values('" + a.getKampanya_id() + "', '" + a.getCpu_soketi() + "', '" + a.getBellek_saat_hizi() + "', '" + a.getMarka() + "', '" + a.getFiyat() + "', '" + a.getStok() + "') ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(Anakart a) {
        try {
            Statement st = this.connect().createStatement();
            String query = "insert into anakart (kampanya_id, cpu_soketi_markasi, bellek_saat_hizi, marka, fiyat, stok) values('" + a.getKampanya_id() + "', '" + a.getCpu_soketi() + "', '" + a.getBellek_saat_hizi() + "', '" + a.getMarka() + "', '" + a.getFiyat() + "', '" + a.getStok() + "') ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(Anakart a) {
        try {
            Statement st = this.connect().createStatement();
            String query = "update anakart set kampanya_id = '"+a.getKampanya_id()+"', cpu_soketi_markasi = '"+a.getCpu_soketi()+"', bellek_saat_hizi = '"+a.getBellek_saat_hizi()+"', marka = '"+a.getFiyat()+"', fiyat = '"+a.getStok()+"' ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void getList() {
        try {
            Statement st = this.connect().createStatement();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

}
