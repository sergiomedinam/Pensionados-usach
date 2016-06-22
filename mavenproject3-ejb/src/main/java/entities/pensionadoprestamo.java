/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author seerg
 */
@Entity
public class pensionadoprestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pensionado") 
    private pensionado pensionado;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_prestamo") 
    private prestamo prestamo;
    
    private String fecha_pedido;
    private String fecha_termino;
    private Integer cuotas;
    private Integer monto_total;
    private Integer valor_cuota;

    public Integer getValor_cuota() {
        return valor_cuota;
    }

    public void setValor_cuota(Integer valor_cuota) {
        this.valor_cuota = valor_cuota;
    }
    
    

    public pensionado getPensionado() {
        return pensionado;
    }

    public void setPensionado(pensionado pensionado) {
        this.pensionado = pensionado;
    }

    public prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public String getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(String fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public String getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(String fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public Integer getCuotas() {
        return cuotas;
    }

    public void setCuotas(Integer cuotas) {
        this.cuotas = cuotas;
    }

    public Integer getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(Integer monto_total) {
        this.monto_total = monto_total;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof pensionadoprestamo)) {
            return false;
        }
        pensionadoprestamo other = (pensionadoprestamo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.pensionadoprestamo[ id=" + id + " ]";
    }
    
}

