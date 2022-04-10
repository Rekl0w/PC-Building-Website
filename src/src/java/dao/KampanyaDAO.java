package dao;

import entity.Kampanya;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KampanyaDAO extends DBConnection {
    
    

    public void create(Kampanya k) {
        try {
            Statement st = this.connect().createStatement();
            String query = "insert into kampanya (kampanya_id, indirim_yuzdesi) values('" + k.getKampanya_id() + "', '" + k.getIndirim_yuzdesi() + "') ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(Kampanya k) {
        try {
            Statement st = this.connect().createStatement();
            String query = "update kampanya set kampanya_id = '" + k.getKampanya_id() + "', indirim_yuzdesi ='" + k.getIndirim_yuzdesi() + "' ";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(Kampanya k) {
        try {
            Statement st = this.connect().createStatement();
            String query = "delete from kampanya where kampanya_id = '" + k.getKampanya_id() + "'";
            st.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }
    
    public Kampanya findById(int id){
        Kampanya k = null;
         try {
            Statement st = this.connect().createStatement();
            String query = "select * from kampanya";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                k = new Kampanya(rs.getInt("id"), rs.getFloat("indirim_yuzdesi"));

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        
        return k;
    }

    public List<Kampanya> getList() {
        List<Kampanya> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            String query = "select * from kampanya";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Kampanya(rs.getInt("kampanya_id"), rs.getFloat("indirim_yuzdesi")));

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return list;
    }
    

}
