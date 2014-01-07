package com.gmp.dao.impl;

import com.gmp.dao.interfaces.IGenericDAO;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
//import org.hibernate.transaction.JDBCTransactionFactory

/**
 * Classe generica para generação de DAO's
 *
 * @author kaciano
 * @param <T> Tipo generico de classe
 */
public abstract class GenericDAO<T> extends HibernateDaoSupport implements IGenericDAO<T> {

    private Class<T> persistentClass;

    /**
     *
     */
    public GenericDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Retorna a classe persistente
     *
     * @return @throws Exception
     */
    public Class<T> getPersistentClass() throws Exception {
        return this.persistentClass;
    }

    /**
     * Salva a entidade
     *
     * @param entity Entidade a ser criada
     * @return entidade a ser criada
     * @throws Exception
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public T save(T entity) throws Exception {
        getHibernateTemplate().save(entity);
        getHibernateTemplate().flush();
        return entity;
    }

    /**
     * Salva as entidades da lista
     *
     * @param entity lista de entidades
     * @return lista de entidades
     * @throws Exception
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<T> save(List<T> entity) throws Exception {
        for (T t : entity) {
            getHibernateTemplate().save(t);
        }
        getHibernateTemplate().flush();
        return entity;
    }

    /**
     * Atualiza entidade
     *
     * @param entity entidade a ser atualizada
     * @return entidade
     * @throws Exception
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public T update(T entity) throws Exception {
        getHibernateTemplate().update(entity);
        getHibernateTemplate().flush();
        return entity;
    }

    /**
     * Efetua merge na entidade
     *
     * @param entity entidade em questão
     * @return entidade
     * @throws Exception
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public T merge(T entity) throws Exception {
        getHibernateTemplate().merge(entity);
        getHibernateTemplate().flush();
        return entity;
    }

    /**
     * Deleta entidade
     *
     * @param entity entidade a ser deletada
     * @throws Exception
     */
    @Override
    public void delete(T entity) throws Exception {
        getHibernateTemplate().delete(entity);
        getHibernateTemplate().flush();
    }

    /**
     * Deleta entidades da lista
     *
     * @param entity lista de entidades
     * @throws Exception
     */
    @Override
    public void delete(List<T> entity) throws Exception {
        for (T t : entity) {
            getHibernateTemplate().delete(t);
            getHibernateTemplate().flush();
        }
    }

    /**
     * Retorna todos os objetos da entidade conforme os parametros de busca
     *
     * @param order Ordem do retorno da busca
     * @param criterion Criterio da busca
     * @return Lista de entidades
     * @throws Exception
     */
    @Override
    public List<T> findAll(Order order, Criterion... criterion) throws Exception {
        Session session = getSession();
        Criteria crit = session.createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        crit.addOrder(order);
        return crit.list();
    }

    /**
     * Retorna todos os objetos da entidade conforme os parametros de busca
     *
     * @param criterion Criterio da busca
     * @return Lista de entidades
     * @throws Exception
     */
    @Override
    public List<T> findAll(Criterion... criterion) throws Exception {
        Session session = getSession();
        Criteria crit = session.createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
    }

    /**
     * Retorna um objeto conforme os parametros de busca especificados
     *
     * @param criterion Criterio da busca
     * @return Objeto resultante
     * @throws Exception
     */
    @Override
    public T findOne(Criterion... criterion) throws Exception {
        Session session = getSession();
        Criteria crit = session.createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return (T) crit.uniqueResult();
    }

    /**
     * Busca entidade conforme o id especificado
     *
     * @param id ID a ser buscado
     * @return Objeto resultante
     * @throws Exception
     */
    @Override
    public T getByID(Long id) throws Exception {
        return (T) getHibernateTemplate().get(getPersistentClass(), id);
    }

    /**
     * Salva ou atualiza a entidade em questão
     *
     * @param entity Entidade a ser manipulada
     * @return Entidade
     * @throws Exception
     */
    @Override
    public T saveOrUpdate(T entity) throws Exception {
        getHibernateTemplate().saveOrUpdate(entity);
        getHibernateTemplate().flush();
        return entity;
    }

    /**
     * Retorna a lista total de objetos conforme a classe persistida
     *
     * @return @throws Exception
     */
    @Override
    public List<T> findAll() throws Exception {
        Session session = getSession();
        Criteria crit = session.createCriteria(getPersistentClass());
        return crit.list();
    }

}
