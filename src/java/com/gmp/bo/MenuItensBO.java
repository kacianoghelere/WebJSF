package com.gmp.bo;

import com.gmp.config.BeanFactory;
import com.gmp.dao.impl.MenuItensDAO;
import com.gmp.obj.MenuItens;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author kaciano
 */
public class MenuItensBO implements Serializable {

    private MenuItensDAO midao = (MenuItensDAO) BeanFactory.getBean("usuDAO", MenuItensDAO.class);

    /**
     *
     * @return @throws Exception
     */
    public List<MenuItens> findAll() throws Exception {
        return midao.findAll();
    }

    /**
     *
     * @param usu
     * @return
     * @throws Exception
     */
    public MenuItens save(MenuItens usu) throws Exception {
        return midao.save(usu);
    }

    /**
     *
     * @param usu
     * @return
     * @throws Exception
     */
    public MenuItens update(MenuItens usu) throws Exception {
        return midao.update(usu);
    }

    /**
     *
     * @param usu
     * @return
     * @throws Exception
     */
    public MenuItens merge(MenuItens usu) throws Exception {
        return midao.merge(usu);
    }

    /**
     *
     * @param usu
     * @throws Exception
     */
    public void delete(MenuItens usu) throws Exception {
        midao.delete(usu);
    }

    /**
     *
     * @return
     */
    public MenuItensDAO getUsudao() {
        return midao;
    }

    /**
     *
     * @param usudao
     */
    public void setUsudao(MenuItensDAO usudao) {
        this.midao = usudao;
    }

}
