package dominio;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="Licencia")
public class Licencia implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NumeroLicencia")
    private Integer numeroLicencia;
    
    @Column(name = "FechaExpedicion")
    public Date fechaExpedicion;
    
    @Column(name = "Vigencia")
    public Integer vigencia;
    
    @Column(name = "Monto", precision = 8, scale = 2)
    public BigDecimal monto;
    
    @Column(name = "Tipo", length = 20)
    public String tipo;
    
    @ManyToOne
    @JoinColumn(name = "RFC")
    public Persona persona;
    
    public Licencia() {
        // Constructor vacío requerido por JPA
    }

    public Licencia(Date fechaExpedicion, Integer vigencia, BigDecimal monto, String tipo, Persona persona) {
        this.fechaExpedicion = fechaExpedicion;
        this.vigencia = vigencia;
        this.monto = monto;
        this.tipo = tipo;
        this.persona = persona;
    }

    public Integer getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(Integer numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroLicencia != null ? numeroLicencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.numeroLicencia == null && other.numeroLicencia != null) || (this.numeroLicencia != null && !this.numeroLicencia.equals(other.numeroLicencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Licencia[ numeroLicencia=" + numeroLicencia + " ]";
    }
}
