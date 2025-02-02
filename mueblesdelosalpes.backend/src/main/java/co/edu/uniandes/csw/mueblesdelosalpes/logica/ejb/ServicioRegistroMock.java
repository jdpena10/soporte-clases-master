

package co.edu.uniandes.csw.mueblesdelosalpes.logica.ejb;

import co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock.ServicioPersistenciaMock;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Usuario;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioRegistroMockRemote;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioRegistroMockLocal;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de los servicios de registro de un cliente en el sistema
 * @author Juan Sebastián Urrego
 */
public class ServicioRegistroMock implements IServicioRegistroMockRemote, IServicioRegistroMockLocal
{
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    
    /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    private IServicioPersistenciaMockLocal persistencia;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor de la clase sin argumentos
     */
     public ServicioRegistroMock()
     {
        persistencia=new ServicioPersistenciaMock();
     }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    /**
     * Verifica y registra un usuario en el sistema
     * @param u Usuario a persistir
     */
    @Override
    public void registrar(Usuario u)throws OperacionInvalidaException
    {
        try
        {
            if(u.getDocumento()!=0)
            {

            persistencia.create(u);
            }
            else
            {
                throw new OperacionInvalidaException("El número de documento no es válido");
            }
        }
        catch (OperacionInvalidaException ex)
        {
            throw new OperacionInvalidaException(ex.getMessage());
        }
    }

    /**
     * Elimina un cliente del sistema dado su login
     * @param login Login del cliente
     * @throws OperacionInvalidaException Excepción que es lanzada en caso de ocurrir un error
     */
    @Override
    public void eliminarCliente(String login) throws OperacionInvalidaException
    {
        try
        {
        Usuario u=(Usuario) persistencia.findById(Usuario.class, login);
        persistencia.delete(u);
        }
        catch(OperacionInvalidaException e)
        {
            throw new OperacionInvalidaException("Ocurrió un error al momento de eliminar");
        }
    }

    /**
     * Devuelve los clientes del sistema
     * @return clientes Lista con todos los clientes del sistema
     */
    @Override
    public List<Usuario> darClientes()
    {
        return(ArrayList<Usuario>) persistencia.findAll(Usuario.class);
    }

}
