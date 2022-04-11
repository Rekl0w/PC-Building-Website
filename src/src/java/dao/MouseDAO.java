package dao;

import entity.Mouse;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MouseDAO extends DBConnection {

    private KampanyaDAO kampanyaDAO;
    public void create(Mouse m1) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into mouse (kampanya_id,ekran_yenileme_hizi,Marka,fiyat,stok ) values(" + m1.getKampanya().getKampanya_id()+ ",'" + m1.getBaglanma_sekli() + "'," + m1.getFiyat() + "," + m1.getStok() + ")";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Mouse m1) {

        try {
            Statement st = this.getConnection().createStatement();
            String query = "update mouse set mouse=" + m1.getKampanya().getKampanya_id()+ ",marka='" + m1.getMarka() + "',baglanma_sekli='" + m1.getBaglanma_sekli() + "',fiyat=" + m1.getFiyat() + ",stok=" + m1.getStok() + ")";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Mouse m1) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from mouse where urun_id=" + m1.getUrun_id();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Mouse> getList() {

        List<Mouse> list = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();
            String query = "Select * from mouse";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Mouse(rs.getString("baglanma_sekli"), rs.getString("marka"), rs.getFloat("fiyat"), rs.getInt("stok"),this.kampanyaDAO.findById(rs.getInt("kampanya_id"))));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
