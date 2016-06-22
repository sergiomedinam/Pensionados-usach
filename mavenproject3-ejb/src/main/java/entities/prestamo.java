/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Sergio
 */
@Entity
public class prestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Integer monto_max_prestamo;
    private String nombre_prestamo;
    private Integer cuotas_prestamo;
    
    @OneToMany(mappedBy = "prestamo")
    private Set<pensionadoprestamo> pensionadoprestamo = new HashSet<pensionadoprestamo>();
    
    public Integer getMonto_max_prestamo() {
        return monto_max_prestamo;
    }

    public void setMonto_max_prestamo(Integer monto_max_prestamo) {
        this.monto_max_prestamo = monto_max_prestamo;
    }

    public Set<pensionadoprestamo> getPensionadoprestamo() {
        return pensionadoprestamo;
    }

    public void setPensionadoprestamo(Set<pensionadoprestamo> pensionadoprestamo) {
        this.pensionadoprestamo = pensionadoprestamo;
    }

    public void addPensionadoprestamo(pensionadoprestamo pensionadoprestamo) {
        this.pensionadoprestamo.add(pensionadoprestamo);
    }
    
    public String getNombre_prestamo() {
        return nombre_prestamo;
    }

    public void setNombre_prestamo(String nombre_prestamo) {
        this.nombre_prestamo = nombre_prestamo;
    }

    public Integer getCuotas_prestamo() {
        return cuotas_prestamo;
    }

    public void setCuotas_prestamo(Integer cuotas_prestamo) {
        this.cuotas_prestamo = cuotas_prestamo;
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
        if (!(object instanceof prestamo)) {
            return false;
        }
        prestamo other = (prestamo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.prestamo[ id=" + id + " ]";
    }
    
}
