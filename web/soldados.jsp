<%@page import="java.util.ArrayList"%>
<%@page import="datos.ControladorBD"%>
<%@page import="modelo.Soldado"%>
<%@page import="modelo.OficinaImperial"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>DSM - Monitoreo Imperial</title>
        <link rel="icon" type="image/png" href="img/favicon.png">
        <style>
            body {
                background-color: #0a0a0a;
                color: #d8d8d8;
                font-family: 'Courier New', Courier, monospace;
                margin: 0;
                padding: 20px;
            }

            h1 {
                color: #ff1e1e;
                text-align: center;
                text-transform: uppercase;
                letter-spacing: 4px;
                border-bottom: 2px solid #ff1e1e;
                padding-bottom: 15px;
                margin-bottom: 30px;
                text-shadow: 0 0 10px rgba(255, 30, 30, 0.5);
            }

            h2 {
                color: #ff3333;
                text-transform: uppercase;
                letter-spacing: 2px;
                font-size: 16px;
                margin-top: 0;
                border-bottom: 1px solid #331111;
                padding-bottom: 5px;
            }

            /* Contenedor tipo Dashboard (Lado a Lado) */
            .dashboard {
                display: flex;
                gap: 25px;
                flex-wrap: wrap;
            }

            .col-izquierda {
                flex: 2;
                min-width: 600px;
            }

            .col-derecha {
                flex: 1;
                min-width: 350px;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                background-color: #111111;
                margin-bottom: 30px;
                border: 1px solid #222;
            }

            th {
                background-color: #1a0505;
                color: #ff4444;
                padding: 12px;
                border: 1px solid #331111;
                text-transform: uppercase;
                font-size: 13px;
            }

            td {
                padding: 12px;
                border: 1px solid #222;
                text-align: center;
                font-size: 14px;
            }

            tr:hover {
                background-color: #161616;
            }

            .estado-activo {
                color: #00ffcc;
                font-weight: bold;
                text-shadow: 0 0 5px rgba(0,255,204,0.4);
            }
            .estado-retirado {
                color: #aaaaaa;
            }
            .estado-desertor {
                color: #ff3333;
                font-weight: bold;
                text-shadow: 0 0 8px #ff0000;
            }

            /* Caja de Reportes - Terminal del Volcado de Memoria */
            .terminal-box {
                background-color: #030303;
                border: 1px dashed #00ff00;
                padding: 20px;
                color: #00ff00;
                margin-bottom: 30px;
                box-shadow: inset 0 0 15px rgba(0, 255, 0, 0.15);
                font-size: 13px;
                line-height: 1.6;
            }
            .terminal-box p {
                margin: 6px 0;
            }
            .terminal-box strong {
                color: #ffffff;
            }
            .terminal-titulo {
                color: #888;
                font-size: 11px;
                margin-bottom: 10px;
                display: block;
            }

            .card-form {
                background-color: #111111;
                border: 1px solid #ff3333;
                padding: 20px;
                margin-bottom: 25px;
                box-shadow: 0 0 10px rgba(255, 51, 51, 0.05);
            }

            input[type="text"], input[type="number"], select {
                background-color: #1a1a1a;
                border: 1px solid #444;
                color: #ffffff;
                padding: 8px 12px;
                font-family: 'Courier New', monospace;
                width: 100%;
                box-sizing: border-box;
                margin-top: 5px;
                margin-bottom: 15px;
            }

            input[type="text"]:focus, input[type="number"]:focus, select:focus {
                outline: none;
                border-color: #ff3333;
                box-shadow: 0 0 5px rgba(255, 51, 51, 0.5);
            }

            /* Botones estilo Emmanuel */
            input[type="submit"] {
                background-color: transparent;
                border: 1px solid #ff3333;
                color: #ff3333;
                padding: 10px 20px;
                cursor: pointer;
                font-family: 'Courier New', monospace;
                text-transform: uppercase;
                font-weight: bold;
                width: 100%;
                transition: all 0.3s ease;
            }

            input[type="submit"]:hover {
                background-color: #ff3333;
                color: #000000;
                box-shadow: 0 0 12px #ff3333;
            }

            .btn-baja {
                border-color: #ff3333 !important;
                color: #ff3333 !important;
            }

            .btn-regresar {
                display: inline-block;
                background-color: transparent;
                border: 1px solid #00ffcc; /* Cian imperial */
                color: #00ffcc;
                padding: 8px 15px;
                text-decoration: none;
                font-family: 'Courier New', Courier, monospace;
                text-transform: uppercase;
                font-weight: bold;
                transition: all 0.3s ease;
            }

            .btn-regresar:hover {
                background-color: #00ffcc;
                color: #0a0a0a;
                box-shadow: 0 0 10px rgba(0, 255, 204, 0.5);
            }

        </style>
    </head>
    <body>

        <h1>Monitoreo de Tropas Imperiales</h1>

        <%
            ControladorBD op = new ControladorBD();
            op.conectar();
            ArrayList<Soldado> soldados = op.consultarSoldados();
            OficinaImperial oi = new OficinaImperial();
            op.desconectar();
        %>

        <div style="margin-bottom: 20px; text-align: left;">
          <a href="index.html" class="btn-regresar">&lt;- MENÚ</a>
        </div>
        <div class="dashboard">

            <!-- COLUMNA IZQUIERDA: TABLA Y REPORTES -->
            <div class="col-izquierda">
                <h2>Registros de Guarnición</h2>
                <table>
                    <tr>
                        <th>ID Unidad</th>
                        <th>Estado Vital</th>
                        <th>Tiempo Activo</th>
                        <th>Tipo de Unidad</th>
                    </tr>
                    <%
                        for (Soldado s : soldados) {
                            // Cambiamos el color del texto según su estado en tiempo real
                            String claseEstado = "estado-retirado";
                            if (s.getEstado().equalsIgnoreCase("Activo")) {
                                claseEstado = "estado-activo";
                            } else if (s.getEstado().equalsIgnoreCase("Desertor")) {
                                claseEstado = "estado-desertor";
                            }

                            out.print("<tr>");
                            out.print("<td>" + s.getIdentificador() + "</td>");
                            out.print("<td class='" + claseEstado + "'>" + s.getEstado().toUpperCase() + "</td>");
                            out.print("<td>" + s.getTiempoActivo() + " Años</td>");
                            out.print("<td style='color:#e0e0e0;'>" + s.getTipo() + "</td>");
                            out.print("</tr>");
                        }
                    %>
                </table>

                <div class="terminal-box">
                    <span class="terminal-titulo">[INFORMACION RELEVANTE DE LAS TROPAS IMPERIALES]</span>
                    <p>> Inicializando análisis de rendimiento de las Tropas</p>
                    <p>> Unidades fuera de servicio: <strong><%= oi.calcularSoldadosInactivos(soldados)%></strong></p>
                    <p>> Promedio de subordinados a cargo (Almirantes): <strong><%= oi.promedioPersonal(soldados)%></strong></p>
                    <p>> Eficiencia de vuelo acumulada (Pilotos): <strong><%= oi.promedioVuelo(soldados)%> hrs</strong></p>
                    <p>> Registro de precisión táctica destacado: <span style="color:#00ffcc;"><%= oi.buscarSoldadoHabil(soldados)%></span></p>
                    <p>> Diagnóstico de ciclos de jubilación: <span style="color:#ffff00;"><%= oi.conocerRetiros(soldados)%></span></p>
                </div>
            </div>

            
            <div class="col-derecha">

                <div class="card-form">
                    <h2>Reclutar Unidad</h2>
                    <form action="agregarSoldado.jsp" method="post">
                        <label>Identificador:</label>
                        <input type="text" name="identificador" placeholder="ST-1138" required>

                        <label>Estado Asignado:</label>
                        <div style="color: #00ffcc; padding: 5px 0 15px 0; font-weight: bold;">ACTIVO</div>
                        <input type="hidden" name="estado" value="Activo">

                        <label>Tiempo de Servicio Inicial (Años):</label>
                        <input type="number" name="tiempoActivo" value="0" min="0" required>

                        <label>Especialización de Combate:</label>
                        <select name="tipo">
                            <option value="Stormtrooper">Stormtrooper</option>
                            <option value="Piloto">Piloto</option>
                            <option value="Almirante">Almirante</option>
                        </select>
                        <input type="submit" value="Dar de Alta">
                    </form>
                </div>

                <div class="card-form" style="border-color: #555;">
                    <h2>Actualizar Historial</h2>
                    <form action="actualizarSoldado.jsp" method="post">
                        <label>Identificador de Unidad:</label>
                        <input type="text" name="identificador" required>

                        <label>Especialización Original:</label>
                        <select name="tipo">
                            <option value="Stormtrooper">Stormtrooper</option>
                            <option value="Piloto">Piloto</option>
                            <option value="Almirante">Almirante</option>
                        </select>

                        <label>Nuevo Diagnóstico de Estado:</label>
                        <select name="estado">
                            <option value="Activo">Activo</option>
                            <option value="Retirado">Retirado</option>
                            <option value="Desertor">Desertor</option>
                        </select>

                        <label>Actualizar Años de Servicio:</label>
                        <input type="number" name="tiempoActivo" required>

                        <input type="submit" value="Modificar Registro" style="border-color: #999; color: #999;">
                    </form>
                </div>

                <div class="card-form" style="border-color: #ff3333;">
                    <h2>Remover del Servicio (Baja)</h2>
                    <form action="eliminarSoldado.jsp" method="post">
                        <label>Seleccionar Identificador de Destino:</label>
                        <select name="identificador">
                            <%
                                for (Soldado s : soldados) {
                                    out.print("<option value='" + s.getIdentificador() + "'>" + s.getIdentificador() + " (" + s.getTipo() + ")</option>");
                                }
                            %>
                        </select>
                        <input type="submit" value="TERMINAR CONTRATO" class="btn-baja">
                    </form>
                </div>

            </div>
        </div>

    </body>
</html>
