package com.promerica.dao.impl;

import com.promerica.dao.IProductoDAO;
import com.promerica.modelo.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ProductoDAOImpl implements IProductoDAO, Serializable {

    @PersistenceContext(unitName = "tiendaPU")
    private EntityManager em;

    @Override
    public Integer registrar(Producto t) throws Exception {
        try {
            t.setId(maxIdProducto());
            em.persist(t);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return t.getId();
    }

    @Override
    public Integer modificar(Producto t) throws Exception {
        em.merge(t);
        return 1;
    }

    @Override
    public Integer eliminar(Producto t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> listar() throws Exception {
        List<Producto> lista = new ArrayList<>();

        try {
            Query query = em.createQuery("SELECT p FROM Producto p WHERE p.estado !='I' ");
            lista = (List<Producto>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Producto listarPorId(Producto t) throws Exception {
    return em.find(Producto.class, t.getId());
    
    }

    public Integer maxIdProducto() {
        try {
            return (Integer) em.createNativeQuery("SELECT COALESCE(max(id),0)+1 from Producto")
                    .getSingleResult();
        } catch (Exception e) {
            return 0;
        }

    }

}
