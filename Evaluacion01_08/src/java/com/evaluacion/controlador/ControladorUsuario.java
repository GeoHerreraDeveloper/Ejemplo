
package com.evaluacion.controlador;

import com.evaluacion.dao.UsuarioDAO;
import com.evaluacion.modelo.Usuario;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ControladorUsuario {
    ArrayList<Usuario> recibirUsuarios= new ArrayList<Usuario>();
    Usuario usuarioX = new Usuario();

    public Usuario getUsuarioX() {
        return usuarioX;
    }

    public void setUsuarioX(Usuario usuarioX) {
        this.usuarioX = usuarioX;
    }

    
    public ArrayList<Usuario> getRecibirUsuarios() {
        return recibirUsuarios;
    }

    public void setRecibirUsuarios(ArrayList<Usuario> recibirUsuarios) {
        this.recibirUsuarios = recibirUsuarios;
    }
    
    public void cargarUsuarios(){
        UsuarioDAO usuarioXDAO = new UsuarioDAO();
        recibirUsuarios=usuarioXDAO.buscarTodosUsuarios();
    }
    
    public void registrarUsuario(){
        UsuarioDAO usuarioXDAO = new UsuarioDAO();
        try {
            usuarioXDAO.ingresarUsuario(usuarioX);
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
    }
    
    public void buscarIdUsuario (Usuario informacionUsuario){
        UsuarioDAO usuarioXDAO = new UsuarioDAO();
        try {
            usuarioX=usuarioXDAO.buscarUsuarioPorCodigo2(informacionUsuario);
            System.out.println("Nombre : "+informacionUsuario.getNombre());
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
    }
    
    public void actualizarUsuario (Usuario modificaUsuario){
        UsuarioDAO usuarioXDAO = new UsuarioDAO();
        try {
            usuarioXDAO.modificarUsuario(modificaUsuario);
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
    }
    
    public void eliminarUsuario(){
        UsuarioDAO usuarioXDAO = new UsuarioDAO();
        try {
            usuarioXDAO.eliminarUsuario(usuarioX);
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
    }
}
