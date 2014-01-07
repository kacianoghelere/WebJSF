package com.gmp.bo;

import com.gmp.config.BeanFactory;
import com.gmp.dao.impl.UsuarioTipoDAO;
import com.gmp.obj.UsuarioTipo;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author kaciano
 */
public class UsuarioTipoBO implements Serializable {

    private UsuarioTipoDAO usudao = (UsuarioTipoDAO) BeanFactory.getBean("usutipoDAO", UsuarioTipoDAO.class);

    public List<UsuarioTipo> findAll() throws Exception {
        return usudao.findAll();
    }

    public UsuarioTipo save(UsuarioTipo usu) throws Exception {
        return usudao.save(usu);
    }

    public UsuarioTipo update(UsuarioTipo usu) throws Exception {
        return usudao.update(usu);
    }

    public UsuarioTipo merge(UsuarioTipo usu) throws Exception {
        return usudao.merge(usu);
    }

    public void delete(UsuarioTipo usu) throws Exception {
        usudao.delete(usu);
    }

    public UsuarioTipoDAO getUsudao() {
        return usudao;
    }

    public void setUsudao(UsuarioTipoDAO usudao) {
        this.usudao = usudao;
    }
}
