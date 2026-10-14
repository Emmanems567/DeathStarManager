/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase para crear objetos de tipo Planeta
 * @author Emmanuel
 * @version 1.0
 */
public class Planeta extends CuerpoCeleste {

  private long poblacion;
  private double diametro;
  private int nivelRecursos;
  private boolean destruido;

  /**
   * Constructor por omisión de la clase Planeta
   */
  public Planeta() {

  }

  /**
   * Constructor parametrizado de la clase Planeta
   * @param id valor inicial del id del planeta
   * @param nombre valor inicial del nombre del planeta
   * @param sector valor inicial del sector en el que se ubica el planeta
   * @param poblacion valor inicial de la población del planeta
   * @param diametro valor inicial del diámetro del planeta
   * @param nivelRecursos valor inicial del nivel de riqueza del planeta
   * @param destruido  valor inicial del estado del planeta
   */
  public Planeta(int id, String nombre, String sector, long poblacion, double diametro, int nivelRecursos, boolean destruido) {
    super(id, nombre, sector); 
    this.poblacion = poblacion;
    this.diametro = diametro;
    this.nivelRecursos = nivelRecursos;
    this. destruido = destruido;
  }

  /**
   * Método de acceso que devuelve el valor de la población
   * @return el valor de la población total del planeta
   */
  public long getPoblacion() {
      return poblacion;
  }

  /**
   * Método de acceso que devuelve el valor del diámetro del planeta
   * @return el valor del diámetro total del planeta
   */
  public double getDiametro() {
      return diametro;
  }

  /**
   * Método de acceso que devuelve el valor del nivel de riqueza del planeta
   * @return el valor del nivel de riqueza del planeta
   */
  public int getNivelRecursos() {
      return nivelRecursos;
  }

  /**
   * Método de acceso que devuelve el estado del planeta (Destruido o no destruido)
   * @return el valor del estado del planeta
   */
  public boolean isDestruido() {
      return destruido;
  }

  /**
   * Método de acceso que establece el valor de la población del planeta
   * @param poblacion valor de la población a establecer
   */
  public void setPoblacion(long poblacion) {
      this.poblacion = poblacion;
  }

  /**
   * Método de acceso que establece el valor del diámetro del planeta
   * @param diametro valor del diámetro a establecer
   */
  public void setDiametro(double diametro) {
      this.diametro = diametro;
  }

  /**
   * Método de acceso que establece el valor del nivel de riqueza del planeta
   * @param nivelRecursos valor del nivel de riqueza a establecer
   */
  public void setNivelRecursos(int nivelRecursos) {
      this.nivelRecursos = nivelRecursos;
  }

  /**
   * Método de acceso que establece el estado del planeta
   * @param destruido estado del planeta a establecer
   */
  public void setDestruido(boolean destruido) {
      this.destruido = destruido;
  }

  /**
   * Sobrescribe el método toString de la clase padre CuerpoCeleste
   * @return String con la representación del estado de un planeta
   */
  @Override
  public String toString() {
    
    String estado = destruido ? "[DESTRUIDO]" : "[OPERACIONAL]";
    return super.toString() + String.format(" | Pob: %-11d | Diam: %-7.1f | Riq: %d/10 | Est: %s", poblacion, diametro, nivelRecursos, estado);
  }
    
}
