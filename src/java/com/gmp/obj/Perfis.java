package com.gmp.obj;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name="perfis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfis.findAll", query = "SELECT p FROM Perfis p"),
    @NamedQuery(name = "Perfis.findById", query = "SELECT p FROM Perfis p WHERE p.id = :id"),
    @NamedQuery(name = "Perfis.findByTitulo", query = "SELECT p FROM Perfis p WHERE p.titulo = :titulo")})
public class Perfis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long id;
    private String titulo;
    @OneToOne(mappedBy = "idPerfis")
    private UsuarioInfo usuarioInfo;    
    @OneToMany(mappedBy = "perfis")
    private List<PerfisAcesso> perfisAcesso;

    public Perfis() {
    }

    public Perfis(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public UsuarioInfo getUsuarioInfo() {
        return usuarioInfo;
    }

    public void setUsuarioInfo(UsuarioInfo usuarioInfo) {
        this.usuarioInfo = usuarioInfo;
    }

    public List<PerfisAcesso>  getPerfisAcesso() {
        return perfisAcesso;
    }

    public void setPerfisAcesso(List<PerfisAcesso>  perfisAcesso) {
        this.perfisAcesso = perfisAcesso;
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
        if (!(object instanceof Perfis)) {
            return false;
        }
        Perfis other = (Perfis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gmp.obj.Perfis[ id=" + id + " ]";
    }
    
}
