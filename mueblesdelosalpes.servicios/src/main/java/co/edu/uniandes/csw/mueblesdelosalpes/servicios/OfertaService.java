
package co.edu.uniandes.csw.mueblesdelosalpes.servicios;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Mueble;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioOfertaMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Ofertas")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OfertaService {
 
    @EJB
    private IServicioOfertaMockLocal ofertaEjb;
 
    @POST
    @Path("agregar")
    public Mueble agregarOferta(Mueble mueble) {
        ofertaEjb.agregarOferta(mueble);
        return mueble;
    }
    
}
