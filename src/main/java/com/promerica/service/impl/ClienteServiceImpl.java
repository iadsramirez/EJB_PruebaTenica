package com.promerica.service.impl;

import com.promerica.dao.IClienteDAO;
import com.promerica.modelo.Cliente;
import com.promerica.service.IClienteService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;

@Named
public class ClienteServiceImpl implements IClienteService, Serializable {

    @EJB
    private IClienteDAO dao;

    @Override
    public Integer registrar(Cliente t) throws Exception {
        return dao.registrar(t);

    }

    @Override
    public Integer modificar(Cliente t) throws Exception {

        return dao.modificar(t);
    }

    @Override
    public Integer eliminar(Cliente t) throws Exception {
        return dao.eliminar(t);
    }

    @Override
    public List<Cliente> listar() throws Exception {
        return dao.listar();
    }

    @Override
    public Cliente listarPorId(Cliente t) throws Exception {
      return dao.listarPorId(t);
    }

    @Override
    public Cliente listarPorId(Integer intgr) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> listarById() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
