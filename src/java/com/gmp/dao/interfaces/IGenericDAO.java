package com.gmp.dao.interfaces;

import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

/**
 * Interface generica para os DAO's
 *
 * @author kaciano
 * @param <T> Objeto generico
 */
public interface IGenericDAO<T> {

    /**
     * Salva objeto
     *
     * @param obj Objeto a ser salvo
     * @return Objeto
     * @throws Exception
     */
    public T save(T obj) throws Exception;

    /**
     * Salva lista de objetos
     *
     * @param obj Objetos a serem salvos
     * @return Objeto
     * @throws Exception
     */
    public List<T> save(List<T> obj) throws Exception;

    /**
     * Salva ou atualiza o objeto
     *
     * @param obj Objeto em questão
     * @return Objeto
     * @throws Exception
     */
    public T saveOrUpdate(T obj) throws Exception;

    /**
     * Atualiza o objeto
     *
     * @param obj Objeto a ser atualizado
     * @return Objeto
     * @throws Exception
     */
    public T update(T obj) throws Exception;

    /**
     * Insere o objeto caso ele não exista, caso contrario atualiza
     *
     * @param obj Objeto a ser atualizado ou inserido
     * @return Objeto
     * @throws Exception
     */
    public T merge(T obj) throws Exception;

    /**
     * Deleta objeto
     *
     * @param obj Objeto a ser deletado
     * @throws Exception
     */
    public void delete(T obj) throws Exception;

    /**
     * Deleta lista de objetos
     *
     * @param obj Objetos a serem deletados
     * @throws Exception
     */
    public void delete(List<T> obj) throws Exception;

    /**
     * Retorna todos os objetos da classe
     *
     * @param order Ordem dos objetos
     * @param criterion Criterio de busca
     * @return Lista de objetos
     * @throws Exception
     */
    public List<T> findAll(Order order, Criterion... criterion) throws Exception;

    /**
     * Retorna todos os objetos da classe, conforme criterio aplicado
     *
     * @param criterion Criterio de busca
     * @return Lista de objetos
     * @throws Exception
     */
    public List<T> findAll(Criterion... criterion) throws Exception;

    /**
     * Retorna lista de entidades
     *
     * @return Lista de entidades
     * @throws Exception
     */
    public List<T> findAll() throws Exception;

    /**
     * Retorna todos os objeto da classe, conforme criterio aplicado
     *
     * @param criterion Criterio de busca
     * @return Lista de objetos
     * @throws Exception
     */
    public T findOne(Criterion... criterion) throws Exception;

    /**
     * Retorna objeto a partir do id
     *
     * @param id ID a ser buscado
     * @return Objeto compativel
     * @throws Exception
     */
    public T getByID(Long id) throws Exception;
}
