/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase que simula un almirante de la orden imperial
 * Hereda de la clase soldado y almacena la cantidad de personas a su cargo
 * @author Emmanuel, Ricardo, Daniel
 * @version 2.0
 * @see Soldado
 */
public class Almirante extends Soldado {

    private int personalCargo;
    
    /**
     * Constructor por defecto, no recibe parametros y su funcion es incializar un objeto con valores predeterminados
     */
    public Almirante() {
    }
    
    /**
    * Constructor por parametros, permite inicializar y darle una etiqueta a los atributos
     * @param id identificadr de un soldado
     * @param estado determina si el soldado esta activo, retirado o deserto
     * @param tiempoActivo el tiempo que lleva el soldado en servicio
     * @param tipo categoria a la que pertenece el soldado, en este caso Almirante
     * @param personalCargo cantidad de personas a su cargo
     */
    public Almirante(String id, String estado, int tiempoActivo, String tipo, int personalCargo) {
        super(id, estado, tiempoActivo, tipo);
        this.personalCargo = personalCargo;
    }
    
    /**
     * Metodo toString, permite mostrar el objeto en fomrma de texto
     * @return devuelve el objeto en forma de texto
     */
    @Override
    public String toString() {
        String almirante = "Almirante: " + super.toString() + "/" + this.personalCargo;
        return almirante;
    }
    
    /**
     * Metood que permite leer la cantidad de perminal a su cargo
     * @return el dato de personas a cargo
     */
    public int getPersonalCargo() {
        return personalCargo;
    }
    
    /**
     * Metodo que permite escribir en la cantidad de personas a cargo del Almirante
     * @param personalCargo el nuevo valor de las personas a su cargo
     */
    public void setPersonalCargo(int personalCargo) {
        this.personalCargo = personalCargo;
    }

    /**
     * Metodo heredaro de la clase padre, permite determinar si el soldado es candidato a retiro
     * Para los Almirantes, debe ser 20 o mas años activos
     * @return si el soldado es candidato (true) o no (false) a retiro
     */
    @Override
    public boolean retirarse() {
        return getTiempoActivo() >= 20;
    }

}
