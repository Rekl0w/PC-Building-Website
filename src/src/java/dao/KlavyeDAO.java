package dao;

import entity.Klavye;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KlavyeDAO extends DBConnection {

    public void create(Klavye k) {
        try {
            Statement st = this.connect().createStatement();
            String query = "insert into Klavye (kampanya_id,Marka,fiyat,Switch_modeli,stok ) values('" + k.getKampanya_id() + "','" + k.getMarka() + "','" + k.getFiyat() + "','" + k.getSwitch_modeli() + "','" + k.getStok() + "')";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Klavye k) {

        try {
            Statement st = this.connect().createStatement();
            String query = "update Klavye set kampanya_id='" + k.getKampanya_id() + "',Marka='" + k.getMarka() + "',Fiyat='" + k.getFiyat() + "',Switch_Modeli'" + k.getSwitch_modeli() + "',Stok='" + k.getStok() + "')";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Klavye k) {
        try {
            Statement st = this.connect().createStatement();
            String query = "delete from Klavye where urun_id=" + k.getUrun_id();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Klavye> getList() {

        List<Klavye> list = new ArrayList<>();

        try {
            Statement st = this.connect().createStatement();
            String query = "Select * from Klavye";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Klavye(rs.getString("marka"), rs.getString("Switch_modeli"), rs.getFloat("fiyat"), rs.getInt("stok")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
