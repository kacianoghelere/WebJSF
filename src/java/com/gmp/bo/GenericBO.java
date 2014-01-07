package com.gmp.bo;

import com.gmp.config.BeanFactory;
import com.gmp.dao.impl.GenericDAO;
import java.util.List;

/**
 * Business object de Usuário
 *
 * @author kaciano
 * @param <T> Parametro generico
 */
public abstract class GenericBO<T> {

    private GenericDAO<T> gendao = (GenericDAO<T>) BeanFactory.getBean("genDAO", GenericDAO.class);

    public List<T> findAll() throws Exception {
        return gendao.findAll();
    }

    public void save(T ent) throws Exception {
        gendao.save(ent);
    }

    public void update(T ent) throws Exception {
        gendao.update(ent);
    }

    public void merge(T ent) throws Exception {
        gendao.merge(ent);
    }

    public void delete(T ent) throws Exception {
        gendao.delete(ent);
    }

    public GenericDAO getEntDAO() {
        return gendao;
    }

    public void setEntdao(GenericDAO entdao) {
        this.gendao = entdao;
    }
}
