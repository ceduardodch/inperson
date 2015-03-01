/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicioRest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import negocio.ConexionPostgres;

/**
 *
 * @author mac
 */
@Path("/servicioPersona")
public class IngresoPersona {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String pruebaPersona(
    @QueryParam("prf_nombres")String prf_nombres, 
    @QueryParam("prf_apellidos")String prf_apellidos,
    @QueryParam("prf_cedula")String prf_cedula,
    @QueryParam("prf_tipo_sangre")String prf_tipo_sangre,
    @QueryParam("prf_alergias")String prf_alergias,
    @QueryParam("prf_email")String prf_email,
    @QueryParam("prf_fecha_nacimiento")String prf_fecha_nacimiento ,
    @QueryParam("prf_direccion")String prf_direccion,
    @QueryParam("prf_telefono")String prf_telefono,
    @QueryParam("prf_pais")String prf_pais,
    @QueryParam("prf_talla_camiseta")String prf_talla_camiseta,
    @QueryParam("prf_sexo")String prf_sexo ,
    @QueryParam("prf_telefono_contacto")String prf_telefono_contacto,
    @QueryParam("prf_nombre_contacto")String prf_nombre_contacto, 
    @QueryParam("prf_condicion_medica")String prf_condicion_medica)
    {
        ConexionPostgres cs = new ConexionPostgres();
        return cs.ingreso_persona(prf_nombres, prf_apellidos, prf_cedula,prf_tipo_sangre,prf_alergias,prf_email,prf_fecha_nacimiento , prf_direccion, prf_telefono,prf_pais,prf_talla_camiseta,prf_sexo ,prf_telefono_contacto, prf_nombre_contacto, prf_condicion_medica);
        //return "OK ";
    }
}
