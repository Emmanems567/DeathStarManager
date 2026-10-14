/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 * Clase que simula una oficina imperial, conformada por una serie de operaciones estadisticas para conocer a los soldados
 * @author Emmanuel, Ricardo, Daniel
 * @version 2.0
 */
public class OficinaImperial {
    
    /**
     * Metodo que permite saber la cantidad de soldados inactivos
     * Primero verificamos que la lista este vacia, en ese caso devuelve un mensaje y un 0
     * Si la lista de soldado no esta vacia, recorremos con un for-each la lista
     * Dentro del for, vamos preguntando el estado del soldado, en este caso contamos si esta retirado o es un desertor, en caso afirmativo, vamos contandolos con un contador
     * Una vez recorrida la lista, primero preguntamos si el contador es 0, de esta manera evitamos divisiones entre 0 y retornamos un 0
     * Finalmente, si hubo se encontro soldados inactivos, el se regresa la cantidad de soldados encontrados
     * @param soldados La cantidad de soldados almacenados en la base de datos
     * @return la cantidad de soldados encontrados
     */
    public int calcularSoldadosInactivos(ArrayList<Soldado> soldados){
        
        int contInactivos = 0;
        if(soldados == null || soldados.isEmpty()){
            System.out.println("No hay soldados");
            return 0;
        }
        for(Soldado unSoldado : soldados){
            if(unSoldado.getEstado().equalsIgnoreCase("Retirado") || unSoldado.getEstado().equals("Desertor")){
                contInactivos++;
            }
        }
        if (contInactivos == 0){
            return 0;
        }
        
        return contInactivos;
    }
    
    /**
     * Metodo que permite calcular el promedio de personas al mando de los Almirantes
     * Preguntamos si la lista esta vacia o no, en caso afirmativo, muestra un mensaje y devuelve un 0
     * Si se contro soldados, recorremos la lista usando un for-each, almacenandolo en una variable temporal llamada unSoldado
     * Dentro del soldado, preguntamos con ayuda de un instanceof si el soldado en turno es una instancia del Almirante
     * Esto se sabe por la instancia realizada en la base de datos. El instanceof devuelve verdadero y le decimos 
     * con ayuda de un casting, que trate el objeto como un almirante (Almirante) unSoldado
     * Posteriormente vamos almacenando y sumando la cantidad de personal a cargo y contando la cantidad de almirantes
     * Finalmente acabado el ciclo, preguntas si el contador fue igual a 0, lo que se traduce que no se encontraron almirantes y devolvemos 0
     * Si se encontraron almirantes, regresamos la division de la suma del personal a cargo entre la cantidad de almirantes
     * @see <a href="https://docs.oracle.com/javase/specs/jls/se21/html/jls-15.html#jls-15.20.2">Uso del operador Instanceof</a>
     * @see <a href="https://docs.oracle.com/javase/specs/jls/se21/html/jls-5.html">Uso del casting</a>
     * @param soldados La lista de soldados obtenida de la base de datos
     * @return el promedio de soldados que se tiene al mando de los almirantes
     */
    public double promedioPersonal(ArrayList<Soldado> soldados){
        double promedioP = 0;
        int cont = 0;
        if(soldados == null || soldados.isEmpty()){
            System.out.println("No hay soldados");
            return 0;
        }
        for (Soldado unSoldado : soldados){
            if(unSoldado instanceof Almirante){
                Almirante unAlmirante = (Almirante) unSoldado;
                promedioP += unAlmirante.getPersonalCargo();
                cont ++;
            }
        }
        if (cont == 0){
            return 0;
        }
        return promedioP / cont;
    }
    
    /**
     * Metodo que calcula el promedio de horas de vuelo de los pilotos imperiales
     * Preguntamos si la lista esta vacia o no, en caso afirmativo, muestra un mensaje y devuelve un 0
     * Si se contro soldados, recorremos la lista usando un for-each, almacenandolo en una variable temporal llamada unSoldado
     * Dentro del soldado, preguntamos con ayuda de un instanceof si el soldado en turno es una instancia de Piloto
     * Esto se sabe por la instancia realizada en la base de datos. El instanceof devuelve verdadero y le decimos 
     * con ayuda de un casting, que trate el objeto como un Piloto (Piloto) unSoldado
     * Posteriormente vamos almacenando y sumando la cantidad de horas de vuelo de los pilotos
     * Finalmente acabado el ciclo, preguntas si el contador fue igual a 0, lo que se traduce que no se encontraron Pilotos y devolvemos 0
     * Si se encontraron pilotos, regresamos la division de la suma del personal a cargo entre la cantidad de almirantes
     * @param soldados la cantidad de soldados obtenida de la base de datos
     * @return el promedio de horas de los soldados imperiales
     */
    public double promedioVuelo(ArrayList<Soldado> soldados){
        double vuelo = 0;
        int cont = 0;
        if(soldados == null || soldados.isEmpty()){
            System.out.println("No hay soldados");
            return 0.0;
        }
        
        for(Soldado unSoldado: soldados){
            if(unSoldado instanceof Piloto){
                Piloto piloto = (Piloto) unSoldado;
                vuelo += piloto.getHorasVuelo();
                cont++;
            }
        }
        if (cont == 0){
            return 0;
        }
        return vuelo/cont;
    }
    
    /**
     * Metodo que muestra al Stormtrooper mas habilidoso y al menos habilidoso
     * Se crearon 2 variables, masHabil y menosHabil incialmente almacenando null, de esta manera hacemos que apunte a nada por si en dado caso el primer
     * elemento de la lista no es un Stormtrooper
     * Preguntamos si la lista esta vacia o no, en caso afirmativo, retorna un mensaje avisando que no encontro soldados
     * Si se contro soldados, recorremos la lista usando un for-each, almacenandolos en una variable temporal llamada unSoldado
     * Dentro de nuestro ciclo, preguntamos si unSoldado es una instancia de Stormtrooper, con ayuda de un instanceof
     * En caso afirmativo, usamos un casting, para tratar el objeto como un Stormtrooper
     * Utilizando un if, preguntamos: primero si el soldado en turno es un stormtrooper, la condicion masHabil == null y menosHabil == null, se activa cuando encuentre un stormtrooper
     * Si lo encuentra almacena su habilidad de disparo, se sigue recorriendo el ciclo hasta terminarlo, en el proceso pregunta si el trooper en turno es mas o menos habilidoso que el almacenado
     * Finalmente preguntamos si se encontraron stormtroopers, en caso contrario devolvemos un mensaje
     * @param soldados la cantidad de soldados almacenados en la base de datos
     * @return un mensaje devolviendo el identificador el soldado y si habilidad disparando
     */
    public String buscarSoldadoHabil(ArrayList<Soldado> soldados){
        Stormtrooper masHabil = null;
        Stormtrooper menosHabil = null;
        
        if(soldados == null || soldados.isEmpty()){
            return "No hay soldados";
        }
        
        for(Soldado unSoldado: soldados){
            if(unSoldado instanceof Stormtrooper){
                Stormtrooper trooper = (Stormtrooper) unSoldado;
                
                if(masHabil == null || trooper.getHabilidadDisparo() > masHabil.getHabilidadDisparo()){
                    masHabil = trooper;
                }
                if(menosHabil == null || trooper.getHabilidadDisparo() < menosHabil.getHabilidadDisparo()){
                    menosHabil = trooper;
                }
            }
            
        }
        if(masHabil == null){
            return "No hay Stormtroopers";
        }
        
        return "El Stormtroopers mas habil es: "+masHabil.getIdentificador()+". El menos habil: "+menosHabil.getIdentificador();
    }
    
    /**
     * Metodo que permite conocer a los soldados que son candidatos a retiro
     * Preguntamos si la lista se encuentra vacia o no, en caso afirmativo, devolvemos un mensaje diciendo que no hay soldados
     * Recorremos la lista de soldados con un for-each
     * Dentro de nuestro ciclo, llamamos al metodo heredado de la clase Soldado, y preguntamos si este es verdadero, concatena en un string, el identificador del soldado y el tipo de soldado
     * asi como tambien usamos un contador, para tener un registro de los usuarios
     * Peguntamos si hubo retiros, si no hubo, retornamos un mensaje de que nadie fue apto
     * @param soldados la lista de soldados obtenida de la base de datos
     * @return un string con la cantidad de soldaos capaces de tirarse y los soldados 
     */
    public String conocerRetiros(ArrayList<Soldado> soldados){
        int retiros = 0;
        String aptos = "";
        
        if(soldados == null || soldados.isEmpty()){
            return "No hay soldados";
        }
        
        for(Soldado unSoldado : soldados){
            if (unSoldado.retirarse() && !"Retirado".equals(unSoldado.getEstado())){
                aptos += "identificador: "+unSoldado.getIdentificador()+" "+"Categoria: "+unSoldado.getTipo()+" | ";
                retiros++;
            }
        }
        if(retiros == 0){
            return "Nadie es apto :(";
        }
        
        return "El total de retiros es: "+retiros+". Y son los siguientes soldados: "+aptos;
    }
}
