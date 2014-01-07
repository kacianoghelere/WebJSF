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
import javax.persistence.ManyToOne;
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
@Table(name = "usu_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioInfo.findAll", query = "SELECT u FROM UsuarioInfo u"),
    @NamedQuery(name = "UsuarioInfo.findByAtivo", query = "SELECT u FROM UsuarioInfo u WHERE u.ativo = :ativo"),
    @NamedQuery(name = "UsuarioInfo.findByNome", query = "SELECT u FROM UsuarioInfo u WHERE u.nome = :nome"),
    @NamedQuery(name = "UsuarioInfo.findByFone", query = "SELECT u FROM UsuarioInfo u WHERE u.fone = :fone"),
    @NamedQuery(name = "UsuarioInfo.findByEmail", query = "SELECT u FROM UsuarioInfo u WHERE u.email = :email"),
    @NamedQuery(name = "UsuarioInfo.findByAvt", query = "SELECT u FROM UsuarioInfo u WHERE u.avt = :avt"),
    @NamedQuery(name = "UsuarioInfo.findByDtcad", query = "SELECT u FROM UsuarioInfo u WHERE u.dtcad = :dtcad"),
    @NamedQuery(name = "UsuarioInfo.findByDtmod", query = "SELECT u FROM UsuarioInfo u WHERE u.dtmod = :dtmod"),
    @NamedQuery(name = "UsuarioInfo.findByIdUsuario", query = "SELECT u FROM UsuarioInfo u WHERE u.idUsuario = :idUsuario")})
public class UsuarioInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    private boolean ativo;
    private String nome;
    private String fone;
    private String email;
    private String avt;
    @Temporal(TemporalType.DATE)
    private Date dtcad;
    @Temporal(TemporalType.DATE)
    private Date dtmod;
    @Id
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "id_usu_type", referencedColumnName = "id")
    @OneToOne
    private UsuarioTipo idUsuType;
    @JoinColumn(name = "id_perfis", referencedColumnName = "id")
    @OneToOne
    private Perfis idPerfis;
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    @OneToOne
    private Endereco idEndereco;
    @JoinColumn(name = "id_emp", referencedColumnName = "id")
    @OneToOne
    private Empresa idEmp;

    public UsuarioInfo() {
    }

    public UsuarioInfo(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioInfo(Long idUsuario, boolean ativo) {
        this.idUsuario = idUsuario;
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioTipo getIdUsuType() {
        return idUsuType;
    }

    public void setTipo(UsuarioTipo idUsuType) {
        this.idUsuType = idUsuType;
    }

    public Perfis getIdPerfis() {
        return idPerfis;
    }

    public void setPerfil(Perfis idPerfis) {
        this.idPerfis = idPerfis;
    }

    public Endereco getEnd() {
        return idEndereco;
    }

    public void setEnd(Endereco idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Empresa getIdEmp() {
        return idEmp;
    }

    public void setEmpresa(Empresa idEmp) {
        this.idEmp = idEmp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioInfo)) {
            return false;
        }
        UsuarioInfo other = (UsuarioInfo) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gmp.obj.UsuarioInfo[ idUsuario=" + idUsuario + " ]";
    }
    
}
