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
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Sergio
 */
@Entity
public class patologia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    private String nombre_patologia;

    @OneToMany(mappedBy = "patologia")
    private Set<pensionadopatologia> pensionadopatologia = new HashSet<pensionadopatologia>();

    public Set<pensionadopatologia> getPensionadopatologia() {
        return pensionadopatologia;
    }

    public void setPensionadopatologia(Set<pensionadopatologia> pensionadopatologia) {
        this.pensionadopatologia = pensionadopatologia;
    }
        
    
    
    public String getNombre_patologia() {
        return nombre_patologia;
    }

    public void setNombre_patologia(String nombre_patologia) {
        this.nombre_patologia = nombre_patologia.toUpperCase();
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
        if (!(object instanceof patologia)) {
            return false;
        }
        patologia other = (patologia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.patologia[ id=" + id + " ]";
    }
    
}
