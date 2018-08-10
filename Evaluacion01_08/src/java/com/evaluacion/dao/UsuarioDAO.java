package com.evaluacion.dao;

import com.evaluacion.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO extends Conexion {

    //atributos
    Usuario usuarioX = new Usuario();
    ResultSet recibirConsulta; // recibir el resultado de un select
    PreparedStatement ejecutarConsulta;
    private String respuesta;
    private String codigoSql;

    //metodos
    public boolean ingresarUsuario(Usuario nuevoUsuario) {
        boolean respuesta1 = false; // false: no guardo true: si guardo
        try {
            this.conectar();
            codigoSql = "INSERT INTO usuario VALUES(?,?,?,MD5(?))";
            ejecutarConsulta = getMiconexion().prepareStatement(codigoSql);
            ejecutarConsulta.setInt(1, nuevoUsuario.getId());
            ejecutarConsulta.setString(2, nuevoUsuario.getNombre());
            ejecutarConsulta.setString(3, nuevoUsuario.getUsuario());
            ejecutarConsulta.setString(4, nuevoUsuario.getContraseña());
            ejecutarConsulta.executeUpdate();
            respuesta1 = true;
            ejecutarConsulta.close();
        } catch (SQLException ex) {
            System.out.println("Error en Dao");
            respuesta1 = false;
        } finally {
            this.cerrarConex();
        }
        return respuesta1;
    }

    public boolean modificarUsuario(Usuario actualizarUsuario) {
        boolean respuesta1 = false;

        try {
            this.conectar();
            codigoSql = "UPDATE usuario SET usuario=?, nombre=?, contrasena=MD5(?) WHERE id=?";
            ejecutarConsulta = getMiconexion().prepareStatement(codigoSql);
            ejecutarConsulta.setString(1, actualizarUsuario.getUsuario());
            ejecutarConsulta.setString(2, actualizarUsuario.getNombre());
            ejecutarConsulta.setString(3, actualizarUsuario.getContraseña());
            ejecutarConsulta.setInt(4, actualizarUsuario.getId());
            ejecutarConsulta.executeUpdate();
            respuesta1 = true;
            ejecutarConsulta.close();
        } catch (SQLException ex) {
            System.out.println("Error en Dao");
            respuesta1 = false;
        } finally {
            this.cerrarConex();
        }
        return respuesta1;
    }

    public boolean eliminarUsuario(Usuario borrarUsuario) {
        boolean respuesta1 = false;

        try {
            this.conectar();
            codigoSql = "DELETE FROM usuario WHERE usuario=?";
            ejecutarConsulta = getMiconexion().prepareStatement(codigoSql);
            ejecutarConsulta.setString(1, borrarUsuario.getUsuario());
            ejecutarConsulta.executeUpdate();
            respuesta1 = true;
            ejecutarConsulta.close();
        } catch (SQLException ex) {
            System.out.println("Error en Dao");
            respuesta1 = false;
        } finally {
            this.cerrarConex();
        }
        return respuesta1;
    }

    public ArrayList<Usuario> buscarUsuarioPorCodigo(Usuario buscarUsuario) {
        ArrayList<Usuario> tabla = new ArrayList();

        try {
            this.conectar();
            codigoSql = "SELECT * FROM usuario WHERE id=?";
            ejecutarConsulta = getMiconexion().prepareStatement(codigoSql);
            ejecutarConsulta.setInt(1, buscarUsuario.getId());
            recibirConsulta = ejecutarConsulta.executeQuery();
            recibirConsulta.next();
            buscarUsuario.setNombre(recibirConsulta.getString("nombre"));
            buscarUsuario.setUsuario(recibirConsulta.getString("usuario"));
            buscarUsuario.setContraseña(recibirConsulta.getString("contrasena"));
            tabla.add(buscarUsuario);
            ejecutarConsulta.close();
            recibirConsulta.close();
        } catch (SQLException ex) {
            System.out.println("Error en Dao" + ex);
        } finally {
            this.cerrarConex();
        }
        return tabla;
    }

    public Usuario buscarUsuarioPorCodigo2(Usuario buscarUsuario) {

        try {
            this.conectar();
            codigoSql = "SELECT * FROM usuario WHERE id=?";
            ejecutarConsulta = getMiconexion().prepareStatement(codigoSql);
            ejecutarConsulta.setInt(1, buscarUsuario.getId());
            recibirConsulta = ejecutarConsulta.executeQuery();
            if (recibirConsulta.next()) {
                buscarUsuario.setNombre(recibirConsulta.getString("nombre"));
                buscarUsuario.setUsuario(recibirConsulta.getString("usuario"));
                buscarUsuario.setContraseña(recibirConsulta.getString("contrasena"));
            }
            ejecutarConsulta.close();
            recibirConsulta.close();
        } catch (SQLException ex) {
            System.out.println("Error en Dao" + ex);
        } finally {
            this.cerrarConex();
        }
        return buscarUsuario;
    }

    public ArrayList<Usuario> buscarUsuarioPorNombre(Usuario buscarUsuario) {
        ArrayList<Usuario> tabla = new ArrayList();

        try {
            this.conectar();
            codigoSql = "SELECT * FROM usuario WHERE nombre=?";
            ejecutarConsulta = getMiconexion().prepareStatement(codigoSql);
            ejecutarConsulta.setString(1, buscarUsuario.getNombre());
            recibirConsulta = ejecutarConsulta.executeQuery();
            recibirConsulta.next();
            buscarUsuario.setId(recibirConsulta.getInt("id"));
            buscarUsuario.setNombre(recibirConsulta.getString("nombre"));
            buscarUsuario.setUsuario(recibirConsulta.getString("usuario"));
            buscarUsuario.setContraseña(recibirConsulta.getString("contrasena"));
            tabla.add(buscarUsuario);
            ejecutarConsulta.close();
            recibirConsulta.close();
        } catch (SQLException ex) {
            System.out.println("Error en Dao" + ex);
        } finally {
            this.cerrarConex();
        }
        return tabla;
    }

    public ArrayList<Usuario> buscarTodosUsuarios() {
        ArrayList<Usuario> tabla = new ArrayList();

        try {
            this.conectar();
            codigoSql = "SELECT * FROM usuario";
            ejecutarConsulta = getMiconexion().prepareStatement(codigoSql);
            recibirConsulta = ejecutarConsulta.executeQuery();
            while (recibirConsulta.next()) {
                Usuario consulta = new Usuario();
                consulta.setId(recibirConsulta.getInt("id"));
                consulta.setNombre(recibirConsulta.getString("nombre"));
                consulta.setUsuario(recibirConsulta.getString("usuario"));
                consulta.setContraseña(recibirConsulta.getString("contrasena"));
                tabla.add(consulta);
            }

            ejecutarConsulta.close();
            recibirConsulta.close();
        } catch (SQLException ex) {
            System.out.println("Error en Dao" + ex);
        } finally {
            this.cerrarConex();
        }
        return tabla;
    }

    public String iniciarSesion(Usuario datosUsuario) {
        this.respuesta = null;

        try {
            this.conectar(); // abrir conexion
            codigoSql = "SELECT * FROM usuario WHERE usuario=? and contrasena=MD5(?)";
            ejecutarConsulta = this.getMiconexion().prepareStatement(codigoSql);
            ejecutarConsulta.setString(1, datosUsuario.getUsuario()); //El numero indica que signo de interrogacion del codigoSql es
            ejecutarConsulta.setString(2, datosUsuario.getContraseña());
            recibirConsulta = ejecutarConsulta.executeQuery();

            if (recibirConsulta.next()) {
                respuesta = "1";
            } else {
                respuesta = "0";
            }
            ejecutarConsulta.close();
            recibirConsulta.close();
        } catch (SQLException ex) {
            System.out.println("Error:" + ex);
        } finally { // este codigo se ejecuta siempre
            this.cerrarConex(); // cerrar conexion 
        }
        return respuesta;
    }
}
