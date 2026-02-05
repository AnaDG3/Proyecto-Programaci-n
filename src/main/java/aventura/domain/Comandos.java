package aventura.domain;




import io.MiEntradaSalida;




public class Comandos {


    public static void mirar(Habitacion habitacion) { /*con este comando, mostraremos la
       descripción de la habitación actual */
        System.out.println(habitacion.getDescripcion());
        mostrarObjetosHabitacionActual(habitacion); //le decimos los objetos que se ven
    }




    public static void cogerObjeto(Habitacion habitacion, Jugador jugador) {
        mostrarObjetosHabitacionActual(habitacion); //para indicarle al jugador los objetos disponibles
        String nombreObjeto = MiEntradaSalida.solicitarCadena("Qué Objeto deseas coger?");
        for (int i = 0; i < habitacion.getObjetosHabitacion().length; i++) {
            if (habitacion.getObjetosHabitacion()[i] != null && habitacion.getObjetosHabitacion()[i].visible && habitacion.getObjetosHabitacion()[i].getNombre().equals(nombreObjeto)) {
               /*si en la posición del array el nombre del objeto es el mismo que el que quiere el usuario,
                el objeto está visible (para evitar que introduzca sin querer un objeto que aún no se ve) y no es un espacio
                nulo en el array, entoces intentaremos añadir el objeto al inventario */
                try {
                    jugador.coger(habitacion.getObjetosHabitacion()[i]); //llamamos al método que sirve para coger un objeto
                    System.out.println("Se ha añadido al inventario.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                throw new RuntimeException("Objeto no encontrado"); /* si no entra en el bucle if, lanzaremos una excepción que
               le indique al usuario que el objeto no se ha encontrado */
            }
        }
    }




    public static void mostrarObjetosHabitacionActual(Habitacion habitacion) { /* este método nos va a permitir
   decirle al usuario los objetos que se encuentran en la habitación en donde está, excepto los que no son visibles
    y los espacios nulos del array */
        for (int i = 0; i < habitacion.getObjetosHabitacion().length; i++) {
            if (habitacion.getObjetosHabitacion()[i] != null && habitacion.getObjetosHabitacion()[i].visible) {
                System.out.println(habitacion.getObjetosHabitacion()[i].getNombre() + "\n");
            }
        }
    }


    public static void mostrarInventario(Jugador jugador) {
        /* con este método le mostraremos al jugador los objetos que tiene en el inventario, pero no los huecos nulos */
        for (int i = 0; i < jugador.getInventario().length; i++) {
            if (jugador.getInventario()[i] != null) {
                System.out.println(jugador.getInventario()[i].getNombre() + "\n");
            }
        }
    }


    public static void examinarObjeto(Habitacion habitacion, Jugador jugador) {
        System.out.println("1. Examinar objeto de la habitación.");
        System.out.println("2. Examinar objeto del inventario");
        int opcion = MiEntradaSalida.solicitarEnteroEnRango("Elige una opción", 1, 2);
        switch (opcion) {
            case 1:
                mostrarObjetosHabitacionActual(habitacion); //le mostramos los objetos de la habitación para que sepa sus opciones
                String objetoHabitacion = MiEntradaSalida.solicitarCadena("¿Qué objeto desea examinar?");
                for (int i = 0; i < habitacion.getObjetosHabitacion().length; i++) {
                    if (habitacion.getObjetosHabitacion()[i] != null && habitacion.getObjetosHabitacion()[i].visible && habitacion.getObjetosHabitacion()[i].getNombre().equals(objetoHabitacion)) {
                        //si encuentra el objeto, le mostramos su descripción
                        System.out.println(habitacion.getObjetosHabitacion()[i].getDescripcion());
                    } else {
                        throw new RuntimeException("Objeto no encontrado."); //si no lo encuentra, lanzamos una excepción
                    }
                }
                break;
            default:
                mostrarInventario(jugador); //le mostramos los objetos que tiene en el inventario
                String objetoInventario = MiEntradaSalida.solicitarCadena("¿Qué objeto desea examinar?");
                for (int i = 0; i < jugador.getInventario().length; i++) {
                    if (jugador.getInventario()[i] != null && jugador.getInventario()[i].getNombre().equals(objetoInventario)) {
                        //si encuentra el objeto se le mostrará su descripción
                        System.out.println(jugador.getInventario()[i].getDescripcion());
                    } else {
                        //si no lo encuentra lanzaremos una excepción
                        throw new RuntimeException("Objeto no encontrado.");
                    }
                }
        }
    }


    public static void irDerecha(Jugador jugador, Habitacion[] mapa) {
        int posActual = jugador.getPosicion();
        try {
            jugador.setPosicion(posActual + 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Te has movido a la derecha.");
        System.out.println(mapa[jugador.getPosicion()].getDescripcion());
    }




    public static void irIzquierda(Jugador jugador, Habitacion[] mapa) {
        int posActual = jugador.getPosicion();


        try {
            jugador.setPosicion(posActual + 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Te has movido a la izquierda.");
        System.out.println(mapa[jugador.getPosicion()].getDescripcion());
    }




    public static void regresar(Jugador jugador, Habitacion[] mapa) {
        int posActual = jugador.getPosicion();
        try {
            jugador.setPosicion(posActual - 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Has regresado a la habitación anterior.");
        System.out.println(mapa[jugador.getPosicion()].getDescripcion());
    }


    public static void abrirObjeto(String nombreObjeto, Habitacion habitacion, Jugador jugador) {
        Objeto obj = buscarObjeto(nombreObjeto, habitacion, jugador);


        if (obj == null) {
            System.out.println("Objeto no encontrado.");
            return;
        }


        if (obj instanceof Abrible abrible) {
            // Buscamos la llave compatible automáticamente en el inventario
            LLave llaveCorrecta = null;
            for (Objeto o : jugador.getInventario()) {
                if (o instanceof LLave l && l.getCodigoSeguridad() != null) {
                    llaveCorrecta = l;
                    break;
                }
            }
            RespuestaAccion respuesta = abrible.abrir(llaveCorrecta);
            System.out.println(respuesta.mensaje());
        } else {
            System.out.println("No se puede abrir ese objeto.");
        }
    }


    private static Objeto buscarObjetoEnInventario(String nombre, Jugador jugador) {
        for (Objeto obj : jugador.getInventario()) {
            if (obj != null && obj.getNombre().equalsIgnoreCase(nombre)) return obj;
        }
        return null;
    }


    private static Objeto buscarObjetoEnHabitacion(String nombre, Habitacion habitacion) {
        for (Objeto obj : habitacion.getObjetosHabitacion()) {
            if (obj != null && obj.visible && obj.getNombre().equalsIgnoreCase(nombre)) return obj;
        }
        return null;
    }


    private static Objeto buscarObjeto(String nombre, Habitacion habitacion, Jugador jugador) {
        Objeto obj = buscarObjetoEnHabitacion(nombre, habitacion);
        if (obj == null) obj = buscarObjetoEnInventario(nombre, jugador);
        return obj;
    }


    public static void combinarObjeto(Habitacion habitacion, Jugador jugador) {
        // Mostramos los objetos disponibles en la habitación y en el inventario
        System.out.println("Objetos en la habitación:");
        mostrarObjetosHabitacionActual(habitacion);


        System.out.println("Objetos en tu inventario:");
        mostrarInventario(jugador);


        // Pedimos al usuario que elija el primer objeto
        String nombre1 = MiEntradaSalida.solicitarCadena("Elige el primer objeto a combinar:");
        Objeto obj1 = buscarObjeto(nombre1, habitacion, jugador);


        if (!(obj1 instanceof Combinable)) {
            System.out.println("Este objeto no se puede combinar.");
            return;
        }


        // Pedimos al usuario que elija el segundo objeto
        String nombre2 = MiEntradaSalida.solicitarCadena("Elige el segundo objeto a combinar:");
        Objeto obj2 = buscarObjeto(nombre2, habitacion, jugador);


        if (!(obj2 instanceof Combinable)) {
            System.out.println("El segundo objeto no se puede combinar.");
            return;
        }


        // Intentamos combinar
        Objeto resultado = ((Combinable) obj1).combinar(obj2);
        if (resultado == null) {
            resultado = ((Combinable) obj2).combinar(obj1); // delegación por si el chef está invertido
        }


        // Procesamos el resultado
        if (resultado != null) {
            System.out.println("¡Has creado un nuevo objeto: " + resultado.getNombre() + "!");
            // Eliminamos los objetos originales del inventario y/o habitación
            jugador.eliminarObjeto(obj1);
            jugador.eliminarObjeto(obj2);
            eliminarObjetoHabitacion(habitacion, obj1);
            eliminarObjetoHabitacion(habitacion, obj2);
        }
    }
    private static void eliminarObjetoHabitacion(Habitacion habitacion, Objeto objeto) {
        Objeto[] objs = habitacion.getObjetosHabitacion();
        for (int i = 0; i < objs.length; i++) {
            if (objeto.equals(objs[i])) {
                objs[i] = null;
                return;
            }
        }
    }
    public static void leerObjeto(Habitacion habitacion, Jugador jugador) {
        Objeto objeto = buscarObjeto("nombre del objeto", habitacion, jugador);
        if (objeto instanceof Leible legible) {
            System.out.println("-----------------------------");
            System.out.println("Lees: " + legible.leer());
            System.out.println("-----------------------------");
        } else {
            System.out.println("Este objeto no tiene nada que leer.");
        }
    }
    public static void mostrarAyuda() {
        System.out.println("\n--- COMANDOS DISPONIBLES ---");
        System.out.println("ayuda: Muestra esta lista de comandos.");
        System.out.println("mirar: Describe tu ubicación actual y los objetos visibles.");
        System.out.println("inventario: Muestra los objetos que llevas contigo.");
        System.out.println("ir derecha: Intenta moverse a la habitación de la derecha.");
        System.out.println("ir izquierda: Intenta moverse a la habitación de la izquierda.");
        System.out.println("coger objeto: Intenta recoger un objeto visible (ej: coger llave).");
        System.out.println("salir: Finaliza el juego.");
        System.out.println("examinar objeto: muestra la descripción de un objeto.");
        System.out.println("regresar: regresa a la habitación anterio");
        System.out.println("combinar: intenta combinar 2 objetos.");
        System.out.println("leer: intenta leer una nota.");
        System.out.println("--------------------------");
    }

}
