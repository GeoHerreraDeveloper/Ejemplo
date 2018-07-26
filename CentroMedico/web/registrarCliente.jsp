<%-- 
    Document   : registrarCliente
    Created on : 26/07/2018, 11:31:57 AM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="ServletClienteJsp">
        CUI: <input type="text" name="cui"/> <br/>
        Primer Nombre:     <input type="text" name="pnombre"/> <br/>
        Segundo Nombre:    <input type="text" name="snombre"/> <br/>
        Primer Apellido:   <input type="text" name="papellido"/> <br/>
        Segundo Apellido:  <input type="text" name="sapellido"/> <br/>
        Genero    <input type="text" name="genero"/> <br/>
        Fecha de nacimiento <input type="date" name="fecha"/> <br/>
        Direccion <input type="text" name="direccion"/> 
        Telefono  <input type="text" name="telefono"/> 
        Email     <input type="text" name="email"/> 
        Codigo cliente: <input type="text" name="codcliente"/> <br/>
        
        <input type="submit" value="Registrar" />
        </form>
    </body>
</html>
