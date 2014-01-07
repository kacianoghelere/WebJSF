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
@Table(name = "emp_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpresaTipo.findAll", query = "SELECT e FROM EmpresaTipo e"),
    @NamedQuery(name = "EmpresaTipo.findById", query = "SELECT e FROM EmpresaTipo e WHERE e.id = :id"),
    @NamedQuery(name = "EmpresaTipo.findByDescrip", query = "SELECT e FROM EmpresaTipo e WHERE e.descrip = :descrip")})
public class EmpresaTipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long id;
    private String descrip;
    @OneToOne
    private EmpresaInfo empresaInfo;

    public EmpresaTipo() {
    }

    public EmpresaTipo(Long id) {
        this.id = id;
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

    public EmpresaInfo getEmpresaInfo() {
        return empresaInfo;
    }

    public void setEmpresaInfo(EmpresaInfo empresaInfo) {
        this.empresaInfo = empresaInfo;
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
        if (!(object instanceof EmpresaTipo)) {
            return false;
        }
        EmpresaTipo other = (EmpresaTipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gmp.obj.EmpresaTipo[ id=" + id + " ]";
    }
    
}
