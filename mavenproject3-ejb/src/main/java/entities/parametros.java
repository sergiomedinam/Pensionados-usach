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
    private Integer prima_catastrofico_titular;
    @NotNull
    private Integer prima_catastrofico_conyuge;
    @NotNull
    private Integer prima_catastrofico_hijos;
    @NotNull
    private Integer prima_hospitalario_titular;
    @NotNull
    private Integer prima_hospitalario_titularmas1;
    @NotNull
    private Integer prima_hospitalario_titular2omas;

    public Integer getPrima_catastrofico_titular() {
        return prima_catastrofico_titular;
    }

    public void setPrima_catastrofico_titular(Integer prima_catastrofico_titular) {
        this.prima_catastrofico_titular = prima_catastrofico_titular;
    }

    public Integer getPrima_catastrofico_conyuge() {
        return prima_catastrofico_conyuge;
    }

    public void setPrima_catastrofico_conyuge(Integer prima_catastrofico_conyuge) {
        this.prima_catastrofico_conyuge = prima_catastrofico_conyuge;
    }

    public Integer getPrima_catastrofico_hijos() {
        return prima_catastrofico_hijos;
    }

    public void setPrima_catastrofico_hijos(Integer prima_catastrofico_hijos) {
        this.prima_catastrofico_hijos = prima_catastrofico_hijos;
    }

    public Integer getPrima_hospitalario_titular() {
        return prima_hospitalario_titular;
    }

    public void setPrima_hospitalario_titular(Integer prima_hospitalario_titular) {
        this.prima_hospitalario_titular = prima_hospitalario_titular;
    }

    public Integer getPrima_hospitalario_titularmas1() {
        return prima_hospitalario_titularmas1;
    }

    public void setPrima_hospitalario_titularmas1(Integer prima_hospitalario_titularmas1) {
        this.prima_hospitalario_titularmas1 = prima_hospitalario_titularmas1;
    }

    public Integer getPrima_hospitalario_titular2omas() {
        return prima_hospitalario_titular2omas;
    }

    public void setPrima_hospitalario_titular2omas(Integer prima_hospitalario_titular2omas) {
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
