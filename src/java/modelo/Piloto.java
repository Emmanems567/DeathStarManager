/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase que simula un piloto imperial, hereda de la clase padre y almancena la cantidad de horas de vuelo
 * @author Emmanuel, Ricardo, Daniel
 * @version 2.0
 * @see Soldado
 */
public class Piloto extends Soldado {

    private double horasVuelo;
    
    /**
     * Constructor por defecto, no recibe parametros y su funcion es incializar un objeto con valores predeterminados
     */
    public Piloto() {
    }
    
    /**
     * Constructor por parametros, permite inicializar y darle una etiqueta a los atributos
     * @param id identificadr de un soldado
     * @param estado determina si el soldado esta activo, retirado o deserto
     * @param tiempoActivo el tiempo que lleva el soldado en servicio
     * @param tipo categoria a la que pertenece el soldado, en este caso Piloto
     * @param horasVuelo cantidad de horas de vuelo del Soldado
     */
    public Piloto(String id, String estado, int tiempoActivo, String tipo, double horasVuelo) {
        super(id, estado, tiempoActivo, tipo);
        this.horasVuelo = horasVuelo;
    }
    
    /**
     * Metodo toString, permite mostrar el objeto en fomrma de texto
     * @return el objeto en forma de texto
     */
    @Override
    public String toString() {
        String piloto = "Piloto: " + super.toString() + "/" + this.horasVuelo;
        return piloto;
    }
    
    /**
     * Metood que permite leer las horas en vuelo
     * @return la cantidad de horas de vuelo del soldado
     */
    public double getHorasVuelo() {
        return horasVuelo;
    }
    
    /**
     * Metodo que permite escribir en las horas de vuelo
     * @param horasVuelo la nueva cantidad de horas de vuelo
     */
    public void setHorasVuelo(double horasVuelo) {
        this.horasVuelo = horasVuelo;
    }
    
    /**
     * Metodo heredaro de la clase padre, permite determinar si el soldado es candidato a retiro
     * Para los Pilotos, debe tener 10 años o mas activos
     * @return si el soldado es candidato (true) o no (false) a retiro
     */
    @Override
    public boolean retirarse() {
        return getTiempoActivo() >= 10;
    }

}
