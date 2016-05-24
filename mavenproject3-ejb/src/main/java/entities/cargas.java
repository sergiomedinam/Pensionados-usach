/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author seerg
 */
@Entity
public class cargas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_pensionado_carga")
    private Long id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pensionado") 
    private pensionado pensionado;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_seguro") 
    private seguro seguro;
    
    
    private Integer titular;
    private Integer conyuge;
    private Integer hijos;
    private Integer otros;

    public Integer getTitular() {
        return titular;
    }

    public void setTitular(Integer titular) {
        this.titular = titular;
    }

    public Integer getConyuge() {
        return conyuge;
    }

    public void setConyuge(Integer conyuge) {
        this.conyuge = conyuge;
    }

    public Integer getHijos() {
        return hijos;
    }

    public void setHijos(Integer hijos) {
        this.hijos = hijos;
    }

    public Integer getOtros() {
        return otros;
    }

    public void setOtros(Integer otros) {
        this.otros = otros;
    }

    
    
    public pensionado getPensionado() {
        return pensionado;
    }

    public void setPensionado(pensionado pensionado) {
        this.pensionado = pensionado;
    }

    public seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(seguro seguro) {
        this.seguro = seguro;
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
        if (!(object instanceof cargas)) {
            return false;
        }
        cargas other = (cargas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.cargas[ id=" + id + " ]";
    }
    
}
