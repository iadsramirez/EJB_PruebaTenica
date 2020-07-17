package com.promerica.dao.impl;

import com.promerica.dao.IDetalleOrdenDAO;
import com.promerica.modelo.DetalleOrden;
import com.promerica.modelo.Orden;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class DetalleOrdenDAOImpl implements IDetalleOrdenDAO, Serializable {

    @PersistenceContext(unitName = "tiendaPU")
    private EntityManager em;

    @Override
    public Integer registrar(DetalleOrden t) throws Exception {
        try {
            t.setIdDetalleOrden(maxIdDetalleOrden());
            em.persist(t);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return t.getIdDetalleOrden();
    }

    @Override
    public Integer modificar(DetalleOrden t) throws Exception {
        em.merge(t);
        return 1;
    }

    @Override
    public Integer eliminar(DetalleOrden t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleOrden> listar() throws Exception {
        List<DetalleOrden> lista = new ArrayList<>();

        try {
            Query query = em.createQuery("SELECT p FROM DetalleOrden p  ");
            lista = (List<DetalleOrden>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public DetalleOrden listarPorId(DetalleOrden t) throws Exception {
        return em.find(DetalleOrden.class, t.getIdDetalleOrden());

    }

    public Integer maxIdDetalleOrden() {
        try {
            return (Integer) em.createNativeQuery("SELECT COALESCE(max(id_detalle_orden),0)+1 from detalle_orden ")
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public List<DetalleOrden> buscarDetalleOrden(Integer id) {

        return em.createQuery("SELECT d FROM DetalleOrden d WHERE d.orden.idOrden=:id")
                .setParameter("id", id).getResultList();

    }

}
