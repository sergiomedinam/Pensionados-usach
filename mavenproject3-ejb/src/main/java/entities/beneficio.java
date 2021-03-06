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
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sergio
 */
@Entity
public class beneficio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

        
    @NotNull(message = "Debe tener un nombre")
    private String nombre_beneficio;

    public tipo_beneficio getTipo_beneficio() {
        return tipo_beneficio;
    }

    public void setTipo_beneficio(tipo_beneficio tipo_beneficio) {
        this.tipo_beneficio = tipo_beneficio;
    }

    @NotNull(message = "Debe tener un tipo")
    @OneToOne
    private tipo_beneficio tipo_beneficio;
    
    public String getNombre_beneficio() {
        return nombre_beneficio;
    }

    public void setNombre_beneficio(String nombre_beneficio) {
        this.nombre_beneficio = nombre_beneficio;
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
        if (!(object instanceof beneficio)) {
            return false;
        }
        beneficio other = (beneficio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.beneficio[ id=" + id + " ]";
    }
    
}
