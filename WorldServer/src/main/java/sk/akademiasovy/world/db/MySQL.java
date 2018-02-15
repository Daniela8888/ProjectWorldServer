package sk.akademiasovy.world.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MySQL {



    private Connection conn;
    private String driver = "com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/world_x";
    private String username="user1";
    private String password="secret";
    public List<String> getCountries(){


        List<String> list = new ArrayList<>();
        try {

            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            String query = "SELECT Name from country";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String name=rs.getString("name");
                list.add(name);
            }

        }catch(Exception ex){
            System.out.println("Error: "+ ex.getMessage());
        }
        return list;
    }

    public List<String> getCities(String country){
        List<String> list = new ArrayList<>();
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            String query = "SELECT city.Name from city "+
                    " INNER JOIN country ON country.code=city.countrycode "+
                    " WHERE country.name like '"+country+"'";
            System.out.println(query);
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String name=rs.getString("name");
                list.add(name);
            }

        }catch(Exception ex){
            System.out.println("Error: "+ ex.getMessage());
        }
        return list;
    }

    public String getPopulation(String name) {
        String population="";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            String query = "SELECT JSON_EXTRACT(Info,\"$.Population\") as lol"+
                    " FROM city where name = '"+name+"'";
            System.out.println(query);
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                population=rs.getString("lol");
            }

        }catch(Exception ex){
            System.out.println("Error: "+ ex.getMessage());
        }
        return population;
    }


    public String getCountry(String city) {
        String result = "";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, username, password);
            String query = "Select country.name as cn from country INNER JOIN city on city.CountryCode = country.code where city.name = '" + city + "'";
            System.out.println(query);
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString("cn");
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }


        return result;
    }
}
