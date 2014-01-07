package com.gmp.obj;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "usu_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioTipo.findAll", query = "SELECT u FROM UsuarioTipo u"),
    @NamedQuery(name = "UsuarioTipo.findById", query = "SELECT u FROM UsuarioTipo u WHERE u.id = :id"),
    @NamedQuery(name = "UsuarioTipo.findByDescrip", query = "SELECT u FROM UsuarioTipo u WHERE u.descrip = :descrip")})
public class UsuarioTipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    private String descrip;
    @OneToOne(mappedBy = "idUsuType")
    private UsuarioInfo usuarioInfo;

    public UsuarioTipo() {
    }

    public UsuarioTipo(Long id) {
        this.id = id;
    }

    public UsuarioTipo(Long id, String descrip) {
        this.id = id;
        this.descrip = descrip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public UsuarioInfo getUsuarioInfo() {
        return usuarioInfo;
    }

    public void setUsuarioInfo(UsuarioInfo usuarioInfo) {
        this.usuarioInfo = usuarioInfo;
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
        if (!(object instanceof UsuarioTipo)) {
            return false;
        }
        UsuarioTipo other = (UsuarioTipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gmp.obj.UsuarioTipo[ id=" + id + " ]";
    }
    
}
