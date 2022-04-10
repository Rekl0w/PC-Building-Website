package dao;

import entity.Kasa;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KasaDAO extends DBConnection {

    private KampanyaDAO kampanyaDAO;

    public void create(Kasa k) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into kasa (urun_id, boyut, marka, fiyat, stok,kampanya_id) values(" + k.getUrun_id() + ", " + k.getBoyut() + ", '" + k.getMarka() + "', " + k.getFiyat() + ", " + k.getStok() + ", " + k.getKampanya().getKampanya_id() + ") ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(Kasa k) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update kasa set kampanya_id = " + k.getKampanya().getKampanya_id() + ", boyut =" + k.getBoyut() + ", marka = '" + k.getMarka() + "', fiyat = " + k.getFiyat() + ", stok = " + k.getStok();
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(Kasa k) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from kasa where urun_id = " + k.getUrun_id();
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public List<Kasa> getList() {
        List<Kasa> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from kasa";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Kasa(rs.getInt("urun_id"), rs.getString("boyut"), rs.getString("marka"), rs.getFloat("fiyat"), rs.getInt("stok"), this.getKampanyaDAO().findById(rs.getInt("kampanya_id"))));
            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return list;
    }

    public KampanyaDAO getKampanyaDAO() {
        if (this.kampanyaDAO == null) {
            this.kampanyaDAO = new KampanyaDAO();
        }
        return kampanyaDAO;
    }

    public void setKampanyaDAO(KampanyaDAO kampanyaDAO) {
        this.kampanyaDAO = kampanyaDAO;
    }
}
