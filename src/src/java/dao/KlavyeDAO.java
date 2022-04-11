package dao;

import entity.Klavye;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KlavyeDAO extends DBConnection {

    private KampanyaDAO kampanyaDAO;
    public void create(Klavye k) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into klavye (urun_id, kampanya_id, switch_modeli, marka, fiyat, stok ) values(" + k.getUrun_id() + "," + k.getKampanya().getKampanya_id() + ",'"+k.getSwitch_modeli()+ "', '" + k.getMarka() + "'," + k.getFiyat() + "," + k.getStok() + ")";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Klavye k) {

        try {
            Statement st = this.getConnection().createStatement();
            String query = "update klavye set kampanya_id=" + k.getKampanya().getKampanya_id() + ",marka='" + k.getMarka() + "',fiyat=" + k.getFiyat() + ",switch_Modeli'" + k.getSwitch_modeli() + "',stok=" + k.getStok() + ")";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Klavye k) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from klavye where urun_id=" + k.getUrun_id();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Klavye> getList() {

        List<Klavye> list = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();
            String query = "Select * from klavye";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Klavye(rs.getInt("urun_id"), rs.getString("marka"), rs.getString("switch_modeli"), rs.getFloat("fiyat"), rs.getInt("stok"), this.getKampanyaDAO().findById(rs.getInt("kampanya_id"))));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public KampanyaDAO getKampanyaDAO() {
        if(this.kampanyaDAO == null){
            this.kampanyaDAO = new KampanyaDAO();
        }
        return kampanyaDAO;
    }

    public void setKampanyaDAO(KampanyaDAO kampanyaDAO) {
        this.kampanyaDAO = kampanyaDAO;
    }
    
}
