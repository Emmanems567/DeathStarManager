<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css">
        <link rel="icon" type="image/png" href="img/favicon.png">
        <title>DSM - Ingresar Nuevo Objetivo</title>
    </head>

    <body>
        <h1>DSM - Registrar nuevo objetivo planetario</h1>
        <%
        String error = request.getParameter("error");
        if (error != null && error.equals("id")) {
        %>
        <div style="background-color: #1a0505; color: #ff3333; border: 1px dashed #ff3333; padding: 15px; margin-bottom: 20px; text-align: center; font-weight: bold; font-family: 'Courier New', monospace;">
          [ERROR DEL SISTEMA]: El ID especificado ya existe en el registro de Objetivos Planetarios.
        </div>
        <%
          }
        %>

        <form action="agregarPlaneta.jsp" method="post" class="formulario">
          
          <div class="form-grupo">
            <label for="id">ID (Registro Galáctico):</label>
            <input type="number" id="id" name="id" required>
          </div>

          <div class="form-grupo">
            <label for="nombre">Nombre del planeta:</label>
            <input type="text" id="nombre" name="nombre" required>
          </div>

          <div class="form-grupo">
            <label for="sector">Sector galáctico:</label>
            <input type="text" id="sector" name="sector" required>
          </div>

          <div class="form-grupo">
            <label for="poblacion">Censo poblacional:</label>
            <input type="number" id="poblacion" name="poblacion" required>
          </div>

          <div class="form-grupo">
            <label for="diametro">Diámetro(km):</label>
            <input type="number" step="0.1" id="diametro" name="diametro" required>
          </div>

          <div class="form-grupo">
            <label for="nivel_recursos">Nivel de riqueza(1-10):</label>
            <input type="number" id="nivel_recursos" name="nivel_recursos" min="1" max="10" required>
          </div>

          <div class="form-grupo">
            <label for="destruido">Estado inicial del planeta:</label>
            <select id="destruido" name="destruido">
              <option value="false">Intacto / Operacional</option>
              <option value="true">Destruido / Eliminado</option>
            </select>
          </div>

          <div class="botones-form">
            <a href="planetas.jsp" class="btn-principal btn-secundario">Abortar operación</a> 
            <button type="submit" class="btn-principal">Fijar objetivo</button>
          </div>
        </form>
    
    </body>
</html>
