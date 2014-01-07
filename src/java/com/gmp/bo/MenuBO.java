package com.gmp.bo;

import com.gmp.config.BeanFactory;
import com.gmp.dao.impl.MenuDAO;
import com.gmp.obj.Menu;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author kaciano
 */
public class MenuBO implements Serializable {

    private MenuDAO menudao = (MenuDAO) BeanFactory.getBean("menuDAO", MenuDAO.class);

    /**
     *
     * @return @throws Exception
     */
    public List<Menu> findAll() throws Exception {
        return menudao.findAll();
    }

    /**
     *
     * @param menu
     * @return
     * @throws Exception
     */
    public Menu save(Menu menu) throws Exception {
        return menudao.save(menu);
    }

    /**
     *
     * @param menu
     * @return
     * @throws Exception
     */
    public Menu update(Menu menu) throws Exception {
        return menudao.update(menu);
    }

    /**
     *
     * @param menu
     * @return
     * @throws Exception
     */
    public Menu merge(Menu menu) throws Exception {
        return menudao.merge(menu);
    }

    /**
     *
     * @param menu
     * @throws Exception
     */
    public void delete(Menu menu) throws Exception {
        menudao.delete(menu);
    }

    /**
     *
     * @return
     */
    public MenuDAO getUsudao() {
        return menudao;
    }

    /**
     *
     * @param menudao
     */
    public void setUsudao(MenuDAO menudao) {
        this.menudao = menudao;
    }

}
