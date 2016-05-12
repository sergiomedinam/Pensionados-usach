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
public class usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "USUARIO_ID")
    private Long usuarioId;
    
    @NotNull(message = "debe ingresar nombre")
    private String nombre;
    
    @NotNull(message = "debe ingresar apellido")
    private String apellido;
    
    @NotNull(message = "debe ingresar rut")
    private String rut;
    
    @NotNull(message = "debe ingresar contraseña")
    private String contrasena;
    
    @ManyToMany
    @JoinTable(name = "USERS_GROUPS_MAP",
        joinColumns = {@JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID")},
        inverseJoinColumns = {@JoinColumn(name = "ROL_ID", referencedColumnName = "ROL_ID")})
    private Set<rol> groupsThatBelongTo;
 
    public usuario() {
    }
 
    public usuario(Long appUsersPk) {
        this.usuarioId = appUsersPk;
    }
 
    public usuario(Long appUsersPk, String username, String password) {
        this.usuarioId = appUsersPk;
        this.rut = username;
        this.contrasena = password;
    }
    
    public Set<rol> getGroupsThatBelongTo() {
        return groupsThatBelongTo;
    }
 
    public void setGroupsThatBelongTo(Set<rol> groupsThatBelongTo) {
        this.groupsThatBelongTo = groupsThatBelongTo;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the usuarioId fields are not set
        if (!(object instanceof usuario)) {
            return false;
        }
        usuario other = (usuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.usuario[ id=" + usuarioId + " ]";
    }
    
}
