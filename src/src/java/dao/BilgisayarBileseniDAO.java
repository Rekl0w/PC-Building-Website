package dao;

import entity.Anakart;
import entity.BilgisayarBileseni;
import entity.Kampanya;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BilgisayarBileseniDAO extends DBConnection {

    private KampanyaDAO kampanyaDAO;

    public void create(BilgisayarBileseni a) {
        try {
            Statement st = this.connect().createStatement();
            String query = "insert into bilgisayar_bileseni (kampanya_id, marka, fiyat, stok) values('" + a.getKampanya().getKampanya_id() + "', '" + a.getMarka() + "', '" + a.getFiyat() + "', '" + a.getStok() + "' ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(BilgisayarBileseni a) {
        try {
            Statement st = this.connect().createStatement();
            String query = "update bilgisayar_bileseni set kampanya_id = '" + a.getKampanya().getKampanya_id() + "', marka ='" + a.getMarka() + "', fiyat = '" + a.getFiyat() + "', stok = '" + a.getStok() + "' ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(BilgisayarBileseni a) {
        try {
            Statement st = this.connect().createStatement();
            String query = "delete from bilgisayar_bileseni where urun_id = '" + a.getUrun_id() + "'";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public List<BilgisayarBileseni> getList() {
        List<BilgisayarBileseni> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            String query = "select * from bilgisayar_bileseni";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new BilgisayarBileseni(rs.getString("marka"), rs.getFloat("fiyat"), rs.getInt("stok"), kampanyaDAO.findById(rs.getInt("kampanya_id"))));

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
