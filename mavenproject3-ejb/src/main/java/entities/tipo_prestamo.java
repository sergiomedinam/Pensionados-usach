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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sergio
 */
@Entity
public class tipo_prestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    @NotNull(message = "Debe tener un nombre")
    private String nombre_t_prestamo;

    public Long getId() {
        return id;
    }

    public String getNombre_t_prestamo() {
        return nombre_t_prestamo;
    }

    public void setNombre_t_prestamo(String nombre_t_prestamo) {
        this.nombre_t_prestamo = nombre_t_prestamo;
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
        if (!(object instanceof tipo_prestamo)) {
            return false;
        }
        tipo_prestamo other = (tipo_prestamo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.tipo_prestamo[ id=" + id + " ]";
    }
    
}
