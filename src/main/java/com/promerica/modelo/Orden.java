package com.promerica.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

@Entity
@Table(name = "orden")
public class Orden implements Serializable {


    @Id
    @Column(name = "id_orden")
    private Integer idOrden;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private Integer cantidad;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orden")
    
    private List<DetalleOrden> listadoOrdenDetalle;
    
    private Double total;
    private Double subTotal;
    
    
    

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
@XmlTransient
    public List<DetalleOrden> getListadoOrdenDetalle() {
        return listadoOrdenDetalle;
    }

    public void setListadoOrdenDetalle(List<DetalleOrden> listadoOrdenDetalle) {
        this.listadoOrdenDetalle = listadoOrdenDetalle;
    }

    
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
    
    
    
}
