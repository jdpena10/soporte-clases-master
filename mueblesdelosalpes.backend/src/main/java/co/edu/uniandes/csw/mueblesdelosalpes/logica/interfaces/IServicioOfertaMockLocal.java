/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ IServicioOfertaMockLocal.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Daniel Peña
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Mueble;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.core.Response;

/**
 * Contrato funcional de los servicios para la gestión de ofertas
 * @author [Tu Nombre]
 */
@Local
public interface IServicioOfertaMockLocal {

    /**
     * Agrega una nueva oferta a la lista de ofertas
     * @param oferta Oferta que se desea agregar
     */
    public void agregarOferta(Mueble mueble);

    /**
     * Remueve una oferta de la lista de ofertas
     * @param oferta Oferta que se desea remover
     */

    

    /**
     * Retorna las ofertas aplicadas a un mueble específico
     * @param idMueble Identificador único del mueble
     * @return ofertas Lista de ofertas aplicadas al mueble
     */
    public ArrayList<Mueble> obtenerOfertasPorMueble(int idMueble);

}
