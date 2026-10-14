<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="datos.ControladorBD"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Planeta</title>
    </head>
    <body>
      <%
      ControladorBD cb = new ControladorBD();
      cb.conectar();

      int id = Integer.parseInt(request.getParameter("id"));
      cb.eliminarPlaneta(id);
      cb.desconectar();
      response.sendRedirect("planetas.jsp");
      %>
    </body>
</html>
