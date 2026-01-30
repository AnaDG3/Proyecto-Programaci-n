package domain;

import Excepciones.HabitacionException;

public class Habitacion extends Entidad{
    private Objeto[] objetosHabitacion;
    private int maxObjetos;
    Habitacion(){
        super();
        setMaxObjetos(getMaxObjetos());
        this.objetosHabitacion = new Objeto[getMaxObjetos()];
    }

    public int getMaxObjetos() {
        return maxObjetos;
    }

    public void setMaxObjetos(int maxObjetos) {
        this.maxObjetos = maxObjetos;
    }

    public void addObjeto(Objeto objeto, Habitacion habitacion){
        boolean flag = true;
        for (int i = 0; i < habitacion.getMaxObjetos() && flag; i++) {

            if (this.objetosHabitacion[i] == null) {
                objetosHabitacion[i] = objeto;
                flag = false;
            }
        }

        if (flag) {
            throw new HabitacionException("No es posible añadir más objetos a esta habitación.");
        }
    }
}
