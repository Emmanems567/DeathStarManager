<%-- 
    Document   : eliminarSoldado
    Created on : 19 jul 2026, 1:05:45 a.m.
    Author     : Usuario
--%>

<%@page import="datos.ControladorBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ControladorBD eliminar = new ControladorBD();
            eliminar.conectar();

            String identificador = request.getParameter("identificador");
            eliminar.eliminarSoldados(identificador);

            eliminar.desconectar();
            response.sendRedirect("soldados.jsp");
        %>
    </body>
</html>
