/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gmp.obj;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "perfis_acesso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfisAcesso.findAll", query = "SELECT p FROM PerfisAcesso p"),
    @NamedQuery(name = "PerfisAcesso.findByTela", query = "SELECT p FROM PerfisAcesso p WHERE p.tela = :tela"),
    @NamedQuery(name = "PerfisAcesso.findByIdPerfis", query = "SELECT p FROM PerfisAcesso p WHERE p.idPerfis = :idPerfis")})
public class PerfisAcesso implements Serializable {
    private static final long serialVersionUID = 1L;
    private String tela;
    @Id
    @Basic(optional = false)
    @Column(name = "id_perfis")
    private Long idPerfis;
    @JoinColumn(name = "id_perfis", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfis perfis;

    public PerfisAcesso() {
    }

    public PerfisAcesso(Long idPerfis) {
        this.idPerfis = idPerfis;
    }

    public String getTela() {
        return tela;
    }

    public void setTela(String tela) {
        this.tela = tela;
    }

    public Long getIdPerfis() {
        return idPerfis;
    }

    public void setIdPerfis(Long idPerfis) {
        this.idPerfis = idPerfis;
    }

    public Perfis getPerfis() {
        return perfis;
    }

    public void setPerfis(Perfis perfis) {
        this.perfis = perfis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfis != null ? idPerfis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfisAcesso)) {
            return false;
        }
        PerfisAcesso other = (PerfisAcesso) object;
        if ((this.idPerfis == null && other.idPerfis != null) || (this.idPerfis != null && !this.idPerfis.equals(other.idPerfis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gmp.obj.PerfisAcesso[ idPerfis=" + idPerfis + " ]";
    }
    
}
