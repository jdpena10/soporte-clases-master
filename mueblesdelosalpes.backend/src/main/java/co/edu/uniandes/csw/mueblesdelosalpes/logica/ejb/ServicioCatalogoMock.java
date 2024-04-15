

package co.edu.uniandes.csw.mueblesdelosalpes.logica.ejb;

import co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock.ServicioPersistenciaMock;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Mueble;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioCatalogoMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioCatalogoMockRemote;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioPersistenciaMockLocal;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Stateless
@Path("/Muebles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServicioCatalogoMock implements IServicioCatalogoMockRemote, IServicioCatalogoMockLocal {
    private IServicioPersistenciaMockLocal persistencia;

    
    public ServicioCatalogoMock() {
        persistencia = new ServicioPersistenciaMock();
    }
  
    
    @POST
    @Path("agregar/")
    public void agregarMueble(Mueble mueble) {
        try {
            persistencia.create(mueble);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioCatalogoMock.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @DELETE
    @Path("{id}")
    public void eliminarMueble(long id) {
        Mueble m = (Mueble) persistencia.findById(Mueble.class, id);
        try {
            persistencia.delete(m);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioCatalogoMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @PUT
    @Path("{id}")
    public void removerEjemplarMueble(@PathParam("id") long id) {
        ArrayList<Mueble> muebles = (ArrayList<Mueble>) persistencia.findAll(Mueble.class);
        Mueble mueble;
        for (int i = 0; i < muebles.size(); i++) {
            mueble = muebles.get(i);
            if (mueble.getReferencia() == id) {
                int cantidad = mueble.getCantidad();
                mueble.setCantidad(cantidad - 1);
                persistencia.update(mueble);
                break;
            }
        }
    }


    //Devuelve los muebles del sistema, @return muebles Arreglo con todos los muebles del sistema
    @GET
    @Path("muebles/")
    public List<Mueble> darMuebles() {
        return persistencia.findAll(Mueble.class);
    }
}
