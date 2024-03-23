package dominio;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Persona")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "RFC", length = 15)
    private String RFC;
    
    @Column(name = "NombreCompleto", length = 100, nullable = false)
    private String nombreCompleto;
    
    @Column(name = "FechaNacimiento", nullable = false)
    private Date fechaNacimiento;
    
    @Column(name = "Telefono", length = 20)
    private String telefono;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Licencia> licencias;
    
    public Persona() {
        // Constructor vacío requerido por JPA
    }

    public Persona(String RFC, String nombreCompleto, Date fechaNacimiento, String telefono) {
        this.RFC = RFC;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Licencia> getLicencias() {
        return licencias;
    }

    public void setLicencias(List<Licencia> licencias) {
        this.licencias = licencias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (RFC != null ? RFC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.RFC == null && other.RFC != null) || (this.RFC != null && !this.RFC.equals(other.RFC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Persona[ RFC=" + RFC + " ]";
    }
}
