package com.gmp.bo;

import com.gmp.config.BeanFactory;
import com.gmp.dao.impl.PerfisAcessoDAO;
import com.gmp.obj.PerfisAcesso;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author kaciano
 */
public class PerfisAcessoBO implements Serializable {

    private PerfisAcessoDAO perfaccdao = (PerfisAcessoDAO) BeanFactory.getBean("usuDAO", PerfisAcessoDAO.class);

    /**
     *
     * @return @throws Exception
     */
    public List<PerfisAcesso> findAll() throws Exception {
        return perfaccdao.findAll();
    }

    /**
     *
     * @param usu
     * @return
     * @throws Exception
     */
    public PerfisAcesso save(PerfisAcesso usu) throws Exception {
        return perfaccdao.save(usu);
    }

    /**
     *
     * @param usu
     * @return
     * @throws Exception
     */
    public PerfisAcesso update(PerfisAcesso usu) throws Exception {
        return perfaccdao.update(usu);
    }

    /**
     *
     * @param usu
     * @return
     * @throws Exception
     */
    public PerfisAcesso merge(PerfisAcesso usu) throws Exception {
        return perfaccdao.merge(usu);
    }

    /**
     *
     * @param usu
     * @throws Exception
     */
    public void delete(PerfisAcesso usu) throws Exception {
        perfaccdao.delete(usu);
    }

    /**
     *
     * @return
     */
    public PerfisAcessoDAO getUsudao() {
        return perfaccdao;
    }

    /**
     *
     * @param usudao
     */
    public void setUsudao(PerfisAcessoDAO usudao) {
        this.perfaccdao = usudao;
    }

}
