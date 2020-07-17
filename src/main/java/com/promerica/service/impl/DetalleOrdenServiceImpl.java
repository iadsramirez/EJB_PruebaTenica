package com.promerica.service.impl;

import com.promerica.dao.IDetalleOrdenDAO;
import com.promerica.modelo.DetalleOrden;
import com.promerica.service.IDetalleOrdenService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;

@Named
public class DetalleOrdenServiceImpl implements IDetalleOrdenService, Serializable {

    @EJB
    private IDetalleOrdenDAO dao;

    @Override
    public Integer registrar(DetalleOrden t) throws Exception {
        return dao.registrar(t);

    }

    @Override
    public Integer modificar(DetalleOrden t) throws Exception {

        return dao.modificar(t);
    }

    @Override
    public Integer eliminar(DetalleOrden t) throws Exception {
        return dao.eliminar(t);
    }

    @Override
    public List<DetalleOrden> listar() throws Exception {
        return dao.listar();
    }

    @Override
    public DetalleOrden listarPorId(DetalleOrden t) throws Exception {
        return dao.listarPorId(t);
    }

    @Override
    public DetalleOrden listarPorId(Integer intgr) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<DetalleOrden> listarById() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleOrden> buscarDetalleOrden(Integer idOrden) {

        return dao.buscarDetalleOrden(idOrden);
    }

}
