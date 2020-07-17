
package com.promerica.dao;
import com.promerica.modelo.DetalleOrden;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IDetalleOrdenDAO extends ICRUD<DetalleOrden>{
    
    List<DetalleOrden> buscarDetalleOrden(Integer idOrden);
   
}
