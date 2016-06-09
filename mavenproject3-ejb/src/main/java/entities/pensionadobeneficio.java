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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author seerg
 */
@Entity
public class pensionadobeneficio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pensionado") 
    private pensionado pensionado;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_beneficio") 
    private beneficio beneficio;
    
    private  Integer monto;
    
    private String fecha_beneficio;

    public pensionado getPensionado() {
        return pensionado;
    }

    public void setPensionado(pensionado pensionado) {
        this.pensionado = pensionado;
    }

    public beneficio getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(beneficio beneficio) {
        this.beneficio = beneficio;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public String getFecha_beneficio() {
        return fecha_beneficio;
    }

    public void setFecha_beneficio(String fecha_beneficio) {
        this.fecha_beneficio = fecha_beneficio;
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
        if (!(object instanceof pensionadobeneficio)) {
            return false;
        }
        pensionadobeneficio other = (pensionadobeneficio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.pensionadobeneficio[ id=" + id + " ]";
    }
    
}
