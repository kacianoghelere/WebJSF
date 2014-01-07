package com.gmp.bo;

import com.gmp.config.BeanFactory;
import com.gmp.dao.impl.UsuarioInfoDAO;
import com.gmp.obj.UsuarioInfo;
import java.util.List;

/**
 *
 * @author kaciano
 */
public class UsuarioInfoBO {

    private UsuarioInfoDAO infodao = (UsuarioInfoDAO) BeanFactory.getBean("usuinfoDAO", UsuarioInfoDAO.class);

    public List<UsuarioInfo> findAll() throws Exception {
        return infodao.findAll();
    }

    public UsuarioInfo save(UsuarioInfo info) throws Exception {
        return infodao.save(info);
    }

    public UsuarioInfo update(UsuarioInfo info) throws Exception {
        return infodao.update(info);
    }

    public UsuarioInfo merge(UsuarioInfo info) throws Exception {
        return infodao.merge(info);
    }

    public void delete(UsuarioInfo info) throws Exception {
        infodao.delete(info);
    }

    public UsuarioInfoDAO getUsudao() {
        return infodao;
    }

    public void setUsudao(UsuarioInfoDAO infodao) {
        this.infodao = infodao;
    }
}

