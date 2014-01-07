package com.gmp.obj;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "menu_itens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuItens.findAll", query = "SELECT m FROM MenuItens m"),
    @NamedQuery(name = "MenuItens.findById", query = "SELECT m FROM MenuItens m WHERE m.id = :id"),
    @NamedQuery(name = "MenuItens.findByDescrip", query = "SELECT m FROM MenuItens m WHERE m.descrip = :descrip"),
    @NamedQuery(name = "MenuItens.findByIco", query = "SELECT m FROM MenuItens m WHERE m.ico = :ico"),
    @NamedQuery(name = "MenuItens.findByIdMenus", query = "SELECT m FROM MenuItens m WHERE m.idMenus = :idMenus")})
public class MenuItens implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    private long id;
    private String descrip;
    private String ico;
    @Id
    @Basic(optional = false)
    @Column(name = "id_menus")
    private Long idMenus;
    @JoinColumn(name = "id_menus", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Menu menu;

    public MenuItens() {
    }

    public MenuItens(Long idMenus) {
        this.idMenus = idMenus;
    }

    public MenuItens(Long idMenus, long id) {
        this.idMenus = idMenus;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public Long getIdMenus() {
        return idMenus;
    }

    public void setIdMenus(Long idMenus) {
        this.idMenus = idMenus;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenus != null ? idMenus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuItens)) {
            return false;
        }
        MenuItens other = (MenuItens) object;
        if ((this.idMenus == null && other.idMenus != null) || (this.idMenus != null && !this.idMenus.equals(other.idMenus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gmp.obj.MenuItens[ idMenus=" + idMenus + " ]";
    }
    
}
