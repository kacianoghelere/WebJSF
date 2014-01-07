package com.gmp.beans;

import com.gmp.beans.datamodel.UsuarioDataModel;
import com.gmp.bo.UsuarioBO;
import com.gmp.obj.Usuario;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kaciano
 */
@ManagedBean
@RequestScoped
public class UsuarioMBean implements Serializable {

    private List<Usuario> usuList = new LinkedList<Usuario>();
    private Usuario selectedUsu;
    private Usuario[] selectedUsus;
    private UsuarioDataModel udm;
    private UsuarioBO ubo;

    /**
     * Creates a new instance of IndexMBean
     */
    public UsuarioMBean() {
        try {
            ubo = new UsuarioBO();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            usuList = ubo.findAll();
            udm = new UsuarioDataModel(usuList);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioMBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrar() {
        System.out.println(selectedUsu);
    }

    public Usuario getSelectedUsu() {
        return selectedUsu;
    }

    public void setSelectedUsu(Usuario selectedUsu) {
        this.selectedUsu = selectedUsu;
    }

    public List<Usuario> getUsuList() {
        return usuList;
    }

    public void setUsuList(List<Usuario> usuList) {
        this.usuList = usuList;
    }

    public Usuario[] getSelectedUsus() {
        return selectedUsus;
    }

    public void setSelectedUsus(Usuario[] selectedUsus) {
        this.selectedUsus = selectedUsus;
    }

    public UsuarioDataModel getUdm() {
        return udm;
    }

    public void setUdm(UsuarioDataModel udm) {
        this.udm = udm;
    }
}
