<%-- 
    Document   : destruirPlaneta.jsp
    Created on : 19 Jul 2026, 16:47:34
    Author     : emman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="datos.ControladorBD"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Destruir Planeta</title>
    </head>
    <body>
      <%
        ControladorBD cb = new ControladorBD(); 
        cb.conectar();

        int id = Integer.parseInt(request.getParameter("id"));
        cb.destruirPlaneta(id);

        cb.desconectar();
        response.sendRedirect("planetas.jsp");
      %>
    </body>
</html>
