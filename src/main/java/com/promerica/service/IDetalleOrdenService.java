
package com.promerica.service;

import com.promerica.modelo.DetalleOrden;
import java.util.List;


public interface IDetalleOrdenService extends IService<DetalleOrden> {
     
    List<DetalleOrden> buscarDetalleOrden(Integer idOrden);
}
