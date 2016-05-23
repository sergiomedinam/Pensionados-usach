/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import javax.validation.constraints.NotNull;

/**
 *
 * @author seerg
 */
@Entity
public class pensionado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    private String email_pensionado;
    private String email_alternativo;
   
    
    @NotNull
    private String rut_pensionado;
    
    @NotNull
    private String nombre_pensionado;
    
    @NotNull
    private String apellido_p_pensionado;
    private String apellido_m_pensionado;
    
    @NotNull
    private String fecha_nacimiento;
    
    @NotNull
    @Temporal(DATE)
    private Date fnacimiento;
    
    @NotNull
    private String estado_civil;
    
    @NotNull
    private String direccion;
    
    @NotNull
    private String comuna;
    private String region;
    private Long telefono_fijo;
    private Long celular;

    @ManyToOne
    private patologia patologias;
   
    @ManyToOne
    private seguro seguros;
    
    @ManyToOne
    private contacto contactos;
    
    @ManyToOne
    private medicamento medicamentos;
    
    @ManyToOne
    private prestamo prestamos;
    
    @ManyToOne
    private beneficio beneficios;

    public Date getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }
    
    
    
    @OneToOne
    private otros_datos otros_datos;

    public String getEmail_alternativo() {
        return email_alternativo;
    }

    public void setEmail_alternativo(String email_alternativo) {
        this.email_alternativo = email_alternativo.toUpperCase();
    }
    
    
    
     public String getEmail_pensionado() {
        return email_pensionado;
    }

    public void setEmail_pensionado(String email_pensionado) {
        this.email_pensionado = email_pensionado.toUpperCase();
    }

    public medicamento getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(medicamento medicamentos) {
        this.medicamentos = medicamentos;
    }

    public prestamo getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(prestamo prestamos) {
        this.prestamos = prestamos;
    }

    public beneficio getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(beneficio beneficios) {
        this.beneficios = beneficios;
    }
    
    

    public seguro getSeguros() {
        return seguros;
    }

    public void setSeguros(seguro seguros) {
        this.seguros = seguros;
    }

    public contacto getContactos() {
        return contactos;
    }

    public void setContactos(contacto contactos) {
        this.contactos = contactos;
    }

    public otros_datos getOtros_datos() {
        return otros_datos;
    }

    public void setOtros_datos(otros_datos otros_datos) {
        this.otros_datos = otros_datos;
    }

    
    
    public patologia getPatologias() {
        return patologias;
    }

    public void setPatologias(patologia patologias) {
        this.patologias = patologias;
    }

    public String getRut_pensionado() {
        return rut_pensionado;
    }

    public void setRut_pensionado(String rut_pensionado) {
        this.rut_pensionado = rut_pensionado;
    }
    
    
   
    public String getNombre_pensionado() {
        return nombre_pensionado;
    }

    public void setNombre_pensionado(String nombre_pensionado) {
        this.nombre_pensionado = nombre_pensionado.toUpperCase();
    }

    public String getApellido_p_pensionado() {
        return apellido_p_pensionado;
    }

    public void setApellido_p_pensionado(String apellido_p_pensionado) {
        this.apellido_p_pensionado = apellido_p_pensionado.toUpperCase();
    }

    public String getApellido_m_pensionado() {
        return apellido_m_pensionado;
    }

    public void setApellido_m_pensionado(String apellido_m_pensionado) {
        this.apellido_m_pensionado = apellido_m_pensionado.toUpperCase();
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

   

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil.toUpperCase();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion.toUpperCase();
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna.toUpperCase();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region.toUpperCase();
    }

    public Long getTelefono_fijo() {
        return telefono_fijo;
    }

    public void setTelefono_fijo(Long telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
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
        if (!(object instanceof pensionado)) {
            return false;
        }
        pensionado other = (pensionado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.pensionado[ id=" + id + " ]";
    }
    
}
