package dao;

import entity.Anakart;
import entity.BilgisayarBileseni;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnakartDAO extends DBConnection {

    private KampanyaDAO kampanyaDAO;
    private BilgisayarBileseniDAO bbDao;

    public BilgisayarBileseniDAO getBbDao() {
        if (this.bbDao == null) {
            bbDao = new BilgisayarBileseniDAO();
        }
        return bbDao;
    }

    public void setBbDao(BilgisayarBileseniDAO bbDao) {
        this.bbDao = bbDao;
    }

    public void create(Anakart a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into anakart (kampanya_id, cpu_soketi, bellek_saat_hizi, marka, fiyat, stok) values(" + a.getKampanya().getKampanya_id() + ", '" + a.getCpu_soketi() + "', " + a.getBellek_saat_hizi() + ", '" + a.getMarka() + "', " + a.getFiyat() + ", " + a.getStok() + ") ";
            st.executeUpdate(query);

            ResultSet rs = st.executeQuery("select max(urun_id) as mid from anakart");

            rs.next();
            int id = rs.getInt("mid");

            BilgisayarBileseni bb = new BilgisayarBileseni(id, a.getMarka(), a.getFiyat(), a.getStok(), a.getKampanya());

            this.getBbDao().create(bb);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(Anakart a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update anakart set kampanya_id = '" + a.getKampanya().getKampanya_id() + "', cpu_soketi ='" + a.getCpu_soketi() + "', bellek_saat_hizi = " + a.getBellek_saat_hizi() + ", marka = '" + a.getMarka() + "', fiyat = " + a.getFiyat() + ", stok = " + a.getStok() + "where urun_id = " + a.getUrun_id();
            st.executeUpdate(query);

            ResultSet rs = st.executeQuery("select * from anakart where urun_id = " + a.getUrun_id());

            rs.next();
            int id = rs.getInt("urun_id");

            BilgisayarBileseni bb = new BilgisayarBileseni(id, a.getMarka(), a.getFiyat(), a.getStok(), a.getKampanya());

            this.getBbDao().update(bb);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(Anakart a) {
        try {
            Statement st = this.getConnection().createStatement();

            ResultSet rs = st.executeQuery("select * from anakart where urun_id = " + a.getUrun_id());
            rs.next();
            int id = rs.getInt("urun_id");

            BilgisayarBileseni bb = new BilgisayarBileseni(id, a.getMarka(), a.getFiyat(), a.getStok(), a.getKampanya());
            this.getBbDao().delete(bb);

            String query = "delete from anakart where urun_id = " + a.getUrun_id();
            st.executeUpdate(query);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public List<Anakart> getList() {
        List<Anakart> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from anakart");

            while (rs.next()) {
                list.add(new Anakart(rs.getInt("urun_id"), rs.getString("cpu_soketi"), rs.getInt("bellek_saat_hizi"), rs.getString("marka"), rs.getFloat("fiyat"), rs.getInt("stok"), this.getKampanyaDAO().findById(rs.getInt("kampanya_id"))));

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<Anakart> getList(int page) {
        int offset = (page - 1) * 5;
        List<Anakart> list = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from anakart order by urun_id asc offset "+ offset +"rows fetch next 5 rows only");
            while (rs.next()) {
                list.add(new Anakart(rs.getInt("urun_id"), rs.getString("cpu_soketi"), rs.getInt("bellek_saat_hizi"), rs.getString("marka"), rs.getFloat("fiyat"), rs.getInt("stok"), this.getKampanyaDAO().findById(rs.getInt("kampanya_id"))));

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
