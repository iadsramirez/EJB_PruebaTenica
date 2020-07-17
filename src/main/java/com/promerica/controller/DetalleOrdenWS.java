/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.promerica.controller;

import com.promerica.modelo.DetalleOrden;
import com.promerica.service.IDetalleOrdenService;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author user
 */
@WebService(serviceName = "DetalleOrdenWS")
@Stateless()
public class DetalleOrdenWS {

     @Inject
    private IDetalleOrdenService ordenService;

    @WebMethod(operationName = "guardarOrdenDetalle")
    public Integer guardarDetalleOrden(@WebParam(name = "detalle") DetalleOrden detalle) throws Exception {

        return ordenService.registrar(detalle);
    }

    @WebMethod(operationName = "listaDetalleOrden")
    public List<DetalleOrden> listarDetalleOrden() throws Exception {
        return ordenService.listar();
    }
    
    @WebMethod(operationName = "buscarDetalleOrden")
    public List<DetalleOrden> detalleAsociadoOrden(@WebParam(name = "id") Integer id) throws Exception {
        return ordenService.buscarDetalleOrden(id);
    }
    
    
    
    
}
