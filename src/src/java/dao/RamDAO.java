package dao;

import entity.Ram;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RamDAO extends DBConnection {

    public void create(Ram r) {
        try {
            Statement st = this.connect().createStatement();
            String query = "insert into Ram (kampanya_id,Bellek,Marka,fiyat,stok ) values('" + r.getKampanya_id() + "','" + r.getBellek() + "','" + r.getFiyat() + "','" + r.getStok() + "')";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Ram r) {

        try {
            Statement st = this.connect().createStatement();
            String query = "update Monitor set ram='" + r.getKampanya_id() + "',Marka='" + r.getMarka() + "',Bellek='" + r.getBellek() + "',Fiyat='" + r.getFiyat() + "',Stok='" + r.getStok() + "')";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Ram r) {
        try {
            Statement st = this.connect().createStatement();
            String query = "delete from Ram where urund_id=" + r.getUrun_id();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Ram> getList() {

        List<Ram> list = new ArrayList<>();

        try {
            Statement st = this.connect().createStatement();
            String query = "Select * from Ram";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Ram(rs.getInt("Bellek"), rs.getString("Marka"), rs.getFloat("fiyat"), rs.getInt("stok")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
