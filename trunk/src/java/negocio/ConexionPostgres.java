/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.sql.SQLException;
import negocio.Convertor;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author mac
 */
public class ConexionPostgres {
    public String ingreso_persona
        
        (String prf_nombres, String prf_apellidos,
            String prf_cedula,String prf_tipo_sangre,String prf_alergias,
            String prf_email,String prf_fecha_nacimiento ,String prf_direccion,
            String prf_telefono,String prf_pais,String prf_talla_camiseta,
            String prf_sexo ,String prf_telefono_contacto,
            String prf_nombre_contacto, String prf_condicion_medica,String prf_ciudad)
          {
        String consulta = "ok";
        String base ="inPerson";
        String driver = "org.postgresql.Driver";
        String connectString = "jdbc:postgresql://www.desafiovst.com:5432/"+base;
            String user = "infinit-plus";
            String password = "inf!nit*plus";
      

        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connectString, user , password);
            Statement stmt = con.createStatement();
            stmt.executeQuery(
                   
 " SELECT insertarperfil( '"+prf_nombres+"','"+prf_apellidos+"'," +
"            '"+prf_cedula+"','"+prf_tipo_sangre+"','"+prf_alergias+"'," +
"            '"+prf_email+"','" +prf_fecha_nacimiento+"','" +prf_direccion+"'," +
"            '"+prf_telefono+"','"+prf_pais+"','"+prf_talla_camiseta+"'," +
"            '"+prf_sexo+"','"+prf_telefono_contacto+"','"+prf_nombre_contacto+"','" +prf_condicion_medica+"','" +prf_ciudad+"');"
                                         );

            stmt.close();
            con.close();

            return consulta;

        }

        catch ( Exception e ){
            System.out.println(e.getMessage());
            return "mal"+e.getMessage();
        }
    }
    
    
    
    
    
    
    public JSONArray retorna_persona(String prf_cedula) throws ClassNotFoundException, SQLException, Exception
          {
              String base ="inPerson";
        String driver = "org.postgresql.Driver";
         String connectString = "jdbc:postgresql://www.desafiovst.com:5432/"+base;
            String user = "infinit-plus";
            String password = "inf!nit*plus";
         Class.forName(driver);
         Connection con = DriverManager.getConnection(connectString, user , password);
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery( " SELECT * from retornarPerfil( '"+prf_cedula+"');"); 
         JSONArray js= convertResultSetIntoJSON(rs);
         
            stmt.close();
            con.close();         
             
        return js;
        }

    public static JSONArray convertResultSetIntoJSON(ResultSet resultSet) throws Exception {
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            int total_rows = resultSet.getMetaData().getColumnCount();
            JSONObject obj = new JSONObject();
            for (int i = 0; i < total_rows; i++) {
                String columnName = resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase();
                Object columnValue = resultSet.getObject(i + 1);
                // if value in DB is null, then we set it to default value
                if (columnValue == null){
                    columnValue = "null";
                }
                /*
                Next if block is a hack. In case when in db we have values like price and price1 there's a bug in jdbc - 
                both this names are getting stored as price in ResulSet. Therefore when we store second column value,
                we overwrite original value of price. To avoid that, i simply add 1 to be consistent with DB.
                 */
                if (obj.has(columnName)){
                    columnName += "1";
                }
                obj.put(columnName, columnValue);
            }
            jsonArray.put(obj);
        }
        return jsonArray;
    }


           

    }

