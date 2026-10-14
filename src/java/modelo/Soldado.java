/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase que simula un soldado del imperio, su funcion es heredadar a otras clases
 * Tiene identificador, estado (activo, retirado o desertor), años activos y el tipo de soldado a que pertenece
 * @author Emmanuel, Ricardo, Daniel
 * @version 2.0
 */
public abstract class Soldado {
    private String identificador;
    private String estado;
    private int tiempoActivo;
    private String tipo;
    
    /**
     * Constructor por defecto, no recibe parametros y su funcion es incializar un objeto con valores predeterminados
     */
    public Soldado(){}
    
    /**
     * Constructor por parametros, permite inicializar y darle una etiqueta a los atributos
     * @param id identificadr de un soldado
     * @param estado determina si el soldado esta activo, retirado o deserto
     * @param tiempoActivo el tiempo que lleva el soldado en servicio
     * @param tipo determina si el soldado es un stormtrooper, un piloto o almirante
     */
    public Soldado(String id, String estado, int tiempoActivo, String tipo){
        this.identificador = id;
        this.estado = estado;
        this.tiempoActivo = tiempoActivo;
        this.tipo = tipo;
    }
    
    /**
     * Metodo toString, permite mostrar el objeto en fomrma de texto
     * @return el objeto en forma de texto
     */
    @Override
    public String toString(){
        String imperio = "";
        imperio = this.identificador+"/"+this.estado+"/"+this.tiempoActivo;
        return imperio;
    }
    
    /**
     * Metodo abstracto que definira las condiciones de retiro de los soldados
     * @return si el soldado puede retirarse
     */
    public abstract boolean retirarse();
    
    /**
     * Metood que permite leer el dato almacenado en identificador
     * @return el identificador del soldado
     */
    public String getIdentificador() {
        return identificador;
    }
    
    /**
     * Metodo que permite escribir en el dato identificador
     * @param identificador el nuevo identificador del soldado
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    /**
     * Metood que permite leer el dato almacenado en estado
     * @return el estado del soldado
     */
    public String getEstado() {
        return estado;
    }
    
    /**
     * Metodo que permite escribir en el dato del estado
     * @param estado el estado actual del soldado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    /**
     * Metood que permite leer el dato almacenado en el tiempo activo
     * @return los años activos del soldado
     */
    public int getTiempoActivo() {
        return tiempoActivo;
    }
    
    /**
     * Metodo que permite escribir en el dato de timepo
     * @param tiempoActivo la nueva cantidad de años activos del soldado
     */
    public void setTiempoActivo(int tiempoActivo) {
        this.tiempoActivo = tiempoActivo;
    }
    
    /**
     * Metood que permite leer el dato almacenado en el tipo
     * @return el tipo de soldado que se esta leyendo
     */
    public String getTipo() {
        return tipo;
    }
    
    /**
     * Metodo que permite escribir en el dato tipo
     * @param tipo el tipo de soldado que se esta escribiendo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
