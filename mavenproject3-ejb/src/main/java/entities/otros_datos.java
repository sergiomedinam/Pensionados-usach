
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

@Entity
public class otros_datos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String sistema_salud;
    private String tipo_pension;
    private String sistema_pension;
    private String nombre_banco;
    private String cuenta_banco;
    private String estamento;
    private Integer monto_pension;
    private Integer valor_cuota;
    private String ultimo_aporte;
    private String caja_compensacion;

    public String getSistema_salud() {
        return sistema_salud;
    }

    public void setSistema_salud(String sistema_salud) {
        this.sistema_salud = sistema_salud;
    }

    public String getTipo_pension() {
        return tipo_pension;
    }

    public void setTipo_pension(String tipo_pension) {
        this.tipo_pension = tipo_pension;
    }

    public String getSistema_pension() {
        return sistema_pension;
    }

    public void setSistema_pension(String sistema_pension) {
        this.sistema_pension = sistema_pension;
    }

    public String getNombre_banco() {
        return nombre_banco;
    }

    public void setNombre_banco(String nombre_banco) {
        this.nombre_banco = nombre_banco;
    }

    public String getCuenta_banco() {
        return cuenta_banco;
    }

    public void setCuenta_banco(String cuenta_banco) {
        this.cuenta_banco = cuenta_banco;
    }

    public String getEstamento() {
        return estamento;
    }

    public void setEstamento(String estamento) {
        this.estamento = estamento;
    }

    public Integer getMonto_pension() {
        return monto_pension;
    }

    public void setMonto_pension(Integer monto_pension) {
        this.monto_pension = monto_pension;
    }

    public Integer getValor_cuota() {
        return valor_cuota;
    }

    public void setValor_cuota(Integer valor_cuota) {
        this.valor_cuota = valor_cuota;
    }

    public String getUltimo_aporte() {
        return ultimo_aporte;
    }

    public void setUltimo_aporte(String ultimo_aporte) {
        this.ultimo_aporte = ultimo_aporte;
    }

    public String getCaja_compensacion() {
        return caja_compensacion;
    }

    public void setCaja_compensacion(String caja_compensacion) {
        this.caja_compensacion = caja_compensacion;
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
        if (!(object instanceof otros_datos)) {
            return false;
        }
        otros_datos other = (otros_datos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.otros_datos[ id=" + id + " ]";
    }
    
}
