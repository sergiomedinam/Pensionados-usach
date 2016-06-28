/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
    private Integer aporte;
    private Integer saldo = 0;
    private Integer monto_pension;
    private String rut_pensionado;
    private String nombre_pensionado;
    private String apellido_p_pensionado;
    private String apellido_m_pensionado;
    private String fecha_nacimiento;
    private String estado_civil;
    private String direccion;
    private String comuna;
    private String region;
    private Long telefono_fijo;
    private Long celular;
    private String estado;
    private String causal;
    
    @Lob()
    private byte[] content;
    
    @ManyToOne
    private patologia patologias;
   
    @OneToMany(mappedBy = "pensionado")
    private Set<cargas> cargas = new HashSet<cargas>();
    
    @ManyToOne
    private contacto contactos;
    
    @ManyToOne
    private medicamento medicamentos;
    
    @ManyToOne
    private prestamo prestamos;
    
    @ManyToOne
    private beneficio beneficios;
    
    @OneToMany
    private List<cuotaspagadas> cuotaspagadas;
    
    @OneToMany(mappedBy = "pensionado")
    private Set<pensionadoprestamo> pensionadoprestamo = new HashSet<pensionadoprestamo>();
    
    @OneToMany(mappedBy = "pensionado")
    private Set<pensionadobeneficio> pensionadobeneficio = new HashSet<pensionadobeneficio>();
    
    @OneToMany(mappedBy = "pensionado")
    private Set<pensionadopatologia> pensionadopatologia = new HashSet<pensionadopatologia>();
    
    @OneToMany
    private List<pago> pagos;

    public Set<pensionadopatologia> getPensionadopatologia() {
        return pensionadopatologia;
    }

    public void setPensionadopatologia(Set<pensionadopatologia> pensionadopatologia) {
        this.pensionadopatologia = pensionadopatologia;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }   

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCausal() {
        return causal;
    }

    public void setCausal(String causal) {
        this.causal = causal;
    }
    
    

    public Integer getAporte() {
        return aporte;
    }

    public void setAporte(Integer aporte) {
        this.aporte = aporte;
    }
    
    

    public Integer getSaldo() {
        return saldo;
    }
    
    

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Integer getMonto_pension() {
        return monto_pension;
    }

    public void setMonto_pension(Integer monto_pension) {
        this.monto_pension = monto_pension;
    }

    public Set<pensionadobeneficio> getPensionadobeneficio() {
        return pensionadobeneficio;
    }

    public void setPensionadobeneficio(Set<pensionadobeneficio> pensionadobeneficio) {
        this.pensionadobeneficio = pensionadobeneficio;
    }
    
    

    public Set<pensionadoprestamo> getPensionadoprestamo() {
        return pensionadoprestamo;
    }

    public void setPensionadoprestamo(Set<pensionadoprestamo> pensionadoprestamo) {
        this.pensionadoprestamo = pensionadoprestamo;
    }

    public List<pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<pago> pagos) {
        this.pagos = pagos;
    }
    
    

    public List<cuotaspagadas> getCuotaspagadas() {
        return cuotaspagadas;
    }

    public void setCuotaspagadas(List<cuotaspagadas> cuotaspagadas) {
        this.cuotaspagadas = cuotaspagadas;
    }
    
     public void addCuotaspagadas(cuotaspagadas cuotaspagadas) {
        this.cuotaspagadas.add(cuotaspagadas);
    }

    public Set<cargas> getCargas() {
        return cargas;
    }

    public void setCargas(Set<cargas> cargas) {
        this.cargas = cargas;
    }

    public void addCarga(cargas carga) {
        this.cargas.add(carga);
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

    public String getNombreCompleto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
