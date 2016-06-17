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
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author seerg
 */
@Entity
public class pensionadopatologia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pensionado") 
    private pensionado pensionado;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_patologia") 
    private patologia patologia;

    public pensionado getPensionado() {
        return pensionado;
    }

    public void setPensionado(pensionado pensionado) {
        this.pensionado = pensionado;
    }

    public patologia getPatologia() {
        return patologia;
    }

    public void setPatologia(patologia patologia) {
        this.patologia = patologia;
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
        if (!(object instanceof pensionadopatologia)) {
            return false;
        }
        pensionadopatologia other = (pensionadopatologia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.pensionadopatologia[ id=" + id + " ]";
    }
    
}
