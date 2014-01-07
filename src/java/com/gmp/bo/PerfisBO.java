package com.gmp.bo;

import com.gmp.config.BeanFactory;
import com.gmp.dao.impl.PerfisDAO;
import com.gmp.obj.Perfis;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author kaciano
 */
public class PerfisBO implements Serializable {

    private PerfisDAO perfdao = (PerfisDAO) BeanFactory.getBean("usuDAO", PerfisDAO.class);

    /**
     *
     * @return @throws Exception
     */
    public List<Perfis> findAll() throws Exception {
        return perfdao.findAll();
    }

    /**
     *
     * @param usu
     * @return
     * @throws Exception
     */
    public Perfis save(Perfis usu) throws Exception {
        return perfdao.save(usu);
    }

    /**
     *
     * @param usu
     * @return
     * @throws Exception
     */
    public Perfis update(Perfis usu) throws Exception {
        return perfdao.update(usu);
    }

    /**
     *
     * @param usu
     * @return
     * @throws Exception
     */
    public Perfis merge(Perfis usu) throws Exception {
        return perfdao.merge(usu);
    }

    /**
     *
     * @param usu
     * @throws Exception
     */
    public void delete(Perfis usu) throws Exception {
        perfdao.delete(usu);
    }

    /**
     *
     * @return
     */
    public PerfisDAO getUsudao() {
        return perfdao;
    }

    /**
     *
     * @param usudao
     */
    public void setUsudao(PerfisDAO usudao) {
        this.perfdao = usudao;
    }

}
