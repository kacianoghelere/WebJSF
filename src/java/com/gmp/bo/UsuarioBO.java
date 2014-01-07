package com.gmp.bo;

import com.gmp.config.BeanFactory;
import com.gmp.dao.impl.UsuarioDAO;
import com.gmp.obj.Empresa;
import com.gmp.obj.EmpresaInfo;
import com.gmp.obj.EmpresaTipo;
import com.gmp.obj.Endereco;
import com.gmp.obj.Perfis;
import com.gmp.obj.PerfisAcesso;
import com.gmp.obj.Usuario;
import com.gmp.obj.UsuarioInfo;
import com.gmp.obj.UsuarioTipo;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Business object de Usuário
 *
 * @author kaciano
 */
public class UsuarioBO implements Serializable {

    private UsuarioDAO usudao = (UsuarioDAO) BeanFactory.getBean("usuDAO", UsuarioDAO.class);

    /**
     *
     * @return @throws Exception
     */
    public List<Usuario> findAll() throws Exception {
        return usudao.findAll();
    }

    /**
     *
     * @param usu
     * @return
     * @throws Exception
     */
    public Usuario save(Usuario usu) throws Exception {
        return usudao.save(usu);
    }

    /**
     *
     * @param usu
     * @return
     * @throws Exception
     */
    public Usuario update(Usuario usu) throws Exception {
        return usudao.update(usu);
    }

    /**
     *
     * @param usu
     * @return
     * @throws Exception
     */
    public Usuario merge(Usuario usu) throws Exception {
        return usudao.merge(usu);
    }

    /**
     *
     * @param usu
     * @throws Exception
     */
    public void delete(Usuario usu) throws Exception {
        usudao.delete(usu);
    }

    /**
     *
     * @return
     */
    public UsuarioDAO getUsudao() {
        return usudao;
    }

    /**
     *
     * @param usudao
     */
    public void setUsudao(UsuarioDAO usudao) {
        this.usudao = usudao;
    }

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        try {
            Usuario usu = new Usuario(Long.MIN_VALUE, "Kaciano", "123456");
            UsuarioInfo ui = new UsuarioInfo(usu.getId());
            UsuarioTipo ut = new UsuarioTipo(usu.getId());
            Empresa emp = new Empresa(Long.MIN_VALUE);
            EmpresaInfo empi = new EmpresaInfo(emp.getId());
            EmpresaTipo empt = new EmpresaTipo(emp.getId());
            Endereco end = new Endereco(Long.MIN_VALUE);
            Perfis perfil = new Perfis(Long.MIN_VALUE);
            PerfisAcesso pa = new PerfisAcesso();

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

            UsuarioBO ubo = new UsuarioBO();
            ubo.save(usu);

//            List<Usuario> findAll = ubo.findAll();
//            for (Usuario u : findAll) {
//                System.out.println(u.getLogin());
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
