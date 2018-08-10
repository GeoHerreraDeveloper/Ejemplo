
package com.evaluacion.dao;

import com.evaluacion.modelo.Cliente;
import com.evaluacion.modelo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Pruebas {


    public static void main(String[] args) {
      Cliente clienteX = new Cliente();
      ClienteDAO clienteXDAO = new ClienteDAO();
      UsuarioDAO usuarioXDAO = new UsuarioDAO ();
      Usuario usuarioX = new Usuario ();
      ArrayList<Usuario> lista = new ArrayList();
      ArrayList<Cliente> lista2 = new ArrayList();
      
      //Prueba Ingresar usuario
      /*
      usuarioX.setId(3);
      usuarioX.setNombre("Juan");
      usuarioX.setUsuario("juanperez");
      usuarioX.setContraseña("1234");
      System.out.println(usuarioXDAO.ingresarUsuario(usuarioX));
      */
      
      //Prueba Modificar usuario
      /*
      usuarioX.setId(2);
      usuarioX.setNombre("Geovanni");
      usuarioX.setUsuario("geoherrera");
      usuarioX.setContraseña("7777");
      System.out.println(usuarioXDAO.modificarUsuario(usuarioX));
      */
      
      //Prueba Eliminar Usuario
      /*
      usuarioX.setUsuario("admin");
        System.out.println(usuarioXDAO.eliminarUsuario(usuarioX));
      */
      
      //Prueba buscar usuario por codigo
      /*
      usuarioX.setId(2);
                lista= usuarioXDAO.buscarUsuarioPorCodigo(usuarioX);
                    System.out.println("Id: "+ lista.get(0).getId());
                    System.out.println("Nombre: "+ lista.get(0).getNombre());
                    System.out.println("Usuario: "+ lista.get(0).getUsuario());
                    System.out.println("Contraseña: "+ lista.get(0).getContraseña());
               
*/
    
      //Prueba buscar usuario por nombre
      /*
      usuarioX.setNombre("Geovanni");
                lista= usuarioXDAO.buscarUsuarioPorNombre(usuarioX);
                    System.out.println("Id: "+ lista.get(0).getId());
                    System.out.println("Nombre: "+ lista.get(0).getNombre());
                    System.out.println("Usuario: "+ lista.get(0).getUsuario());
                    System.out.println("Contraseña: "+ lista.get(0).getContraseña());
      
                    */
      
    //Prueba buscar todos los usuarios
    /*
                lista= usuarioXDAO.buscarTodosUsuarios();
                    for (int i = 0; i < lista.size(); i++) {
                    System.out.println("Id: "+ lista.get(i).getId());
                    System.out.println("Nombre: "+ lista.get(i).getNombre());
                    System.out.println("Usuario: "+ lista.get(i).getUsuario());
                    System.out.println("Contraseña: "+ lista.get(i).getContraseña());
                    System.out.println("- * -");
                    }
      */          
    
                    //Prueba buscar CLIENTE por id
                 /*   
                clienteX.setId(5);
                lista2= clienteXDAO.buscarClientePorId(clienteX);
                    System.out.println("Id: "+ lista2.get(0).getId());
                    System.out.println("Nombre: "+ lista2.get(0).getNombre());
                    System.out.println("Apellido: "+ lista2.get(0).getApellido());
                    System.out.println("Nit: "+ lista2.get(0).getNit());
            */
                 
                        //Prueba buscar CLIENTE por id 2
                        /*
                Cliente recibir = new Cliente();
                clienteX.setId(4);
                recibir= clienteXDAO.buscarClientePorId2(clienteX);
                    System.out.println(recibir.toString());
                   
            
                    //Prueba buscar CLIENTE por nombre
            /*    
                clienteX.setNombre("Geovanni");
                lista2= clienteXDAO.buscarClientePorNombre(clienteX);
                    System.out.println("Id: "+ lista2.get(0).getId());
                    System.out.println("Nombre: "+ lista2.get(0).getNombre());
                    System.out.println("Apellido: "+ lista2.get(0).getApellido());
                    System.out.println("Nit: "+ lista2.get(0).getNit());
            */ 
      
                      //Prueba buscar todos los CLIENTES
    
                    lista2= clienteXDAO.buscarTodosCliente();
                    for (int i = 0; i < lista2.size(); i++) {
                    System.out.println("Id: "+ lista2.get(i).getId());
                    System.out.println("Nombre: "+ lista2.get(i).getNombre());
                    System.out.println("Apellido: "+ lista2.get(i).getApellido());
                    System.out.println("Nit: "+ lista2.get(i).getNit());
                    System.out.println("- * -");
                    }
                    for (Cliente miscliente : lista2){
                        System.out.println("id:"+miscliente.getId());
                        System.out.println("Nombre:"+miscliente.getNombre());
                        System.out.println("Apellido:"+miscliente.getApellido());
                        System.out.println("Nit:"+miscliente.getNit());
                                System.out.println("-- * --");
                    }
                    
        
}
}