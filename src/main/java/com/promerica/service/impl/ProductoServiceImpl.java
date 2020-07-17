package com.promerica.service.impl;


import com.promerica.dao.IProductoDAO;

import com.promerica.modelo.Producto;
import com.promerica.service.IProductoService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;

@Named
public class ProductoServiceImpl implements IProductoService, Serializable {

    @EJB
    private IProductoDAO dao;

    @Override
    public Integer registrar(Producto t) throws Exception {
        return dao.registrar(t);

    }

    @Override
    public Integer modificar(Producto t) throws Exception {

        return dao.modificar(t);
    }

    @Override
    public Integer eliminar(Producto t) throws Exception {
        return dao.eliminar(t);
    }

    @Override
    public List<Producto> listar() throws Exception {
        return dao.listar();
    }

    @Override
    public Producto listarPorId(Producto t) throws Exception {
      return dao.listarPorId(t);
    }

    @Override
    public Producto listarPorId(Integer intgr) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> listarById() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
