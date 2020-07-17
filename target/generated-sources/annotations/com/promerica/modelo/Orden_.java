package com.promerica.modelo;

import com.promerica.modelo.Cliente;
import com.promerica.modelo.DetalleOrden;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-17T16:01:13")
@StaticMetamodel(Orden.class)
public class Orden_ { 

    public static volatile SingularAttribute<Orden, Cliente> cliente;
    public static volatile SingularAttribute<Orden, Date> fecha;
    public static volatile SingularAttribute<Orden, Double> total;
    public static volatile SingularAttribute<Orden, Integer> cantidad;
    public static volatile ListAttribute<Orden, DetalleOrden> listadoOrdenDetalle;
    public static volatile SingularAttribute<Orden, Double> subTotal;
    public static volatile SingularAttribute<Orden, Integer> idOrden;

}