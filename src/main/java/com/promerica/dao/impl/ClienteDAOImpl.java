package com.promerica.dao.impl;

import com.promerica.dao.IClienteDAO;
import com.promerica.modelo.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ClienteDAOImpl implements IClienteDAO, Serializable {

    @PersistenceContext(unitName = "tiendaPU")
    private EntityManager em;

    @Override
    public Integer registrar(Cliente t) throws Exception {
        try {
            t.setId(maxIdCliente());
            em.persist(t);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return t.getId();
    }

    @Override
    public Integer modificar(Cliente t) throws Exception {
        em.merge(t);
        return 1;
    }

    @Override
    public Integer eliminar(Cliente t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> listar() throws Exception {
        List<Cliente> lista = new ArrayList<>();

        try {
            Query query = em.createQuery("SELECT p FROM Cliente p ");
            lista = (List<Cliente>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Cliente listarPorId(Cliente t) throws Exception {
        return em.find(Cliente.class, t.getId());

    }

    public Integer maxIdCliente() {
        try {
            return (Integer) em.createNativeQuery("SELECT COALESCE(max(id),0)+1 from Cliente")
                    .getSingleResult();
        } catch (Exception e) {
            return 0;
        }

    }

    public Cliente listarId(Integer t) throws Exception {
        return em.find(Cliente.class, t);

    }

}
