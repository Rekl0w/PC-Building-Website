package dao;

import entity.SystemGroup;
import entity.BilgisayarBileseni;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO extends DBConnection {
    
    public void create(SystemGroup a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into systemgroup (gname) values(" + a.getGname() + ") ";
            st.executeUpdate(query);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(SystemGroup a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update systemgroup set gname = '" + a.getGname() + "'where id =" + a.getId();
            st.executeUpdate(query);
 
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(SystemGroup a) {
        try {
            Statement st = this.getConnection().createStatement();
            
            
            String query = "delete from systemgroup where id = " + a.getId();
            st.executeUpdate(query);
            
            
            

            
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public List<SystemGroup> getList() {
        List<SystemGroup> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from systemgroup";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new SystemGroup(rs.getLong("id"), rs.getString("gname"), rs.getDate("created"), rs.getDate("updated")));

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return list;
    }

}
