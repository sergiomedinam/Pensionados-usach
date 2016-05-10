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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sergio
 */
@Entity
public class designado_fallecimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    
    @NotNull(message ="Debe tener un nombre")
    private String nombre_designado;
    
    @NotNull(message ="Debe tener un apellido")
    private String apellido_designado;
    
    @NotNull(message ="Debe tener un rut")
    private Long rut_designado;
    
    @NotNull(message ="Debe tener un parentesco")
    private String parentesco;
    
    @NotNull(message ="Debe tener un telefono")
    private Long telefono;
    
    @ManyToOne
    private pensionado pensionados;

    public pensionado getPensionados() {
        return pensionados;
    }

    public void setPensionados(pensionado pensionados) {
        this.pensionados = pensionados;
    }
    
    

    public String getNombre_designado() {
        return nombre_designado;
    }

    public void setNombre_designado(String nombre_designado) {
        this.nombre_designado = nombre_designado;
    }

    public String getApellido_designado() {
        return apellido_designado;
    }

    public void setApellido_designado(String apellido_designado) {
        this.apellido_designado = apellido_designado;
    }

    public Long getRut_designado() {
        return rut_designado;
    }

    public void setRut_designado(Long rut_designado) {
        this.rut_designado = rut_designado;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
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
        if (!(object instanceof designado_fallecimiento)) {
            return false;
        }
        designado_fallecimiento other = (designado_fallecimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.designado_fallecimiento[ id=" + id + " ]";
    }
    
}
