
package com.ventas.bean;

import com.ventas.dao.PersonaDAO;
import com.ventas.dao.modelo.Persona;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PersonaBean {
    
    private Persona persona= new Persona();
    private List<Persona> lstPersonas;

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void registrar() throws Exception{
        PersonaDAO dao;
        try {
            dao= new PersonaDAO();
            dao.registrar(persona);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listar() throws Exception{
        PersonaDAO dao;
        try {
            dao= new PersonaDAO();
            lstPersonas=dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
}
