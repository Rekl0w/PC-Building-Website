package dao;

import entity.Ram;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RamDAO extends DBConnection {
    
    private KampanyaDAO kampanyaDAO;
    public void create(Ram r) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into ram (urun_id, kampanya_id, bellek, marka, fiyat, stok ) values(" + r.getUrun_id() + "," + r.getKampanya().getKampanya_id() + "," + r.getBellek() + ",'" + r.getMarka() + "',"+ r.getFiyat() + "," + r.getStok() + ")";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Ram r) {

        try {
            Statement st = this.getConnection().createStatement();
            String query = "update monitor set kampanya_id=" +r.getKampanya().getKampanya_id()+ ",marka='" + r.getMarka() + "',bellek=" + r.getBellek() + ",fiyat=" + r.getFiyat() + ",stok=" + r.getStok() + ")";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Ram r) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from ram where urund_id=" + r.getUrun_id();
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Ram> getList() {

        List<Ram> list = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();
            String query = "Select * from ram";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Ram(rs.getInt("urun_id"), rs.getInt("bellek"), rs.getString("marka"), rs.getFloat("fiyat"), rs.getInt("stok"), this.getKampanyaDAO().findById(rs.getInt("kampanya_id"))));

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
