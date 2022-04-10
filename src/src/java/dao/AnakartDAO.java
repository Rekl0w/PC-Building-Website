package dao;

import entity.Anakart;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnakartDAO extends DBConnection {
    
    private KampanyaDAO kampanyaDAO;
    public void create(Anakart a) {
        try {
            Statement st = this.connect().createStatement();
            String query = "insert into anakart (kampanya_id, cpu_soketi, bellek_saat_hizi, marka, fiyat, stok) values('" + a.getKampanya().getKampanya_id()+ "', '" + a.getCpu_soketi() + "', '" + a.getBellek_saat_hizi() + "', '" + a.getMarka() + "', '" + a.getFiyat() + "', '" + a.getStok() + "') ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(Anakart a) {
        try {
            Statement st = this.connect().createStatement();
            String query = "update anakart set kampanya_id = '" + a.getKampanya().getKampanya_id() + "', cpu_soketi ='" + a.getCpu_soketi() + "', bellek_saat_hizi = '" + a.getBellek_saat_hizi() + "', marka = '" + a.getMarka() + "', fiyat = '" + a.getFiyat() + "', stok = '" + a.getStok() + "' ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(Anakart a) {
        try {
            Statement st = this.connect().createStatement();
            String query = "delete from anakart where urun_id = '" + a.getUrun_id() + "'";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public List<Anakart> getList() {
        List<Anakart> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            String query = "select * from anakart";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Anakart(this.getKampanyaDAO().findById(rs.getInt("kampanya_id")), rs.getString("cpu_soketi"), rs.getInt("bellek_saat_hizi"), rs.getString("marka"), rs.getFloat("fiyat"), rs.getInt("stok")));

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
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
