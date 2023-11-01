
package com.emergentes.DAO;

import com.emergentes.modelo.Categorias;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nogal
 */
public class categoriaDAOimple extends ConexionDB implements categoriasDAO {

    @Override
    public void insert(Categorias categoria) throws Exception {
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("Insert into categoria (categoria) values(?)");

            ps.setString(1, categoria.getCategoria());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Categorias categoria) throws Exception {
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("update  categoria SET categoria=? where id=?");

            ps.setString(1, categoria.getCategoria());
            ps.setInt(2, categoria.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE  categoria  where id=?");

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public Categorias getById(int id) throws Exception {
        Categorias cat = new Categorias();
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM categoria  where id=?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            ps.executeUpdate();
            if (rs.next()) {
                cat.setId(rs.getInt("id"));

                cat.setCategoria(rs.getString("categoria"));
            }
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
        return cat;
    }

    @Override
    public List<Categorias> getAll() throws Exception {
            List<Categorias> lista= null;
              try {
            
         this.conectar();
        PreparedStatement ps=this.conn.prepareStatement("select* from categoria");
                ResultSet rs=ps.executeQuery();

        ps.executeUpdate();
   lista =new ArrayList<Categorias>();        
            while(rs.next()) {
                Categorias lib=new Categorias();
                lib.setId(rs.getInt("id"));
                
                lib.setCategoria(rs.getString("categoria"));
                lista.add(lib);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
            
        }finally{
            this.desconectar();
        }
              return lista;
    }

}
