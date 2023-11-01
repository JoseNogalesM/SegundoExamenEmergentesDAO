
package com.emergentes.DAO;

import com.emergentes.modelo.Categorias;
import java.util.List;

/**
 *
 * @author nogal
 */
public interface categoriasDAO {
    public void insert (Categorias categoria) throws Exception;
    public void update(Categorias categoria ) throws Exception;
    public void delete(int id) throws Exception;
    public Categorias getById(int id) throws Exception;
    public List<Categorias> getAll() throws Exception;
}
