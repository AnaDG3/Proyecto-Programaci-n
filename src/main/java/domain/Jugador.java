package domain;
import Excepciones.JugadorException;

public class Jugador {

    //creamos un array de objetos para que sea el inventario del jugador.
    private Objeto[] inventario;
    private int objetosActuales; //esto nos servirá para saber cuántos objetos hay en el inventario, y,
    // por lo tanto, podremos saber si el inventario está lleno o no a la hora de coger un objeto

    public Jugador(int capacidad) {
        //el constructor de Jugador acepta un entero capacidad para poder crear un inventario
        //con la capacidad deseada
        inventario = new Objeto[capacidad];
        objetosActuales = 0; //porque cuando el juego inicie no tendrá ningún objeto en el inventario
    }

    public void coger(Objeto objeto) throws JugadorException {
        //con este método podremos añadir nuevos objetos al inventario
        if (!(objeto instanceof Inventariable)) { //con este if se gestiona si el objeto no es inventariable,
            //es decir, si no se puede añadir al inventario. En ese caso, no podrá añadirlo y lanzará
            // una excepción para indicarle al jugador que no se puede coger.
            throw new JugadorException("Este objeto no se puede coger");
        }

        if (objetosActuales >= inventario.length) {
            //si el inventario no tiene la capacidad para añadir un nuevo objeto, lanzará una excepción
            throw new JugadorException("El inventario está lleno. Deja un objeto para poder coger el nuevo objeto.");
        }
        //si no se da el caso de que entre en el bucle if creado anteriormente, se añadirá el objeto al inventario.
        inventario[objetosActuales++] = objeto;
    }

    public Objeto[] getInventario() {
        return inventario;
    }

    public boolean eliminarObjeto(Objeto objeto) {
        //esto nos servirá si el jugador quiere dejar un objeto. Con este método
        // podremos eliminar ese objeto del inventario
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] == objeto) {
                inventario[i] = null;
                return true;
                //si el método devuelve true, significará que ha encontrado el objeto y lo
                // ha eliminado
            }
        }
        return false;
        //si devuelve false, entonces significaría que no ha encontrado el objeto, y,
        // por lo tanto, no lo ha podido eliminar.
    }
}
