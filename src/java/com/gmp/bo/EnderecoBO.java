package com.gmp.bo;

import com.gmp.config.BeanFactory;
import com.gmp.dao.impl.EnderecoDAO;
import com.gmp.obj.Endereco;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author kaciano
 */
public class EnderecoBO implements Serializable {

    private EnderecoDAO enddao = (EnderecoDAO) BeanFactory.getBean("endDAO", EnderecoDAO.class);

    /**
     *
     * @return @throws Exception
     */
    public List<Endereco> findAll() throws Exception {
        return enddao.findAll();
    }

    /**
     *
     * @param end
     * @return
     * @throws Exception
     */
    public Endereco save(Endereco end) throws Exception {
        return enddao.save(end);
    }

    /**
     *
     * @param end
     * @return
     * @throws Exception
     */
    public Endereco update(Endereco end) throws Exception {
        return enddao.update(end);
    }

    /**
     *
     * @param end
     * @return
     * @throws Exception
     */
    public Endereco merge(Endereco end) throws Exception {
        return enddao.merge(end);
    }

    /**
     *
     * @param end
     * @throws Exception
     */
    public void delete(Endereco end) throws Exception {
        enddao.delete(end);
    }

    /**
     *
     * @return
     */
    public EnderecoDAO getUsudao() {
        return enddao;
    }

    /**
     *
     * @param enddao
     */
    public void setUsudao(EnderecoDAO enddao) {
        this.enddao = enddao;
    }

}
