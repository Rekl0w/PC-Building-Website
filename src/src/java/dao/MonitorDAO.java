package dao;

import entity.Monitor;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MonitorDAO extends DBConnection {

    public void create(Monitor m) {
        try {
            Statement st = this.connect().createStatement();
            String query = "insert into Monitor (kampanya_id,ekran_yenileme_hizi,Marka,fiyat,stok ) values('" + m.getKampanya_id() + "','" + m.getEkran_yenileme_hizi() + "','" + m.getFiyat() + "','" + m.getStok() + "')";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Monitor m) {

        try {
            Statement st = this.connect().createStatement();
            String query = "update Monitor set kampanya_id='" + m.getKampanya_id() + "',Marka='" + m.getMarka() + "',Ekran_yenileme_hizi='" + m.getEkran_yenileme_hizi() + "',Fiyat='" + m.getFiyat() + "',Stok='" + m.getStok() + "')";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Monitor m) {
        try {
            Statement st = this.connect().createStatement();
            String query = "delete from Monitor where urun_id=" + m.getUrun_id();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Monitor> getList() {

        List<Monitor> list = new ArrayList<>();

        try {
            Statement st = this.connect().createStatement();
            String query = "Select * from Monitor";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Monitor(rs.getInt("Ekran_yenileme_hizi"), rs.getString("Marka"), rs.getFloat("fiyat"), rs.getInt("stok")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
