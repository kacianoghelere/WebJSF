package com.gmp.beans.datamodel;

import com.gmp.obj.Usuario;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author kaciano
 */
public class UsuarioDataModel extends ListDataModel<Usuario> implements SelectableDataModel<Usuario> {

    /**
     * 
     */
    public UsuarioDataModel() {
    }

    /**
     * 
     * @param data 
     */
    public UsuarioDataModel(List<Usuario> data) {
        super(data);
    }

    /**
     * 
     * @param rowKey
     * @return 
     */
    @Override
    public Usuario getRowData(String rowKey) {

        List<Usuario> usus = (List<Usuario>) getWrappedData();
        System.out.println(rowKey);
        for (Usuario usu : usus) {
            if (String.valueOf(usu.getId()).equals(rowKey)) {
                return usu;
            }
        }

        return null;
    }

    /**
     * 
     * @param usu
     * @return 
     */
    @Override
    public Object getRowKey(Usuario usu) {
        return String.valueOf(usu.getId());
    }
}
