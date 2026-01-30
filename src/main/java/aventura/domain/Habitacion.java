package aventura.domain;

import Excepciones.HabitacionException;

public class Habitacion extends Entidad{
    //creamos un array de objetos que serán todos los objetos que contenga la habitación
    private Objeto[] objetosHabitacion;
    private int maxObjetos; //será la capacidad máxima de objetos que tendrá una habitación
    public Habitacion(String nombre, String descripcion){
        super(nombre, descripcion); //Llama al constructor de la clase padre
        setMaxObjetos(getMaxObjetos()); /*esto nos permite introducir el máximo de objetos
        que tendrá la habitación */
        this.objetosHabitacion = new Objeto[getMaxObjetos()];
    }

    public int getMaxObjetos() {
        return maxObjetos;
    }

    public void setMaxObjetos(int maxObjetos) {
        this.maxObjetos = maxObjetos;
    }

    public void addObjeto(Objeto objeto, Habitacion habitacion){
        //con este método podremos añadir nuevos objetos a la habitación
        boolean flag = true;
        for (int i = 0; i < habitacion.getMaxObjetos() && flag; i++) {

            if (this.objetosHabitacion[i] == null) {
                objetosHabitacion[i] = objeto;
                flag = false;
                /*si la condición del if se cumple, el objeto se añadiría a la habitación
                y luego se saldría del bucle for */
            }
        }

        if (flag) {
            //si no se pueden añadir objetos a la habitación, lanzará una excepción
            throw new HabitacionException("No es posible añadir más objetos a esta habitación.");
        }
    }
}
