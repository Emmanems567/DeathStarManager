/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.*;
import java.util.ArrayList;
import modelo.Planeta;
import modelo.Almirante;
import modelo.Piloto;
import modelo.Soldado;
import modelo.Stormtrooper;

/**
 * Clase que se encarga de gestionar la conexion con la base de datos
 * Permitiendo consultar, actualizar y eliminar en la base de datos relacionado con los soldados
 * @author Emmanuel, Ricardo, Daniel
 * @version 2.0
 */
public class ControladorBD {

  private static final String USER = "root";
  private static final String PSWD = "1234";
  private static final String URL = "jdbc:mysql://localhost:3306/";
  private static final String BD = "deathStar";
  private Connection conexion;

  /**
   * Metodo que permite conectarnos a la base de datos
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html"> Clase Connection de java </a>
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/sql/DriverManager.html"> Clase DriveManager de java </a>
   * @return el estado de la conexión
   */
  public boolean conectar() {

    boolean estado = true;

    try {

      Class.forName("com.mysql.cj.jdbc.Driver");
      conexion = DriverManager.getConnection(URL + BD, USER, PSWD);

      if (conexion != null) {

        estado = true;
        System.out.println("conectado");
      }
    } catch (ClassNotFoundException e) {

      System.getLogger(ControladorBD.class.getName())
          .log(System.Logger.Level.ERROR, (String) null, e);
    } catch (SQLException e) {

      System.getLogger(ControladorBD.class.getName())
          .log(System.Logger.Level.ERROR, (String) null, e);
    }

    return estado;
  }

  /**
   * Metodo que permite anula la conexión con la base de datos
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html"> Clase Connection de java </a>
   * @return el estado si se encuentra desconectado
   */
  public boolean desconectar() {

    boolean estado = true;

    try {

      conexion.close();
      estado = true;
    } catch (SQLException e) {

      System.getLogger(ControladorBD.class.getName())
          .log(System.Logger.Level.ERROR, (String) null, e);
    }

    return estado;
  }

  /**
   * Método que consulta todas las entradas en la tabla de planetas de la base de datos
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Clase ArrayList</a>
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html"> Clase Statement</a>
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html"> Clase ResultSet</a>
   * @return Un ArrayList que contiene objetos de tipo Planeta
   */
  public ArrayList<Planeta> consultarPlanetas() {

    ArrayList<Planeta> planetas = new ArrayList<>();
    Statement st;

    try {
      st = conexion.createStatement();
      String query = "SELECT * FROM planetas";
      ResultSet rs = st.executeQuery(query);

      while (rs.next()) {

        Planeta planeta = new Planeta();
        int valorDestruido = rs.getInt("destruido");
        boolean estado = (valorDestruido == 1);

        planeta.setId(rs.getInt("id"));
        planeta.setNombre(rs.getString("nombre"));
        planeta.setSector(rs.getString("sector"));
        planeta.setPoblacion(rs.getLong("poblacion"));
        planeta.setDiametro(rs.getDouble("diametro"));
        planeta.setNivelRecursos(rs.getInt("nivel_recursos"));
        planeta.setDestruido(estado);

        planetas.add(planeta);
      }
    } catch (SQLException e) {
      System.getLogger(ControladorBD.class.getName())
          .log(System.Logger.Level.ERROR, (String) null, e);
    }

    return planetas;
  }

  /**
   * Método que permite insertar un nuevo objeto de tipo Planeta a la tabla de planetas
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html"> Clase PreparedStatement</a>
   * @param planeta Objeto de tipo Planeta
   * @return estado de la conexión
   */
  public boolean agregarPlaneta(Planeta planeta) {

    boolean estado = false;
    String query = "INSERT INTO planetas VALUES (?, ?, ?, ?, ?, ?, ?)";

    try {

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setInt(1, planeta.getId());
      ps.setString(2, planeta.getNombre());
      ps.setString(3, planeta.getSector());
      ps.setLong(4, planeta.getPoblacion());
      ps.setDouble(5, planeta.getDiametro());
      ps.setInt(6, planeta.getNivelRecursos());

      int valorDestruido = planeta.isDestruido() ? 1 : 0;
      ps.setInt(7, valorDestruido);

      int resultado = ps.executeUpdate();

      if (resultado > 0) {
        estado = true;
      }
    } catch (SQLException e) {
      System.getLogger(ControladorBD.class.getName())
          .log(System.Logger.Level.ERROR, (String) null, e);
    }

    return estado;
  }

  /**
   * Método que permite eliminar un objeto de tipo Planeta en la tabla de planetas
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html"> Clase Statement</a>
   * @param id entero que contiene el id del planeta a borrar
   * @return estado de la conexión
   */
  public boolean eliminarPlaneta(int id) {

    boolean estado = true;
    Statement st;

    try {

      st = conexion.createStatement();
      String query = "DELETE FROM planetas WHERE id = " + id;

      st.executeUpdate(query);
    } catch (SQLException e) {
      System.getLogger(ControladorBD.class.getName())
          .log(System.Logger.Level.ERROR, (String) null, e);
    }

    return estado;
  }

  /**
   * Método que permite edita un objeto de tipo Planeta en la tabla de planetas
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html">Clase PreparedStatement</a>
   * @param planeta Objeto de tipo Planeta
   * @return estado de la conexión
   */
  public boolean actualizarPlaneta(Planeta planeta) {
    boolean estado = true;

    String query =
        "UPDATE planetas SET nombre = ?, sector = ?, poblacion = ?, diametro = ?, nivel_recursos ="
            + " ?, destruido = ? WHERE id = ?";

    try {

      PreparedStatement ps = conexion.prepareStatement(query);

      ps.setString(1, planeta.getNombre());
      ps.setString(2, planeta.getSector());
      ps.setLong(3, planeta.getPoblacion());
      ps.setDouble(4, planeta.getDiametro());
      ps.setInt(5, planeta.getNivelRecursos());

      int valorDestruido = planeta.isDestruido() ? 1 : 0;
      ps.setInt(6, valorDestruido);

      ps.setInt(7, planeta.getId());

      ps.executeUpdate();
    } catch (SQLException e) {
      System.getLogger(ControladorBD.class.getName())
          .log(System.Logger.Level.ERROR, (String) null, e);
    }

    return estado;
  }

   /**
   * Método que permite calcular la suma de bajas totales de todos los planetas destruidos con operaciones SQL
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html">Clase Statement</a>
   * @return valor de tipo Long con la cantidad de bajas totales
   */
  public long calcularBajasTotales() {

    long bajasTotales = 0;
    Statement st;
    String query = "SELECT SUM(poblacion) AS total_bajas FROM planetas WHERE destruido = 1";

    try {

      st = conexion.createStatement();
      ResultSet rs = st.executeQuery(query);

      if (rs.next()) {
        bajasTotales = rs.getLong("total_bajas");
      }
    } catch (SQLException e) {
      System.getLogger(ControladorBD.class.getName())
          .log(System.Logger.Level.ERROR, (String) null, e);
    }

    return bajasTotales;
  }

   /**
   * Método que permite calcular el diámetro promedio de todos los planetas de la base de datos con operaciones SQL
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html">Clase Statement</a>
   * @return valor de tipo Double con el diámetro promedio
   */
  public double calcularPromedioDiametro() {

    double promedio = 0.0;
    Statement st;
    String query = "SELECT AVG(diametro) AS promedio_diametro FROM planetas";

    try {

      st = conexion.createStatement();
      ResultSet rs = st.executeQuery(query);

      if (rs.next()) {
        promedio = rs.getDouble("promedio_diametro");
      }
    } catch (SQLException e) {
      System.getLogger(ControladorBD.class.getName())
          .log(System.Logger.Level.ERROR, (String) null, e);
    }
    return promedio;
  }

   /**
   * Método que permite calcular el porcentaje de planetas destruidos en la base de datos con operaciones SQL
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html">Clase Statement</a>
   * @return valor de tipo Double con el valor del porcentaje de destrucción
   */
  public double calcularPorcentajeDestruccion() {

    double porcentaje = 0.0;
    Statement st;
    String query =
        "SELECT IFNULL((SUM(destruido) * 100.0) / NULLIF(COUNT(*), 0), 0) AS porcentaje FROM"
            + " planetas";

    try {

      st = conexion.createStatement();
      ResultSet rs = st.executeQuery(query);

      if (rs.next()) {
        porcentaje = rs.getDouble("porcentaje");
      }
    } catch (SQLException e) {
      System.getLogger(ControladorBD.class.getName())
          .log(System.Logger.Level.ERROR, (String) null, e);
    }

    return porcentaje;
  }

   /**
   * Método que obtiene el planeta con mayor riqueza de recursos en la base de datos con una consulta SQL
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html">Clase Statement</a>
   * @return Objeto de tipo Planeta
   */
  public Planeta obtenerPlanetaMayorValor() {

    Planeta planeta = null;
    Statement st;
    String query =
        "SELECT * FROM planetas WHERE destruido = 0 ORDER BY nivel_recursos DESC LIMIT 1";

    try {

      st = conexion.createStatement();
      ResultSet rs = st.executeQuery(query);

      if (rs.next()) {

        planeta = new Planeta();
        planeta.setId(rs.getInt("id"));
        planeta.setNombre(rs.getString("nombre"));
        planeta.setSector(rs.getString("sector"));
        planeta.setPoblacion(rs.getLong("poblacion"));
        planeta.setDiametro(rs.getDouble("diametro"));
        planeta.setNivelRecursos(rs.getInt("nivel_recursos"));
        planeta.setDestruido(false);
      }
    } catch (SQLException e) {
      System.getLogger(ControladorBD.class.getName())
          .log(System.Logger.Level.ERROR, (String) null, e);
    }
    return planeta;
  }

  /**
   * Método que cuenta los planetas que existen en un sector dado
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html">Clase PreparedStatement</a>
   * @param sector String que contiene el sector
   * @return Valor de tipo Int con el total de planetas en un sector
   */
  public int contarPlanetasSector(String sector) {

    int total = 0;
    String query = "SELECT COUNT(*) AS total FROM planetas WHERE sector = ?";

    try {

      PreparedStatement ps = conexion.prepareStatement(query);
      ps.setString(1, sector);

      ResultSet rs = ps.executeQuery();

      if (rs.next()) {

        total = rs.getInt("total");
      }
    } catch (SQLException e) {
      System.getLogger(ControladorBD.class.getName())
          .log(System.Logger.Level.ERROR, (String) null, e);
    }

    return total;
  }

  /**
   * Método que obtiene un planeta con un id específico
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html">Clase PreparedStatement</a>
   * @param id entero con el valor del id del planeta a buscar
   * @return Objeto de tipo Planeta
   */
  public Planeta obtenerPlanetaId(int id) {

    Planeta planeta = null;
    String query = "SELECT * FROM planetas WHERE id = ?";

    try {

      PreparedStatement ps = conexion.prepareStatement(query);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {

        planeta = new Planeta();
        planeta.setId(rs.getInt("id"));
        planeta.setNombre(rs.getString("nombre"));
        planeta.setSector(rs.getString("sector"));
        planeta.setPoblacion(rs.getLong("poblacion"));
        planeta.setDiametro(rs.getDouble("diametro"));
        planeta.setNivelRecursos(rs.getInt("nivel_recursos"));
        planeta.setDestruido(rs.getInt("destruido") == 1);
      }
    } catch (SQLException e) {
      System.getLogger(ControladorBD.class.getName())
          .log(System.Logger.Level.ERROR, (String) null, e);
    }

    return planeta;
  }

  /**
   * Método que cambia el estado de un planeta de intacto a destruido
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html">Clase PreparedStatement</a>
   * @param id entero con el valo del id del planeta a destruir
   * @return estado de la conexión
   */
  public boolean destruirPlaneta(int id) {

    boolean estado = true;
    String query = "UPDATE planetas SET destruido = 1 WHERE id = ?";

    try {

      PreparedStatement ps = conexion.prepareStatement(query);
      ps.setInt(1, id);
      ps.executeUpdate();
    } catch (SQLException e) {
      System.getLogger(ControladorBD.class.getName())
          .log(System.Logger.Level.ERROR, (String) null, e);
    }

    return estado;
  }

  /**
   * Metodo que permite consultar los soldados en la base de datos
   *
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Clase
   *     ArrayList de java </a>
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html"> Clase
   *     Statement de java </a>
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html"> Clase
   *     ResultSet de java </a>
   * @return
   */
  public ArrayList<Soldado> consultarSoldados() {
    ArrayList<Soldado> soldados = new ArrayList<>();
    Statement sentenciaSQL;
    ResultSet rs;

    try {
      sentenciaSQL = conexion.createStatement();
      rs = sentenciaSQL.executeQuery("SELECT * FROM soldados");

      while (rs.next()) {
        if (rs.getString(4).equals("Stormtrooper")) {
          soldados.add(
              new Stormtrooper(
                  rs.getString(1),
                  rs.getString(2),
                  rs.getInt(3),
                  rs.getString(4),
                  rs.getDouble(5)));
        } else if (rs.getString(4).equals("Almirante")) {
          soldados.add(
              new Almirante(
                  rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(6)));
        } else if (rs.getString(4).equals("Piloto")) {
          soldados.add(
              new Piloto(
                  rs.getString(1),
                  rs.getString(2),
                  rs.getInt(3),
                  rs.getString(4),
                  rs.getDouble(7)));
        }
      }
    } catch (SQLException ex) {
      System.out.println("Excepcion al consultar: " + ex.getMessage());
    }

    return soldados;
  }

  /**
   * Metodo que permite agregar soldados a la base de datos
   *
   * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html">
   *     Clase PreparedStatement de java </a>
   * @param soldados soldado que se quiere agregar
   * @return el estado de la conexion
   */
  public boolean agregarSoldado(Soldado soldados) {
    boolean estado = false;
    PreparedStatement ps;
    String query = "INSERT INTO soldados VALUES(?,?,?,?,?,?,?)";

    try {
      ps = conexion.prepareStatement(query);
      ps.setString(1, soldados.getIdentificador());
      ps.setString(2, soldados.getEstado());
      ps.setInt(3, soldados.getTiempoActivo());
      ps.setString(4, soldados.getTipo());

      if (soldados.getTipo().equals("Stormtrooper")) {
        ps.setDouble(5, ((Stormtrooper) soldados).getHabilidadDisparo());
        ps.setNull(6, java.sql.Types.INTEGER);
        ps.setNull(7, java.sql.Types.DOUBLE);

      } else if (soldados.getTipo().equals("Almirante")) {
        ps.setNull(5, java.sql.Types.DOUBLE);
        ps.setInt(6, ((Almirante) soldados).getPersonalCargo());
        ps.setNull(7, java.sql.Types.DOUBLE);

      } else if (soldados.getTipo().equals("Piloto")) {
        ps.setNull(5, java.sql.Types.DOUBLE);
        ps.setNull(6, java.sql.Types.INTEGER);
        ps.setDouble(7, ((Piloto) soldados).getHorasVuelo());
      }
      ps.execute();
      estado = true;
    } catch (SQLException ex) {
      System.out.println("Excepcion del metodo agregar: " + ex.getMessage());
    }
    return estado;
  }

  /**
   * Metodo que permite eliminar datos en la base de datos
   *
   * @param identificador la llave primaria de los datos, que nos permite elimnar y no llevarnos
   *     datos repetidos
   * @return true si el estado de la conexion fue correcto
   */
  public boolean eliminarSoldados(String identificador) {
    boolean estado = false;
    Statement st;
    String query = "DELETE FROM soldados WHERE identificador='" + identificador + "'";

    try {
      st = conexion.createStatement();
      st.executeUpdate(query);
      estado = true;
    } catch (SQLException ex) {
      System.out.println("Excepcion del metodo eliminar: " + ex.getMessage());
    }

    return estado;
  }

  /**
   * Metodo que permite actualizar los datos de un soldado, con excepsion de su identificador
   *
   * @param soldados el soldado que se quiere agregar
   * @return el estado de la conexion si fue exitoso
   */
  public boolean actualizarSoldados(Soldado soldados) {
    boolean estado = false;
    PreparedStatement pt;
    String query =
        "UPDATE soldados SET estado=?, tiempoActivo=?, tipo=?, habilidadDeDisparo=?,"
            + " personalCargo=?, horasDeVuelo=? WHERE identificador = ?";

    try {
      pt = conexion.prepareStatement(query);
      pt.setString(7, soldados.getIdentificador());
      pt.setString(1, soldados.getEstado());
      pt.setInt(2, soldados.getTiempoActivo());
      pt.setString(3, soldados.getTipo());

      // Misma lógica con IFs para el método de actualización
      if (soldados.getTipo().equals("Stormtrooper")) {
        pt.setDouble(4, ((Stormtrooper) soldados).getHabilidadDisparo());
        pt.setNull(5, java.sql.Types.INTEGER);
        pt.setNull(6, java.sql.Types.DOUBLE);

      } else if (soldados.getTipo().equals("Almirante")) {
        pt.setNull(4, java.sql.Types.DOUBLE);
        pt.setInt(5, ((Almirante) soldados).getPersonalCargo());
        pt.setNull(6, java.sql.Types.DOUBLE);

      } else if (soldados.getTipo().equals("Piloto")) {
        pt.setNull(4, java.sql.Types.DOUBLE);
        pt.setNull(5, java.sql.Types.INTEGER);
        pt.setDouble(6, ((Piloto) soldados).getHorasVuelo());
      }

      pt.execute();
      estado = true;
    } catch (SQLException ex) {
      System.out.println("Excepcion captada al actualizar: " + ex.getMessage());
    }
    return estado;
  }
}
