package com.promerica.service.impl;

import com.promerica.dao.IOrdenDAO;
import com.promerica.modelo.Orden;
import com.promerica.service.IOrdenService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;

@Named
public class OrdenServiceImpl implements IOrdenService, Serializable {

    @EJB
    private IOrdenDAO dao;

    @Override
    public Integer registrar(Orden t) throws Exception {
        return dao.registrar(t);

    }

    @Override
    public Integer modificar(Orden t) throws Exception {

        return dao.modificar(t);
    }

    @Override
    public Integer eliminar(Orden t) throws Exception {
        return dao.eliminar(t);
    }

    @Override
    public List<Orden> listar() throws Exception {
        return dao.listar();
    }

    @Override
    public Orden listarPorId(Orden t) throws Exception {
      return dao.listarPorId(t);
    }

    @Override
    public Orden listarPorId(Integer intgr) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Orden> listarById() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
