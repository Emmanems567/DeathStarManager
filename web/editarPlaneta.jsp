<%-- 
    Document   : editarPlaneta
    Created on : 19 Jul 2026, 04:34:09
    Author     : emman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="datos.ControladorBD"%>
<%@page import="modelo.Planeta"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar planeta</title>
    </head>
    <body>
      <%
        ControladorBD cb = new ControladorBD();
        cb.conectar();

        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nombre");
        String sect = request.getParameter("sector");
        long pob = Long.parseLong(request.getParameter("poblacion"));
        double diam = Double.parseDouble(request.getParameter("diametro"));
        int niv = Integer.parseInt(request.getParameter("nivel_recursos"));
        boolean est = "true".equals(request.getParameter("destruido"));

        Planeta p = new Planeta(id, nom, sect, pob, diam, niv, est);
        cb.actualizarPlaneta(p);

        cb.desconectar();
        response.sendRedirect("planetas.jsp");
      %>
    </body>
</html>
