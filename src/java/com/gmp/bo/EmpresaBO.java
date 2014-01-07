package com.gmp.bo;

import com.gmp.config.BeanFactory;
import com.gmp.dao.impl.EmpresaDAO;
import com.gmp.obj.Empresa;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Business Object de Empresa
 *
 * @author kaciano
 */
public class EmpresaBO implements Serializable {

    private EmpresaDAO empdao = (EmpresaDAO) BeanFactory.getBean("empDAO", EmpresaDAO.class);

    public List<Empresa> findAll() throws Exception {
        return empdao.findAll();
    }

    public Empresa save(Empresa emp) throws Exception {
        return empdao.save(emp);
    }

    public Empresa update(Empresa emp) throws Exception {
        return empdao.update(emp);
    }

    public Empresa merge(Empresa emp) throws Exception {
        return empdao.merge(emp);
    }

    public void delete(Empresa emp) throws Exception {
        empdao.delete(emp);
    }

    public EmpresaDAO getUsudao() {
        return empdao;
    }

    public void setUsudao(EmpresaDAO empdao) {
        this.empdao = empdao;
    }

//    public static void main(String[] args) {
//        try {
//            EmpresaBO ebo = new EmpresaBO();
//            ebo.save(new Empresa(Long.MIN_VALUE));
//        } catch (Exception ex) {
//            Logger.getLogger(EmpresaBO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
