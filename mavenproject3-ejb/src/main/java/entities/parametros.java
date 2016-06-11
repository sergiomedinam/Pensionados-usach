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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sergio
 */
@Entity
public class parametros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    @NotNull
    private Integer valor_uf;    
    @NotNull
    private Float prima_catastrofico_titular;
    @NotNull
    private Float prima_catastrofico_conyuge;
    @NotNull
    private Float prima_catastrofico_hijos;
    @NotNull
    private Float prima_hospitalario_titular;
    @NotNull
    private Float prima_hospitalario_titularmas1;
    @NotNull
    private Float prima_hospitalario_titular2omas;
    @NotNull
    private String correo_s_admin;
    @NotNull
    private String correo_aplicacion;
    @NotNull
    private String contrasena_correo_aplicacion;
    @NotNull
    private Integer aporte_institucional;

    public Integer getAporte_institucional() {
        return aporte_institucional;
    }

    public void setAporte_institucional(Integer aporte_institucional) {
        this.aporte_institucional = aporte_institucional;
    }

    public String getCorreo_s_admin() {
        return correo_s_admin;
    }

    public void setCorreo_s_admin(String correo_s_admin) {
        this.correo_s_admin = correo_s_admin;
    }

    public String getCorreo_aplicacion() {
        return correo_aplicacion;
    }

    public void setCorreo_aplicacion(String correo_aplicacion) {
        this.correo_aplicacion = correo_aplicacion;
    }

    public String getContrasena_correo_aplicacion() {
        return contrasena_correo_aplicacion;
    }

    public void setContrasena_correo_aplicacion(String contrasena_correo_aplicacion) {
        this.contrasena_correo_aplicacion = contrasena_correo_aplicacion;
    }

    public Float getPrima_catastrofico_titular() {
        return prima_catastrofico_titular;
    }

    public void setPrima_catastrofico_titular(Float prima_catastrofico_titular) {
        this.prima_catastrofico_titular = prima_catastrofico_titular;
    }

    public Float getPrima_catastrofico_conyuge() {
        return prima_catastrofico_conyuge;
    }

    public void setPrima_catastrofico_conyuge(Float prima_catastrofico_conyuge) {
        this.prima_catastrofico_conyuge = prima_catastrofico_conyuge;
    }

    public Float getPrima_catastrofico_hijos() {
        return prima_catastrofico_hijos;
    }

    public void setPrima_catastrofico_hijos(Float prima_catastrofico_hijos) {
        this.prima_catastrofico_hijos = prima_catastrofico_hijos;
    }

    public Float getPrima_hospitalario_titular() {
        return prima_hospitalario_titular;
    }

    public void setPrima_hospitalario_titular(Float prima_hospitalario_titular) {
        this.prima_hospitalario_titular = prima_hospitalario_titular;
    }

    public Float getPrima_hospitalario_titularmas1() {
        return prima_hospitalario_titularmas1;
    }

    public void setPrima_hospitalario_titularmas1(Float prima_hospitalario_titularmas1) {
        this.prima_hospitalario_titularmas1 = prima_hospitalario_titularmas1;
    }

    public Float getPrima_hospitalario_titular2omas() {
        return prima_hospitalario_titular2omas;
    }

    public void setPrima_hospitalario_titular2omas(Float prima_hospitalario_titular2omas) {
        this.prima_hospitalario_titular2omas = prima_hospitalario_titular2omas;
    }

    public Integer getValor_uf() {
        return valor_uf;
    }

    public void setValor_uf(Integer valor_uf) {
        this.valor_uf = valor_uf;
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
        if (!(object instanceof parametros)) {
            return false;
        }
        parametros other = (parametros) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.parametros[ id=" + id + " ]";
    }
    
}
