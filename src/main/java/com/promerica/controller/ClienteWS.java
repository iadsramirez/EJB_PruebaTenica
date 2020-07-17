package com.promerica.controller;

import com.promerica.modelo.Cliente;
import com.promerica.service.IClienteService;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.inject.Inject;

@WebService(serviceName = "ClienteWS")
@Stateless()
public class ClienteWS {

    @Inject
    private IClienteService service;

    @WebMethod(operationName = "guardarCliente")
    public Integer guardarCliente(@WebParam(name = "cliente") Cliente cliente) throws Exception {

        return service.registrar(cliente);
    }

    @WebMethod(operationName = "listadoClientes")
    public List<Cliente> listarClientes() throws Exception {

        return service.listar();
    }

    @WebMethod(operationName = "editarCliente")
    public Integer editarCliente(@WebParam(name = "cliente") Cliente cliente) throws Exception {

        return service.modificar(cliente);
    }

    
    @WebMethod(operationName = "clienteById")
    public Cliente obtenerClienteById(@WebParam(name = "cliente") Cliente cliente) throws Exception {

        return service.listarPorId(cliente);
    }





}

