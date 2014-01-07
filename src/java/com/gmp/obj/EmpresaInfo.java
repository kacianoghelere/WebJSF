/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gmp.obj;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "emp_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpresaInfo.findAll", query = "SELECT e FROM EmpresaInfo e"),
    @NamedQuery(name = "EmpresaInfo.findByAtivo", query = "SELECT e FROM EmpresaInfo e WHERE e.ativo = :ativo"),
    @NamedQuery(name = "EmpresaInfo.findByNome", query = "SELECT e FROM EmpresaInfo e WHERE e.nome = :nome"),
    @NamedQuery(name = "EmpresaInfo.findByFone", query = "SELECT e FROM EmpresaInfo e WHERE e.fone = :fone"),
    @NamedQuery(name = "EmpresaInfo.findByTpcic", query = "SELECT e FROM EmpresaInfo e WHERE e.tpcic = :tpcic"),
    @NamedQuery(name = "EmpresaInfo.findByCic", query = "SELECT e FROM EmpresaInfo e WHERE e.cic = :cic"),
    @NamedQuery(name = "EmpresaInfo.findByEmail", query = "SELECT e FROM EmpresaInfo e WHERE e.email = :email"),
    @NamedQuery(name = "EmpresaInfo.findByAvt", query = "SELECT e FROM EmpresaInfo e WHERE e.avt = :avt"),
    @NamedQuery(name = "EmpresaInfo.findByDtcad", query = "SELECT e FROM EmpresaInfo e WHERE e.dtcad = :dtcad"),
    @NamedQuery(name = "EmpresaInfo.findByDtmod", query = "SELECT e FROM EmpresaInfo e WHERE e.dtmod = :dtmod"),
    @NamedQuery(name = "EmpresaInfo.findByIdEmp", query = "SELECT e FROM EmpresaInfo e WHERE e.idEmp = :idEmp")})
public class EmpresaInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    private boolean ativo;
    private String nome;
    private String fone;
    private Character tpcic;
    private String cic;
    private String email;
    private String avt;
    @Temporal(TemporalType.DATE)
    private Date dtcad;
    @Temporal(TemporalType.DATE)
    private Date dtmod;
    @Id
    @Basic(optional = false)
    @Column(name = "id_emp")
    private Long idEmp;
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    @OneToOne
    private Endereco end;
    @JoinColumn(name = "id_emp_type", referencedColumnName = "id")
    @OneToOne
    private EmpresaTipo tipo;
    @JoinColumn(name = "id_emp", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Empresa empresa;

    public EmpresaInfo() {
    }

    public EmpresaInfo(Long idEmp) {
        this.idEmp = idEmp;
    }

    public EmpresaInfo(Long idEmp, boolean ativo) {
        this.idEmp = idEmp;
        this.ativo = ativo;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public Character getTpcic() {
        return tpcic;
    }

    public void setTpcic(Character tpcic) {
        this.tpcic = tpcic;
    }

    public String getCic() {
        return cic;
    }

    public void setCic(String cic) {
        this.cic = cic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public Date getDtcad() {
        return dtcad;
    }

    public void setDtcad(Date dtcad) {
        this.dtcad = dtcad;
    }

    public Date getDtmod() {
        return dtmod;
    }

    public void setDtmod(Date dtmod) {
        this.dtmod = dtmod;
    }

    public Long getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Long idEmp) {
        this.idEmp = idEmp;
    }

    public Endereco getIdEndereco() {
        return end;
    }

    public void setEndereco(Endereco idEndereco) {
        this.end = idEndereco;
    }

    public EmpresaTipo getIdEmpType() {
        return tipo;
    }

    public void setTipo(EmpresaTipo idEmpType) {
        this.tipo = idEmpType;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmp != null ? idEmp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaInfo)) {
            return false;
        }
        EmpresaInfo other = (EmpresaInfo) object;
        if ((this.idEmp == null && other.idEmp != null) || (this.idEmp != null && !this.idEmp.equals(other.idEmp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gmp.obj.EmpresaInfo[ idEmp=" + idEmp + " ]";
    }
    
}
