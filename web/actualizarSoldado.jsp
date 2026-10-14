<%-- 
    Document   : actualizarSoldado
    Created on : 19 jul 2026, 1:05:57 a.m.
    Author     : Usuario
--%>

<%@page import="modelo.Almirante"%>
<%@page import="modelo.Piloto"%>
<%@page import="modelo.Stormtrooper"%>
<%@page import="modelo.Soldado"%>
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
            ControladorBD actualizar = new ControladorBD();
            actualizar.conectar();

            String identificador = request.getParameter("identificador");
            String estado = request.getParameter("estado");
            int tiempoActivo = Integer.parseInt(request.getParameter("tiempoActivo"));
            String tipo = request.getParameter("tipo");

            Soldado soldado = null;

            if (tipo.equalsIgnoreCase("Stormtrooper")) {
                soldado = new Stormtrooper(identificador, estado, tiempoActivo, tipo, 5.0);
            } else if (tipo.equalsIgnoreCase("Piloto")) {
                soldado = new Piloto(identificador, estado, tiempoActivo, tipo, 0.0);
            } else if (tipo.equalsIgnoreCase("Almirante")) {
                soldado = new Almirante(identificador, estado, tiempoActivo, tipo, 0);
            }

            if (soldado != null) {
                actualizar.actualizarSoldados(soldado);
            }

            actualizar.desconectar();
            response.sendRedirect("soldados.jsp");
        %>
    </body>
</html>
