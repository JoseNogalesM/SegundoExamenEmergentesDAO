/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.DAO;

import com.emergentes.modelo.Libro;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nogal
 */
public class libroDAOimple extends ConexionDB implements libroDAO{

    @Override
    public void insert(Libro libro) throws Exception {
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("Insert into libros (titulo,autor,disponible,categoria) values(?,?,?,?)");
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getDisponible());
                        ps.setString(4, libro.getCategoria());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    

    @Override
    public void update(Libro libro) throws Exception {
 try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("update libros SET titulo=?, autor=?,disponible=?, categoria=? where id=?");
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getDisponible());
                        ps.setString(4, libro.getCategoria());
                        ps.setInt(4, libro.getId());

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
        PreparedStatement ps=this.conn.prepareStatement("DELETE from libros where id=? ");
                ps.setInt(1, id);

        ps.executeUpdate();
        } catch (Exception e) {
            throw e;
            
        }finally{
            this.desconectar();
        }
    }

    @Override
    public Libro getById(int id) throws Exception {
        Libro lib = new Libro();
        try {
            
         this.conectar();
        PreparedStatement ps=this.conn.prepareStatement("select* from libros where id=? ");
                ps.setInt(1, id);
                ResultSet rs=ps.executeQuery();

        ps.executeUpdate();
        
            if (rs.next()) {
                lib.setId(rs.getInt("id"));
                lib.setTitulo(rs.getString("titulo"));
                lib.setAutor(rs.getString("autor"));
                lib.setDisponible(rs.getString("disponible"));
                lib.setCategoria(rs.getString("categoria"));
            }
        } catch (Exception e) {
            throw e;
            
        }finally{
            this.desconectar();
        }
        return lib;
    }
    

    @Override
    public List<Libro> getAll() throws Exception {
        List<Libro> lista= null;
              try {
            
         this.conectar();
        PreparedStatement ps=this.conn.prepareStatement("select* from libros");
                ResultSet rs=ps.executeQuery();

        ps.executeUpdate();
   lista =new ArrayList<Libro>();        
            while(rs.next()) {
                Libro lib=new Libro();
                lib.setId(rs.getInt("id"));
                lib.setTitulo(rs.getString("titulo"));
                lib.setAutor(rs.getString("autor"));
                lib.setDisponible(rs.getString("disponible"));
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
    

