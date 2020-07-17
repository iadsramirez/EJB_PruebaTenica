/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.promerica.controller;

import com.promerica.modelo.Producto;
import com.promerica.service.IProductoService;
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
@WebService(serviceName = "ProductoWS")
@Stateless()
public class ProductoWS {

    @Inject
    private IProductoService productoService;

    @WebMethod(operationName = "guardarProducto")
    public Integer guardarProducto(@WebParam(name = "producto") Producto producto) throws Exception {

        return productoService.registrar(producto);
    }

    @WebMethod(operationName = "listarProducto")
    public List<Producto> listarProducto() throws Exception {

        return productoService.listar();
    }
    
    @WebMethod(operationName = "editarProducto")
    public Integer editarProducto(@WebParam(name = "producto") Producto producto) throws Exception {

        return productoService.modificar(producto);
    }
    
    
    
}
