package dao;

import entity.SystemUser;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DBConnection {
    
    private GroupDAO gdao;
    
    public void create(SystemUser a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into systemuser (email,pass,ugroup) values(" + a.getEmail() + "', '"+a.getPass()+"', '"+ a.getGroup().getId()+ ") ";
            st.executeUpdate(query);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void update(SystemUser a) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update systemuser set pass = '" + a.getPass()+ "', ugroup="+ a.getGroup().getId() + " where id =" + a.getId();
            st.executeUpdate(query);
 
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void delete(SystemUser a) {
        try {
            Statement st = this.getConnection().createStatement();
            
            
            String query = "delete from systemuser where id = " + a.getId();
            st.executeUpdate(query);
            
            
            

            
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public List<SystemUser> getList() {
        List<SystemUser> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from systemuser";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new SystemUser(rs.getLong("id"), rs.getString("gname"), rs.getDate("created"), rs.getDate("updated")));

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return list;
    }

    public GroupDAO getGdao() {
        if(this.gdao == null){
            this.gdao = new GroupDAO();
        }
        return gdao;
    }

    public void setGdao(GroupDAO gdao) {
        this.gdao = gdao;
    }

}
