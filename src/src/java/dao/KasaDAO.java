package dao;

import entity.Kasa;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KasaDAO extends DBConnection {

    public void create(Kasa k) {
        try {
            Statement st = this.connect().createStatement();
            String query = "insert into kasa (kampanya_id, boyut, marka, fiyat, stok) values('" + k.getKampanya_id() + "', '" + k.getBoyut() + "', '" + k.getMarka() + "', '" + k.getFiyat() + "', '" + k.getStok() + "') ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(Kasa k) {
        try {
            Statement st = this.connect().createStatement();
            String query = "update kasa set kampanya_id = '" + k.getKampanya_id() + "', boyut ='" + k.getBoyut() + "', marka = '" + k.getMarka() + "', fiyat = '" + k.getFiyat() + "', stok = '" + k.getStok() + "' ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(Kasa k) {
        try {
            Statement st = this.connect().createStatement();
            String query = "delete from kasa where urun_id = '" + k.getUrun_id() + "'";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void getList() {
        List<Kasa> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            String query = "select * from kasa";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Kasa(rs.getInt("kampanya_id"), rs.getString("boyut"), rs.getString("marka"), rs.getFloat("fiyat"), rs.getInt("stok")));

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

}
