package com.gmp.beans.wizard;

import com.gmp.bo.EmpresaBO;
import com.gmp.bo.EmpresaInfoBO;
import com.gmp.bo.EmpresaTipoBO;
import com.gmp.bo.EnderecoBO;
import com.gmp.bo.PerfisAcessoBO;
import com.gmp.bo.PerfisBO;
import com.gmp.bo.UsuarioBO;
import com.gmp.bo.UsuarioInfoBO;
import com.gmp.bo.UsuarioTipoBO;
import com.gmp.obj.Empresa;
import com.gmp.obj.EmpresaInfo;
import com.gmp.obj.EmpresaTipo;
import com.gmp.obj.Endereco;
import com.gmp.obj.Perfis;
import com.gmp.obj.PerfisAcesso;
import com.gmp.obj.Usuario;
import com.gmp.obj.UsuarioInfo;
import com.gmp.obj.UsuarioTipo;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author kaciano
 */
@ManagedBean
@SessionScoped
public class UsuarioWizard implements Serializable {

    private Usuario usu = new Usuario();
    private UsuarioInfo ui = new UsuarioInfo();
    private UsuarioTipo ut = new UsuarioTipo();
    private Empresa emp = new Empresa();
    private EmpresaInfo empi = new EmpresaInfo();
    private EmpresaTipo empt = new EmpresaTipo();
    private Endereco end = new Endereco();
    private Endereco end2 = new Endereco();
    private Perfis perfil = new Perfis();
    private PerfisAcesso pa = new PerfisAcesso();
    private boolean skip;

    private static final Logger logger = Logger.getLogger(UsuarioWizard.class.getName());

    public UsuarioWizard() {
        ui = new UsuarioInfo(usu.getId());
        ut = new UsuarioTipo(usu.getId());
        emp = new Empresa(Long.MIN_VALUE);
        empi = new EmpresaInfo(emp.getId());
        empt = new EmpresaTipo(emp.getId());
        end = new Endereco(Long.MIN_VALUE);
        perfil = new Perfis(Long.MIN_VALUE);
        pa = new PerfisAcesso();
        
        pa.setPerfis(perfil);
        end.setUsuarioInfo(ui);
        end.setEmpresaInfo(empi);
        emp.setEmpresa(empi);
        emp.setUsuarioInfo(ui);
        empt.setEmpresaInfo(empi);
        empi.setTipo(empt);
        empi.setEndereco(end);
        empi.setEmpresa(emp);
        perfil.setPerfisAcesso(new LinkedList<PerfisAcesso>());
        perfil.setUsuarioInfo(ui);
        ui.setPerfil(perfil);
        ui.setEmpresa(emp);
        ui.setEnd(end);
        ut.setUsuarioInfo(ui);
        ui.setTipo(ut);
        ui.setUsuario(usu);
        usu.setUsuarioInfo(new LinkedList<UsuarioInfo>());
        usu.addInfo(ui, true);
    }

    public Usuario getUsuario() {
        return usu;
    }

    public void setUsuario(Usuario user) {
        this.usu = user;
    }

    public void save(ActionEvent actionEvent) {
        //Persist user           
        FacesMessage msg = new FacesMessage("Registrado", "Bem vindo: " + usu.getLogin());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        try {
            new UsuarioBO().save(usu);
            new UsuarioInfoBO().save(ui);
            new UsuarioTipoBO().save(ut);
            new EmpresaBO().save(emp);
            new EmpresaInfoBO().save(empi);
            new EmpresaTipoBO().save(empt);
            new EnderecoBO().save(end);
            new PerfisBO().save(perfil);
            new PerfisAcessoBO().save(pa);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioWizard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        logger.log(Level.INFO, "Current wizard step:{0}", event.getOldStep());
        logger.log(Level.INFO, "Next step:{0}", event.getNewStep());

        if (skip) {
            skip = false;   //reset in case user goes back  
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public UsuarioInfo getInfo() {
        return ui;
    }

    public void setInfo(UsuarioInfo info) {
        this.ui = info;
    }

    public Empresa getEmpresa() {
        return emp;
    }

    public void setEmpresa(Empresa empresa) {
        this.emp = empresa;
    }

    public Endereco getEndereco() {
        return end;
    }

    public void setEndereco(Endereco endereco) {
        this.end = endereco;
    }

    public Perfis getPerfis() {
        return perfil;
    }

    public void setPerfis(Perfis perfis) {
        this.perfil = perfis;
    }

    public UsuarioTipo getUsuarioTipo() {
        return ut;
    }

    public void setUsuarioTipo(UsuarioTipo usuarioTipo) {
        this.ut = usuarioTipo;
    }

    public UsuarioInfo getUsuinfo() {
        return ui;
    }

    public void setUsuinfo(UsuarioInfo usuinfo) {
        this.ui = usuinfo;
    }

    public EmpresaInfo getEmpinfo() {
        return empi;
    }

    public void setEmpinfo(EmpresaInfo empinfo) {
        this.empi = empinfo;
    }

    public EmpresaTipo getEmptipo() {
        return empt;
    }

    public void setEmptipo(EmpresaTipo emptipo) {
        this.empt = emptipo;
    }

    public PerfisAcesso getPa() {
        return pa;
    }

    public void setPa(PerfisAcesso pa) {
        this.pa = pa;
    }

}
