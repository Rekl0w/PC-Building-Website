package dao;

import entity.Document;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentDAO extends DBConnection{

    public List<Document> findAll() {
        List<Document> dList = new ArrayList<>();
        
        try{
        
            PreparedStatement pst = this.getConnection().prepareStatement("select * from document");
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Document d = new Document();
                d.setId(rs.getLong("id"));
                d.setFilePath(rs.getString("path"));
                d.setFileName(rs.getString("name"));
                d.setFileType(rs.getString("type"));
                
                
                dList.add(d);
            }
            
        }catch ( SQLException e){
            System.out.println(e.getMessage());
        }
        return dList;

    }
    
    public void insert(Document d){
        String query = "insert into document (path,name,type) values (?,?,?)";
        try{
        
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, d.getFilePath());
            pst.setString(2, d.getFileName());
            pst.setString(3, d.getFileType());
            pst.executeUpdate();
           

        }catch ( SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
