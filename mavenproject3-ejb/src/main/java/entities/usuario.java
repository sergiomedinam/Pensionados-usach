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
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author seerg
 */
@Entity
public class usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
       
    private String email_usuario;
    
    private String estado;
    private String causal;
    
    
    @NotNull(message = "debe ingresar nombre")
    private String nombre;
    
    @NotNull(message = "debe ingresar apellido")
    private String apellido;
    
    @NotNull(message = "debe ingresar rut")
    private String rut;
    
    @NotNull(message = "debe ingresar contraseña")
    private String contrasena;
    @NotNull(message = "debe tener un rol")
    @OneToOne
    private rol tipo_usuario;

    public String getEmail_usuario() {
        return email_usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario.toUpperCase();
    }

    
    public rol getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(rol tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }
    
    

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido.toUpperCase();
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

    public String getCausal() {
        return causal;
    }

    public void setCausal(String causal) {
        this.causal = causal;
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
        if (!(object instanceof usuario)) {
            return false;
        }
        usuario other = (usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.usuario[ " + "id=" + id + " ]";
    }

    
    
}
