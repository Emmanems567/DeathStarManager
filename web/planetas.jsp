<%-- 
    Document   : planetas
    Created on : 17 Jul 2026, 20:35:50
    Author     : emman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="datos.ControladorBD"%>
<%@page import="modelo.Planeta"%>
<%@page import="java.util.ArrayList"%>

<%
  ControladorBD cb = new ControladorBD();
  cb.conectar();
  
  ArrayList<Planeta> planetas = cb.consultarPlanetas();

  double porcentaje = cb.calcularPorcentajeDestruccion();
  long bajas = cb.calcularBajasTotales();
  Planeta mayorValor = cb.obtenerPlanetaMayorValor();
  double promedioDiametro = cb.calcularPromedioDiametro();
  int bordeExterior = cb.contarPlanetasSector("Borde Exterior");

  cb.desconectar();
%>

<!DOCTYPE html>
<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css">
      <link rel="icon" type="image/png" href="img/favicon.png">
      <title>DSM - Monitoreo Planetario</title>
    </head>
    <body>
      <h1>Módulo de control: Objetivos Planetarios</h1> 
      <div class="layout-principal">
      <div class="columna-izquierda">

        <div class="panel-estadisticas">
          <span>Destrucción: <span class="stat-valor"><%= String.format("%.1f", porcentaje) %>%</span></span>
          <span>Bajas: <span class="stat-valor"><%= bajas %></span></span>
          <span>Objetivo Prioritario: <span class="stat-valor"><%= (mayorValor != null) ? mayorValor.getNombre() : "N/A" %></span></span>
          <span>Diámetro prom: <span class="stat-valor"><%= String.format("%.1f", promedioDiametro) %> km</span></span>         
          <span>Borde Exterior: <span class="stat-valor"><%= bordeExterior %> planetas</span></span>
        </div>

        <div class="panel-control">
          <span style="color: #555; letter-spacing: 1px;">SUPERLASER: <span style="color: #00ffff;">EN ESPERA</span></span> 
          <div style="display: flex; gap: 15px;">
            <a href="index.html" class="btn-principal btn-secundario"><- Menu</a>
            <a href="formularioAgregarPlaneta.jsp" class="btn-principal">Añadir nuevo objetivo</a>
          </div>
        </div>

        <div class="tabla-contenedor">
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Sector</th>
                <th>Población</th>
                <th>Diámetro</th>
                <th>Riqueza</th>
                <th>Estado</th>
                <th>Acciones</th>
              </tr>
            </thead>
            <tbody>
              <%
              for (Planeta p : planetas) {
                
                String claseEstado = p.isDestruido() ? "status-destruido" : "status-intacto";
                String textoEstado = p.isDestruido() ? "DESTRUIDO" : "INTACTO";
              %>
              <tr>
                <td class="<%= claseEstado %>"><%= p.getId() %></td>
                <td class="<%= claseEstado %>"><%= p.getNombre() %></td>
                <td class="<%= claseEstado %>"><%= p.getSector() %></td>
                <td class="<%= claseEstado %>"><%= p.getPoblacion() %></td>
                <td class="<%= claseEstado %>"><%= p.getDiametro() %></td>
                <td class="<%= claseEstado %>"><%= p.getNivelRecursos() %></td>
                <td class="<%= claseEstado %>"><%= textoEstado %></td>
                <td class="acciones">
                  <a href="formularioEditarPlaneta.jsp?id=<%= p.getId() %>" class="btn-principal btn-secundario btn-tabla">Editar</a>
                  <% if (!p.isDestruido()) { %>
                  <a href="destruirPlaneta.jsp?id=<%= p.getId() %>" class="btn-principal btn-tabla">Destruir</a>
                  <% } else { %>
                  <span class="btn-principal btn-tabla" style="border-color: #333; color: #444; cursor: not-allowed;">Destruir</span>
                  <% } %>
                  <a href="eliminarPlaneta.jsp?id=<%= p.getId() %>" class="btn-principal btn-tabla">Borrar</a>
                </td>
              </tr>
              <%
                }
              %>
            </tbody>
          </table>
        </div>
      </div>
      
      <div class="columna-derecha">
        <h4 class="terminal-header">[TERMINAL]</h4>
        <div class="terminal-body">
          <p class="linea-terminal" style="color: #555;">> Inicializando volcado de memoria...</p> 
          <%
          for (Planeta p : planetas) {
            out.print("<p class='linea-terminal'>> " + p.toString() + "</p>");
          }
          %>
          <p class="linea-terminal" style="color: #555; animation: blink 1s infinite;">_</p>
        </div>
      </div>

      </div>

    </body>
</html>
