package sk.akademiasovy.world.resources;

import sk.akademiasovy.world.db.MySQL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path("/world")
public class World {
    @GET
    @Path("/countries")
    @Produces(MediaType.APPLICATION_JSON)




        public String getCountries(){
        MySQL mySQL=new MySQL();
        List <String> list = mySQL.getCountries();
        System.out.println(list);
        boolean b=false;
        String result= "{\name\":[";

            for(String temp:list){
                result+="\""temp+"\"";
            }
            result+="]}";
            return result;
        }

    }

