/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

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
    
    @NotNull(message = "Debe ser de un tipo de prestamo")
    @OneToOne
    private tipo_prestamo tipo_prestamo;

    public tipo_prestamo getTipo_prestamo() {
        return tipo_prestamo;
    }

    public void setTipo_prestamo(tipo_prestamo tipo_prestamo) {
        this.tipo_prestamo = tipo_prestamo;
    }
    
    
    
    @NotNull(message = "Debe tener un nombre")
    private String nombre_prestamo;
    
    @NotNull(message = "Debe tener un monto total")
    private String total_prestamo;
    
    @NotNull(message = "Debe tener cuotas a pagar")
    private String cuotas_prestamo;
    
    @NotNull(message = "Debe tener un interes porcentual")
    private String interes_prestamo;

    public String getNombre_prestamo() {
        return nombre_prestamo;
    }

    public void setNombre_prestamo(String nombre_prestamo) {
        this.nombre_prestamo = nombre_prestamo;
    }

    public String getTotal_prestamo() {
        return total_prestamo;
    }

    public void setTotal_prestamo(String total_prestamo) {
        this.total_prestamo = total_prestamo;
    }

    public String getCuotas_prestamo() {
        return cuotas_prestamo;
    }

    public void setCuotas_prestamo(String cuotas_prestamo) {
        this.cuotas_prestamo = cuotas_prestamo;
    }

    public String getInteres_prestamo() {
        return interes_prestamo;
    }

    public void setInteres_prestamo(String interes_prestamo) {
        this.interes_prestamo = interes_prestamo;
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
