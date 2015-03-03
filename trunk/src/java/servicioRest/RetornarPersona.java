/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicioRest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.sun.jersey.api.json.JSONWithPadding;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import negocio.ConexionPostgres;
import org.json.JSONArray;
//import org.json.JSONObject;

/**

 *
 * @author cediazv
 */
@Path("/retornarPersona")
public class RetornarPersona {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String RetornarPersona(@QueryParam("prf_cedula")String prf_cedula) throws ClassNotFoundException, SQLException, Exception
    {          
        ConexionPostgres cs = new ConexionPostgres();
        JSONArray list = cs.retorna_persona(prf_cedula);
        String searchList = new Gson().toJson(list);
        return list.toString();
     }
    
}
