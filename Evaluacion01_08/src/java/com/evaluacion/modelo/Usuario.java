/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evaluacion.modelo;

/**
 *
 * @author Usuario
 */
public class Usuario {
    // Clase entidad o Entity Class
    private int id;
    private String nombre;
    private String usuario;
    private String contraseña;

    public Usuario() {
        this.id = 0;
        this.nombre = null;
        this.usuario = null;
        this.contraseña = null;
    }

    public Usuario(int id, String nombre, String usuario, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
    
}
