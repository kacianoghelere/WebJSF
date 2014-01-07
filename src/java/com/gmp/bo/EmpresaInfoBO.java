package com.gmp.bo;

import com.gmp.config.BeanFactory;
import com.gmp.dao.impl.EmpresaInfoDAO;
import com.gmp.obj.EmpresaInfo;
import java.util.List;

/**
 *
 * @author kaciano
 */
public class EmpresaInfoBO {

    private EmpresaInfoDAO infodao = (EmpresaInfoDAO) BeanFactory.getBean("empinfoDAO", EmpresaInfoDAO.class);

    public List<EmpresaInfo> findAll() throws Exception {
        return infodao.findAll();
    }

    public EmpresaInfo save(EmpresaInfo info) throws Exception {
        return infodao.save(info);
    }

    public EmpresaInfo update(EmpresaInfo info) throws Exception {
        return infodao.update(info);
    }

    public EmpresaInfo merge(EmpresaInfo info) throws Exception {
        return infodao.merge(info);
    }

    public void delete(EmpresaInfo info) throws Exception {
        infodao.delete(info);
    }

    public EmpresaInfoDAO getUsudao() {
        return infodao;
    }

    public void setUsudao(EmpresaInfoDAO infodao) {
        this.infodao = infodao;
    }
}