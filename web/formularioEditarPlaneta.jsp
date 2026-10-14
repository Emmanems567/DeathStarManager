<%-- 
    Document   : editarPlaneta
    Created on : 19 Jul 2026, 03:55:14
    Author     : emman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="datos.ControladorBD"%>
<%@page import="modelo.Planeta"%>

<%
  ControladorBD cb = new ControladorBD();
  cb.conectar();

  int id = Integer.parseInt(request.getParameter("id"));
  Planeta p = cb.obtenerPlanetaId(id);

  cb.desconectar();

  if (p == null) {
    response.sendRedirect("planetas.jsp");
    return;
  }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css">
        <link rel="icon" type="image/png" href="img/favicon.png">
        <title>DSM - Modificar objetivo</title>
    </head>
    <body>
        <h1>Modificar objetivo</h1>
        <form action="editarPlaneta.jsp" method="post" class="formulario">

          <div class="form-grupo">
            <label for="id">ID (Registro Galáctico):</label>
            <input type="number" id="id" name="id" value="<%= p.getId() %>" readonly>
          </div>

          <div class="form-grupo">
            <label for="nombre">Nombre del planeta:</label>
            <input type="text" id="nombre" name="nombre" value="<%= p.getNombre() %>" required>
          </div>

          <div class="form-grupo">
            <label for="sector">Sector galáctico:</label>
            <input type="text" id="sector" name="sector" value="<%= p.getSector() %>" required>
          </div>

          <div class="form-grupo">
            <label for="poblacion">Censo poblacional:</label>
            <input type="number" id="poblacion" name="poblacion" value="<%= p.getPoblacion() %>" required>
          </div>

          <div class="form-grupo">
            <label for="diametro">Diámetro (km):</label>
            <input type="number" id="diametro" name="diametro" value="<%= p.getDiametro() %>" required>
          </div>

          <div class="form-grupo">
            <label for="nivel_recursos">Nivel de riqueza:</label>
            <input type="number" id="nivel_recursos" name="nivel_recursos" min="1" max="10" value="<%= p.getNivelRecursos() %>"  required>
          </div>

          <div class="form-grupo">
            <label for="destruido">Estado inicial del planeta:</label>
            <select id="destruido" name="destruido">
              <option value="false" <%= !p.isDestruido() ? "selected" : "" %>>Intacto / Operacional</option>
              <option value="true" <%= p.isDestruido() ? "selected" : "" %>>Destruido / Eliminado</option>
            </select>
          </div>

          <div class="botones-form">
            <a href="planetas.jsp" class="btn-principal btn-secundario">Cancelar modificación</a>
            <button type="submit" class="btn-principal">Actualizar datos</button>
          </div>

        </form>
    </body>
</html>
