/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Nelson
 */
@Entity
public class rol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ROL_ID")
    private Long rol_id;

    @NotNull(message ="Debe tener un nombre")
    private String rol_nombre;
    
    @ManyToMany
    @JoinTable(name = "USERS_GROUPS_MAP",
        joinColumns = {@JoinColumn(name = "ROL_ID", referencedColumnName = "ROL_ID")},
        inverseJoinColumns = {@JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID")})
    private Set<usuario> usersThatBelongsToThisGroup;
    /** Alternatively, you have the mappedBy attribute in @ManyToMany **/
    //@ManyToMany(mappedBy = "groupsThatBelongTo")
    
    public rol() {
    }
 
    public rol(Long appGroupsPk) {
        this.rol_id = appGroupsPk;
    }
 
    public rol(Long appGroupsPk, String groupName) {
        this.rol_id = appGroupsPk;
        this.rol_nombre = groupName;
    }
    
    public Set<usuario> getUsersThatBelongsToThisGroup() {
        return usersThatBelongsToThisGroup;
    }
 
    public void setUsersThatBelongsToThisGroup(Set<usuario> usersThatBelongsToThisGroup) {
        this.usersThatBelongsToThisGroup = usersThatBelongsToThisGroup;
    }
    
    public Long getRol_id() {
        return rol_id;
    }

    public void setRol_id(Long rol_id) {
        this.rol_id = rol_id;
    }

    public String getRol_nombre() {
        return rol_nombre;
    }

    public void setRol_nombre(String rol_nombre) {
        this.rol_nombre = rol_nombre;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rol_id != null ? rol_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the rol_id fields are not set
        if (!(object instanceof rol)) {
            return false;
        }
        rol other = (rol) object;
        if ((this.rol_id == null && other.rol_id != null) || (this.rol_id != null && !this.rol_id.equals(other.rol_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.rol[ id=" + rol_id + " ]";
    }
    
}
