/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase que simula un soldado imperial conocido como Stormtrooper
 * Hereda de la clase soldado y almancena la habilidad de disparo
 * @author Emmanuel, Ricado, Daniel
 * @version 2.0
 * @see Soldado
 */
public class Stormtrooper extends Soldado {

    private double habilidadDisparo;
    
    /**
     * Constructor por defecto, no recibe parametros y su funcion es incializar un objeto con valores predeterminados
     */
    public Stormtrooper() {
    }
    
    /**
      * Constructor por parametros, permite inicializar y darle una etiqueta a los atributos
     * @param id identificadr de un soldado
     * @param estado determina si el soldado esta activo, retirado o deserto
     * @param tiempoActivo el tiempo que lleva el soldado en servicio
     * @param tipo la categoria del soldado, en este caso Stormtrooper
     * @param habilidad la habilidad de disparo del soldado
     */
    public Stormtrooper(String id, String estado, int tiempoActivo, String tipo, double habilidad) {
        super(id, estado, tiempoActivo, tipo);
        this.habilidadDisparo = habilidad;
    }
    
    /**
     * Metodo toString, permite mostrar el objeto en fomrma de texto
     * @return devuelve el objeto en forma de texto
     */
    @Override
    public String toString() {
        String soldado = "Stormtrooper: " + super.toString() + "/" + this.habilidadDisparo;
        return soldado;
    }
    
    /**
     * Metood que permite leer el dato almacenado en la habilidad del disparo
     * @return el valor de la habilidad del soldado
     */
    public double getHabilidadDisparo() {
        return habilidadDisparo;
    }
    
    /**
     * Metood que permite escribir en la habilidad del soldado
     * @param habilidadDisparo el nuevo valor de su habilidad disparando
     */
    public void setHabilidadDisparo(double habilidadDisparo) {
        this.habilidadDisparo = habilidadDisparo;
    }
    
    /**
     * Metodo heredaro de la clase padre, permite determinar si el soldado es candidato a retiro
     * Para los Stormtroopers, debe tener 15 años o mas activos
     * @return si el soldado es candidato o no a retiro
     */
    @Override
    public boolean retirarse() {
        return getTiempoActivo() >= 15;
    }


}
