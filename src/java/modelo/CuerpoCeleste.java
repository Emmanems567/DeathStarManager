/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase que permite crear objetos de tipo Cuerpo Celeste
 * @author Emmanuel
 * @version 1.0
 */
public class CuerpoCeleste {

  private int id;
  private String nombre;
  private String sector;

  /**
   * Constructor por omisión de la clase CuerpoCeleste
   */
  public CuerpoCeleste() {}

  /**
   * Constructor parametrizado de la clase CuerpoCeleste
   * @param id valor inicial del id del cuerpo
   * @param nombre valor inicial del nombre del cuerpo
   * @param sector valor inicial del sector en el que se úbica el cuerpo
   */
  public CuerpoCeleste(int id, String nombre, String sector) {

    this.id = id;
    this.nombre = nombre;
    this.sector = sector;
  }

  /**
   * Método de acceso que devuelve el valor del id del cuerpo celeste
   * @return valor del id del cuerpo celeste
   */
  public int getId() {
    return id;
  }

  /**
   * Método de acceso que devuelve el valor del nombre del cuerpo celeste
   * @return valor del nombre del cuerpo celeste
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Método de acceso que devuelve el valor del sector del cuerpo celeste
   * @return valor del sector del cuerpo celeste
   */
  public String getSector() {
    return sector;
  }
  
  /**
   * Método de acceso que establece el valor del id del cuerpo celeste
   * @param id valor del id a establecer
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Método de acceso que establece el valor del nombre del cuerpo celeste
   * @param nombre valor del nombre a establecer
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Método de acceso que establece el valor del sector del cuerpo celeste
   * @param sector valor del sector a establecer
   */
  public void setSector(String sector) {
    this.sector = sector;
  }

  /**
   * Sobrescribe el método toString() de la clase Object
   * @return String con la representación del estado del cuerpo celeste
   * @see <a href= "https://docs.oracle.com/javase/10/docs/api/java/lang/Object.html">Clase Object</a>
   */
  @Override
  public String toString() {
    return String.format("ID: %03d | Obj: %-12s | Sec: %-15s", id, nombre, sector);
  }
}
