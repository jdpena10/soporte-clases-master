/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ IServicioPersistenciaMockLocal.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Mueble;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import java.util.ArrayList;

import javax.ejb.Local;

/**
 * Contrato funcional de los servicios de persistencia de manera local.
 * @author Juan Sebastián Urrego
 */

public interface IServicioPersistenciaMockLocal
{

    /**
     * Crea un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere crear.
     */
    public void create(java.lang.Object obj)throws OperacionInvalidaException;

    /**
     * Modifica un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere modificar.
     */
    public void update(java.lang.Object obj);

    /**
     * Elimina un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere borrar.
     */
    public void delete(java.lang.Object obj)throws OperacionInvalidaException;

    /**
     * Devuelve una lista con de todos los elementos de una clase dada que se encuentran en el sistema.
     * @param c Clase cuyos objetos quieren encontrarse en el sistema.
     * @return list Listado de todos los objetos de una clase.
     */
    public java.util.List findAll(java.lang.Class c);

    /**
     * Retorna la instancia de una entidad dado un identificador y la clase de la entidad.
     * @param c Clase de la instancia que se quiere buscar.
     * @param id Identificador unico del objeto.
     * @return obj Resultado de la consulta.
     */
    public java.lang.Object findById(java.lang.Class c, Object id);

    public ArrayList<Mueble> obtenerOfertasPorMueble(int idMueble);

    public void limpiarOfertas();
    
}
