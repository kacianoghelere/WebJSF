package com.gmp.bo;

import com.gmp.config.BeanFactory;
import com.gmp.dao.impl.EmpresaTipoDAO;
import com.gmp.obj.EmpresaTipo;
import java.util.List;

/**
 *
 * @author kaciano
 */
public class EmpresaTipoBO {

    private EmpresaTipoDAO infodao = (EmpresaTipoDAO) BeanFactory.getBean("emptipoDAO", EmpresaTipoDAO.class);

    public List<EmpresaTipo> findAll() throws Exception {
        return infodao.findAll();
    }

    public EmpresaTipo save(EmpresaTipo info) throws Exception {
        return infodao.save(info);
    }

    public EmpresaTipo update(EmpresaTipo info) throws Exception {
        return infodao.update(info);
    }

    public EmpresaTipo merge(EmpresaTipo info) throws Exception {
        return infodao.merge(info);
    }

    public void delete(EmpresaTipo info) throws Exception {
        infodao.delete(info);
    }

    public EmpresaTipoDAO getUsudao() {
        return infodao;
    }

    public void setUsudao(EmpresaTipoDAO infodao) {
        this.infodao = infodao;
    }
}
