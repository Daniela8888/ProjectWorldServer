package sk.akademiasovy.world.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MySQL {
    private Connection conn;
   private String url="jdbc:mysql://localhost:3306/world_x";
   private String username="root";
   private String password="";
    private String driver= "com.mysql.jdbc.Driver";
    public List<String> getCountries() {
        List<String> list = new ArrayList<>();
        try {
        Class.forName(driver).newInstance();
        conn= DriverManager.getConnection("");
        String query = "Select name form country";
            PreparedStatement ps= conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String name=rs.getString("name");
                list.add(name);
            }

    } catch(Exception ex){
        System.out.println("Error: " + ex.getMessage());
    }


        return list;
    }
}
