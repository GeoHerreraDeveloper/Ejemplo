
package com.evaluacion.dao;

import com.evaluacion.modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteDAO extends Conexion{
    private String sql=null; // llevar el codigo sql 
    private PreparedStatement ejecutarSql; // ejecuta el codigo sql
    private ResultSet respuesta; // ResultSet sirve para la consulta
    
    public boolean GuardarCliente(Cliente clienteNuevo) {
        boolean mensajero=false; 
        try {
            this.conectar();
            sql="INSERT INTO cliente values(?,?,?,?)";
            ejecutarSql= getMiconexion().prepareStatement(sql);
            ejecutarSql.setInt(1, clienteNuevo.getId());
            ejecutarSql.setString(2, clienteNuevo.getNombre());
            ejecutarSql.setString(3, clienteNuevo.getApellido());
            ejecutarSql.setString(4, clienteNuevo.getNit());
            
            ejecutarSql.executeUpdate();
            mensajero= true;
            
        } catch (SQLException ex) {
            mensajero=false;
            System.out.println("Error en DAO: "+ ex);
        } finally {
            this.cerrarConex();
            clear(clienteNuevo);
        }
        return mensajero;
        
    }
  
     public boolean EliminarCliente(Cliente clienteNuevo) {
        boolean mensajero=false; 
        try {
            this.conectar();
            sql="DELETE FROM cliente WHERE id=?";
            ejecutarSql= getMiconexion().prepareStatement(sql);
            ejecutarSql.setInt(1, clienteNuevo.getId());
            ejecutarSql.executeUpdate();
            mensajero= true;
            
        } catch (SQLException ex) {
            mensajero=false;
            System.out.println("Error en DAO: "+ ex);
        } finally {
            this.cerrarConex();
        }
        return mensajero;
    }
     
     public boolean ActualizarCliente(Cliente clienteNuevo) {
        boolean mensajero=false; 
        try {
            this.conectar();
            int id=clienteNuevo.getId();
            sql="UPDATE cliente SET nombre=?, apellido=?, nit=? WHERE id=?";
            ejecutarSql= getMiconexion().prepareStatement(sql);
            ejecutarSql.setString(1, clienteNuevo.getNombre());
            ejecutarSql.setString(2, clienteNuevo.getApellido());
            ejecutarSql.setString(3, clienteNuevo.getNit());
            ejecutarSql.setInt(4, clienteNuevo.getId());
            
            ejecutarSql.executeUpdate();
            mensajero= true;
            
        } catch (SQLException ex) {
            mensajero=false;
            System.out.println("Error en DAO: "+ ex);
        } finally {
            this.cerrarConex();
        }
        return mensajero;
    }
     
        public ArrayList<Cliente> buscarClientePorId(Cliente buscarCliente){
                ArrayList<Cliente> tabla = new ArrayList();
                respuesta=null;
                
        try {
            this.conectar();
            sql="SELECT * FROM cliente WHERE id=?";
            ejecutarSql= getMiconexion().prepareStatement(sql);
            ejecutarSql.setInt(1, buscarCliente.getId());
            respuesta= ejecutarSql.executeQuery();
            if (respuesta.next()) {
                buscarCliente.setNombre(respuesta.getString("nombre"));
                buscarCliente.setApellido(respuesta.getString("apellido"));
                buscarCliente.setNit(respuesta.getString("nit"));
                tabla.add(buscarCliente);
            } else {
                System.out.println("Cliente no existe");
            }
            ejecutarSql.close();
            respuesta.close();
        } catch (SQLException ex) {
            System.out.println("Error en Dao"+ex);
        } finally {
            this.cerrarConex();
        }
        return tabla;
        }
        
        public Cliente buscarClientePorId2(Cliente buscarCliente){
                
        try {
            this.conectar();
            sql="SELECT * FROM cliente WHERE id=?";
            ejecutarSql= getMiconexion().prepareStatement(sql);
            ejecutarSql.setInt(1, buscarCliente.getId());
            respuesta= ejecutarSql.executeQuery();
            if (respuesta.next()) {
                buscarCliente.setNombre(respuesta.getString("nombre"));
                buscarCliente.setApellido(respuesta.getString("apellido"));
                buscarCliente.setNit(respuesta.getString("nit"));
            }
            ejecutarSql.close();
            respuesta.close();
        } catch (SQLException ex) {
            System.out.println("Error en Dao"+ex);
        } finally {
            this.cerrarConex();
        }
        return buscarCliente;
        }
        
        
        
        public ArrayList<Cliente> buscarClientePorNombre(Cliente buscarCliente){
                ArrayList<Cliente> tabla = new ArrayList();
                
        try {
            this.conectar();
            sql="SELECT * FROM cliente WHERE nombre=?";
            ejecutarSql= getMiconexion().prepareStatement(sql);
            ejecutarSql.setString(1, buscarCliente.getNombre());
            respuesta= ejecutarSql.executeQuery();
            respuesta.next();
            buscarCliente.setId(respuesta.getInt("id"));
            buscarCliente.setApellido(respuesta.getString("apellido"));
            buscarCliente.setNit(respuesta.getString("nit"));
            tabla.add(buscarCliente);
            ejecutarSql.close();
            respuesta.close();
        } catch (SQLException ex) {
            System.out.println("Error en Dao"+ex);
        } finally {
            this.cerrarConex();
        }
        return tabla;
        }
        
       public ArrayList<Cliente> buscarTodosCliente(){
           ArrayList<Cliente> tabla = new ArrayList();
           
        try {
            this.conectar();
            sql="SELECT * FROM cliente";
            ejecutarSql=getMiconexion().prepareStatement(sql);
            respuesta=ejecutarSql.executeQuery();
            while (respuesta.next()){
                Cliente consulta = new Cliente();
                consulta.setId(respuesta.getInt("id"));
                consulta.setNombre(respuesta.getString("nombre"));
                consulta.setApellido(respuesta.getString("apellido"));
                consulta.setNit(respuesta.getString("nit"));
                tabla.add(consulta);
            }
            ejecutarSql.close();
            respuesta.close();
        } catch (SQLException ex) {
            System.out.println("Error en Dao"+ex);
        } finally {
            this.cerrarConex();
        }
        return tabla;
       }

    private Cliente clear(Cliente clienteNuevo) {
          clienteNuevo.setId(0);
          clienteNuevo.setNombre(null);
          clienteNuevo.setApellido(null);
          clienteNuevo.setNit(null);
          return clienteNuevo;
    }
}
