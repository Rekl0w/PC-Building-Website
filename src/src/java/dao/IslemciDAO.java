package dao;

import entity.Islemci;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IslemciDAO extends DBConnection {

    public void create(Islemci a) {
        try {
            Statement st = this.connect().createStatement();
            String query = "insert into islemci (cekirdek_sayisi, hiz, kampanya_id, marka, fiyat, stok) values('" + a.getCekirdek_sayisi() + "','" + a.getHiz() + "','" + a.getKampanya_id() + "', '" + a.getMarka() + "', '" + a.getFiyat() + "', '" + a.getStok() + "' ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(Islemci a) {
        try {
            Statement st = this.connect().createStatement();
            String query = "update islemci set cekirdek_sayisi ='" + a.getCekirdek_sayisi() + "', hiz ='" + a.getHiz() + "', kampanya_id = '" + a.getKampanya_id() + "', marka ='" + a.getMarka() + "', fiyat = '" + a.getFiyat() + "', stok = '" + a.getStok() + "' ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(Islemci a) {
        try {
            Statement st = this.connect().createStatement();
            String query = "delete from islemci where urun_id = '" + a.getUrun_id() + "'";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public List<Islemci> getList() {
        List<Islemci> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            String query = "select * from islemci";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Islemci(rs.getInt("cekirdek_sayisi"), rs.getFloat("hiz"), rs.getString("marka"), rs.getFloat("fiyat"), rs.getInt("stok"), rs.getInt("kampanya_id")));

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return list;
    }

}
