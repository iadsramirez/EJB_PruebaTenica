/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.promerica.controller;

import com.promerica.modelo.Cliente;
import com.promerica.modelo.Orden;
import com.promerica.service.IOrdenService;
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
@WebService(serviceName = "OrderWS")
@Stateless()
public class OrderWS {

     @Inject
    private IOrdenService ordenService;

    @WebMethod(operationName = "guardarOrden")
    public Integer guardarOrden(@WebParam(name = "orden") Orden orden,@WebParam(name = "cliente") Cliente cliente) throws Exception {
        orden.setCliente(cliente);
        return ordenService.registrar(orden);
    }

    @WebMethod(operationName = "listaOrden")
    public List<Orden> listarOrden() throws Exception {

        return ordenService.listar();
    }
    
    
    
    @WebMethod(operationName = "ordenById")
    public Orden ordenById(@WebParam(name = "orden") Orden orden) throws Exception {

        return ordenService.listarPorId(orden);
    }
}
