package com.ventas.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

    private Connection cn;
    private static final String URL = "jdbc:mysql://localhost:3306/java18_ejemploventa";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public void Conectar() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("conexion Exitosa");
        } catch (Exception e) {
            throw e;
        }
    }

    public void Cerrar() throws Exception {
        try {
            if (cn != null) {
                if (cn.isClosed() == false) {
                    cn.close();
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }

}
