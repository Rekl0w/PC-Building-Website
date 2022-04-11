package dao;

import entity.Monitor;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MonitorDAO extends DBConnection {

    private KampanyaDAO kampanyaDAO;
    public void create(Monitor m) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into monitor (urun_id, kampanya_id, boyut, ekran_yenileme_hizi, marka, fiyat, stok) values(" + m.getUrun_id() + "," + m.getKampanya().getKampanya_id() + "," + m.getBoyut() + "," + m.getEkran_yenileme_hizi() + ", '" + m.getMarka() + "'," + m.getFiyat() + "," + m.getStok() + ")";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Monitor m) {

        try {
            Statement st = this.getConnection().createStatement();
            String query = "update monitor set kampanya_id=" + m.getKampanya().getKampanya_id() + ",marka='" + m.getMarka() + "',ekran_yenileme_hizi=" + m.getEkran_yenileme_hizi() + ",fiyat=" + m.getFiyat() + ",stok=" + m.getStok() + ")";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Monitor m) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from monitor where urun_id=" + m.getUrun_id();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Monitor> getList() {

        List<Monitor> list = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();
            String query = "Select * from monitor";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Monitor(rs.getInt("urun_id"), this.kampanyaDAO.findById(rs.getInt("kampanya_id")), rs.getInt("boyut"), rs.getInt("ekran_yenileme_hizi"), rs.getString("marka"), rs.getFloat("fiyat"), rs.getInt("stok")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
