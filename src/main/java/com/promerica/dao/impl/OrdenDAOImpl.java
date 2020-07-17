package com.promerica.dao.impl;

import com.promerica.dao.IOrdenDAO;
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
public class OrdenDAOImpl implements IOrdenDAO, Serializable {

    @PersistenceContext(unitName = "tiendaPU")
    private EntityManager em;

    @Override
    public Integer registrar(Orden t) throws Exception {
        try {
            t.setIdOrden(maxIdOrden());
            em.persist(t);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return t.getIdOrden();
    }

    @Override
    public Integer modificar(Orden t) throws Exception {
        em.merge(t);
        return 1;
    }

    @Override
    public Integer eliminar(Orden t) throws Exception {
        throw new UnsupportedOperationException("cambio de estado no es recomendables eliminar");
    }

    @Override
    public List<Orden> listar() throws Exception {
        List<Orden> lista = new ArrayList<>();

        try {
            Query query = em.createQuery("SELECT p FROM Orden p  ");
            lista = (List<Orden>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Orden listarPorId(Orden t) throws Exception {
        return em.find(Orden.class, t.getIdOrden());

    }

    public Integer maxIdOrden() {
        try {
            return (Integer) em.createNativeQuery("SELECT COALESCE(max(id_orden),0)+1 from orden ")
                    .getSingleResult();
        } catch (Exception e) {
            return 0;
        }

    }

    public List<DetalleOrden> obtenerDetalleByOrden(Orden orden) {
        return em.createQuery("SELECT d FROM DetalleOrden d WHERE d.orden.idOrden=:id")
                .setParameter("id", orden.getIdOrden())
                .getResultList();

    }

}
