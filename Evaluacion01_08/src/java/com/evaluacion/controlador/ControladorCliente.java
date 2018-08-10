package com.evaluacion.controlador;

import com.evaluacion.dao.ClienteDAO;
import com.evaluacion.modelo.Cliente;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ControladorCliente {
    ClienteDAO clienteXDAO = new ClienteDAO();
    ArrayList<Cliente> recibirClientes = new ArrayList<Cliente>();
    Cliente clienteX = new Cliente();

    public Cliente getClienteX() {
        return clienteX;
    }

    public void setClienteX(Cliente clienteX) {
        this.clienteX = clienteX;
    }

    

    public ArrayList<Cliente> getRecibirClientes() {
        return recibirClientes;
    }

    public void setRecibirClientes(ArrayList<Cliente> recibirClientes) {
        this.recibirClientes = recibirClientes;
    }

    public void cargarClientes() {
        recibirClientes = clienteXDAO.buscarTodosCliente();
    }
    
    public void registrarCliente() {
        System.out.println("LLego al controlador");
        try {
            clienteXDAO.GuardarCliente(clienteX);
        } catch (Exception e) {
            System.out.println("Error"+e);
        }

    }
    
    public void eliminarCliente2(){
        try {
            clienteXDAO.EliminarCliente(clienteX);
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
    }
    
    public void buscarCodigocliente(Cliente informacionCliente){
        try {
            clienteX=clienteXDAO.buscarClientePorId2(informacionCliente);
            System.out.println("Nombre : "+informacionCliente.getNombre());
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
    }
    
    public void modificarCliente(Cliente actualizarCliente){
        try {
            clienteXDAO.ActualizarCliente(actualizarCliente);
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
        
    }
    
     private Cliente clear1(Cliente clienteNuevo) {
          clienteNuevo.setId(0);
          clienteNuevo.setNombre(null);
          clienteNuevo.setApellido(null);
          clienteNuevo.setNit(null);
          clienteX=clienteNuevo;
          return clienteX;
    }
     
     public void execute() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado", "Datos Guardados con exito."));
        clear1(clienteX);
        cargarClientes();
    }
}
