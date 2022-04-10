package dao;

import entity.EkranKarti;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;

public class EkranKartiDAO extends DBConnection {

    public void create(EkranKarti a) {
        try {
            Statement st = this.connect().createStatement();
            String query = "insert into ekran_karti (model, bellek, kampanya_id, marka, fiyat, stok) values('" + a.getModel() + "','" + a.getBellek() + "','" + a.getKampanya().getKampanya_id() + "', '" + a.getMarka() + "', '" + a.getFiyat() + "', '" + a.getStok() + "' ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(EkranKarti a) {
        try {
            Statement st = this.connect().createStatement();
            String query = "update ekran_karti set model = '" + a.getModel() + "',bellek = '" + a.getBellek() + "', kampanya_id = '" + a.getKampanya().getKampanya_id() + "', marka ='" + a.getMarka() + "', fiyat = '" + a.getFiyat() + "', stok = '" + a.getStok() + "' ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(EkranKarti a) {
        try {
            Statement st = this.connect().createStatement();
            String query = "delete from ekran_karti where urun_id = '" + a.getUrun_id() + "'";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public List<EkranKarti> getList() {
        List<EkranKarti> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            String query = "select * from ekran_karti";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new EkranKarti(rs.getString("model"), rs.getInt("bellek"), rs.getString("marka"), rs.getFloat("fiyat"), rs.getInt("stok"), rs.getInt("kampanya_id")));

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return list;
    }

}
