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

/**
 *
 * @author Sergio
 */
@Entity
public class pagodetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    private Boolean seguro_catastrofico;
    private Boolean seguro_vida;
    private Boolean seguro_hospitalario;
    private Boolean seguro_ucm;
    private Boolean seguro_paux;
    private Boolean seguro_pmed;
    private Boolean seguro_jardin;
    private Boolean aportes;
    private Boolean prestamos;
    private Boolean otros;

    public Boolean getSeguro_catastrofico() {
        return seguro_catastrofico;
    }

    public void setSeguro_catastrofico(Boolean seguro_catastrofico) {
        this.seguro_catastrofico = seguro_catastrofico;
    }

    public Boolean getSeguro_vida() {
        return seguro_vida;
    }

    public void setSeguro_vida(Boolean seguro_vida) {
        this.seguro_vida = seguro_vida;
    }

    public Boolean getSeguro_hospitalario() {
        return seguro_hospitalario;
    }

    public void setSeguro_hospitalario(Boolean seguro_hospitalario) {
        this.seguro_hospitalario = seguro_hospitalario;
    }

    public Boolean getSeguro_ucm() {
        return seguro_ucm;
    }

    public void setSeguro_ucm(Boolean seguro_ucm) {
        this.seguro_ucm = seguro_ucm;
    }

    public Boolean getSeguro_paux() {
        return seguro_paux;
    }

    public void setSeguro_paux(Boolean seguro_paux) {
        this.seguro_paux = seguro_paux;
    }

    public Boolean getSeguro_pmed() {
        return seguro_pmed;
    }

    public void setSeguro_pmed(Boolean seguro_pmed) {
        this.seguro_pmed = seguro_pmed;
    }

    public Boolean getSeguro_jardin() {
        return seguro_jardin;
    }

    public void setSeguro_jardin(Boolean seguro_jardin) {
        this.seguro_jardin = seguro_jardin;
    }

    public Boolean getAportes() {
        return aportes;
    }

    public void setAportes(Boolean aportes) {
        this.aportes = aportes;
    }

    public Boolean getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Boolean prestamos) {
        this.prestamos = prestamos;
    }

    public Boolean getOtros() {
        return otros;
    }

    public void setOtros(Boolean otros) {
        this.otros = otros;
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
        if (!(object instanceof pagodetalle)) {
            return false;
        }
        pagodetalle other = (pagodetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.pagodetalle[ id=" + id + " ]";
    }
    
}
