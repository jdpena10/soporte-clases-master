/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.ejb;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Mueble;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioOfertaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock.ServicioPersistenciaMock;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Stateless
@Path("/Muebles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServicioOfertaMock implements IServicioOfertaMockLocal {
    private IServicioPersistenciaMockLocal persistencia;

    
    public ServicioOfertaMock() {
        persistencia = new ServicioPersistenciaMock();
    }
    
    @POST
    @Path("/ofertas")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public void agregarOferta(Mueble mueble) {
        try {
            persistencia.create(mueble);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioCatalogoMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    @DELETE
    @Path("/ofertas/{id}")
    public Response removerOferta(@PathParam("id") long id) {
        Mueble mueble = (Mueble) persistencia.findById(Mueble.class, id);
        if (mueble != null) {
            try {
                persistencia.delete(mueble);
                return Response.ok().build();
            } catch (OperacionInvalidaException ex) {
                return Response.serverError().entity("Error al eliminar la oferta").build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Oferta no encontrada").build();
        }
    }


    @GET
    @Path("/{idMueble}/ofertas")
    @Override
    public ArrayList<Mueble> obtenerOfertasPorMueble(@PathParam("idMueble") int idMueble) {
        ArrayList<Mueble> mueblesConOfertas = persistencia.obtenerOfertasPorMueble(idMueble);
        return mueblesConOfertas;
    }

}

