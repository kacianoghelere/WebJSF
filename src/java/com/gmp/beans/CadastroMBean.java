package com.gmp.beans;

import com.gmp.bo.UsuarioBO;
import com.gmp.obj.Usuario;
import gmp.controls.Hasher;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.component.themeswitcher.ThemeSwitcher;

/**
 * Bean gerenciado da tela de cadastros
 *
 * @author kaciano
 */
@ManagedBean
@RequestScoped
public class CadastroMBean {

    private String login;
    private String senha;
    private String confirma;
    private UsuarioBO ubo;

    /**
     * Cria nova instancia de CadastroMBean
     */
    public CadastroMBean() {
        ubo = new UsuarioBO();
        ThemeSwitcher ts = new ThemeSwitcher();        
    }

    /**
     * Verifica a igualdade de senhas
     *
     * @return Booleano de retorno da comparação
     */
    public boolean validatePassword() {
        return senha.equals(confirma);
    }

    /**
     * Limpa os campos
     */
    public void clean() {
        this.login = "";
        this.senha = "";
        this.confirma = "";
    }

    /**
     * Salva o novo usuário
     */
    public void save() {
        System.out.println(login + " - " + senha + " - " + confirma);
        if (validatePassword()) {
            try {
                String pass = new Hasher().codificar(senha);
                ubo.save(new Usuario(Long.MIN_VALUE, login, pass));
            } catch (Exception ex) {
                Logger.getLogger(CadastroMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }

    /**
     *
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return
     */
    public String getSenha() {
        return senha;
    }

    /**
     *
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     *
     * @return
     */
    public String getConfirma() {
        return confirma;
    }

    /**
     *
     * @param confirma
     */
    public void setConfirma(String confirma) {
        this.confirma = confirma;
    }

    /**
     *
     * @return
     */
    public UsuarioBO getUbo() {
        return ubo;
    }

    /**
     *
     * @param ubo
     */
    public void setUbo(UsuarioBO ubo) {
        this.ubo = ubo;
    }

}
