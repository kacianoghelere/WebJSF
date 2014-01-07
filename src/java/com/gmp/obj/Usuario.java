/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmp.obj;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByLogin", query = "SELECT u FROM Usuario u WHERE u.login = :login"),
    @NamedQuery(name = "Usuario.findBySen", query = "SELECT u FROM Usuario u WHERE u.sen = :sen")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    private String login;
    @Basic(optional = false)
    private String sen;
    @OneToMany(mappedBy = "usuario")
    private List<UsuarioInfo> usuarioInfo;

    public Usuario() {
    }

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(Long id, String login, String sen) {
        this.id = id;
        this.login = login;
        this.sen = sen;
    }

    public void addInfo(UsuarioInfo info) {
        usuarioInfo.add(info);
    }

    public void addInfo(UsuarioInfo info, boolean active) {
        info.setAtivo(active);
        usuarioInfo.add(info);
    }

    public UsuarioInfo getActiveInfo() {
        for (UsuarioInfo ui : usuarioInfo) {
            if (ui.getAtivo()) {
                return ui;
            }
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSen() {
        return sen;
    }

    public void setSen(String sen) {
        this.sen = sen;
    }

    public List<UsuarioInfo> getUsuarioInfo() {
        return usuarioInfo;
    }

    public void setUsuarioInfo(List<UsuarioInfo> usuarioInfo) {
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gmp.obj.Usuario[ id=" + id + " ]";
    }

}
