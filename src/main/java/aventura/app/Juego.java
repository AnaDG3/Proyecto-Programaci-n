package aventura.app;


import aventura.domain.*;
import io.MiEntradaSalida;


public class Juego {

    //Descripción del juego
    private static String descripcionJuego = "Te has enterado de que el interior de un castillo que está por tu zona se encuentra un tesoro, y nadie sabe lo que contiene.\n" +
            " Decidiste ir a buscarlo, pero cuando consiguiste entrar todas las puertas y ventanas se cerraron, quedando atrapado.";

    public static void main(String[] args) {
        boolean jugando = true;
        //creamos los objetos, habitaciones y al jugador. Luego añadimos los objetos a las habitaciones

        Jugador jugador = new Jugador(5);
        Habitacion[] habitaciones = new Habitacion[3];

        Item lamparaAceite = new Item("lampara de aceite", "Una lampara de aceite. Te servirá para ver mejor.", true);
        Mueble estanteriaVacia = new Mueble("Estantería Vacía", "Una estantería vacía llena de polvo", true);
        Mueble mesaGrande = new Mueble("Mesa Grande", "Una mesa muy grande situada en el centro de la habitación.", true);

        habitaciones[0].setMaxObjetos(3);
        habitaciones[0].addObjeto(lamparaAceite, habitaciones[0]);
        habitaciones[0].addObjeto(estanteriaVacia, habitaciones[0]);
        habitaciones[0].addObjeto(mesaGrande, habitaciones[0]);
        habitaciones[0].setDescripcion("Estás en un salón grande. Todo está muy oscuro, pero ves lo suficiente para percatarte de que hay una lampara de aceite.");

        TrozoLlave trozo1 = new TrozoLlave("Mango de una llave", "Es una llave, pero está incompleta", "222", true);
        Mueble silla = new Mueble("silla", "Una silla vieja y estropeada", true);
        Mueble mesita = new Mueble("Mesa pequeña", "Una mesa pequeña de madera maciza", true);
        Mueble estanteriaLibros = new Mueble("Estantería con libros", "Una enorme estantería repleta de libros antigüos", true);

        habitaciones[1].setMaxObjetos(4);
        habitaciones[1].addObjeto(trozo1, habitaciones[1]);
        habitaciones[1].addObjeto(silla, habitaciones[1]);
        habitaciones[1].addObjeto(mesita, habitaciones[1]);
        habitaciones[1].addObjeto(estanteriaLibros, habitaciones[1]);
        habitaciones[1].setDescripcion("Ahora te encuentras en una habitación con mucha humedad. Escuchas un sonido estraño que proviene de una habitación que está a tu IZQUIERDA.");

        TrozoLlave trozo2 = new TrozoLlave("Parte inferior de una llave", "La parte inferior de una llave. A lo mejor puede ser útil", "222", true);
        Nota nota = new Nota("Nota", "Una nota escrita en papel viejo", "Si estás leyendo esta nota, quiero advertirte que" +
                " no sigas abanzando más allá de está habitación. De lo contrario, algo terrible sucederá", false);
        Contenedor armarioCerrado = new Contenedor("Armario", "Un armario cerrado con llave", "ARMARIO_123", nota, true);

        habitaciones[2].setMaxObjetos(3);
        habitaciones[2].addObjeto(trozo2, habitaciones[2]);
        habitaciones[2].addObjeto(nota, habitaciones[2]);
        habitaciones[2].addObjeto(estanteriaLibros, habitaciones[2]);
        habitaciones[1].setDescripcion("Resulta que el ruido venía de un armario antigüo que se encuentra al fondo de la habitación.");

        System.out.println("¡Bienvenido a 'TU PROPIA AVENTURA'!");
        System.out.println("------------------------------------------");


        // Muestra la descripción general del juego
        System.out.println(descripcionJuego);


        // Muestra la descripción de la primera habitación

        System.out.println(habitaciones[0].getDescripcion());


        // TODO 2: Iniciar el bucle principal del juego (game loop)
        while (jugando) {

            // Leer el comando del usuario por teclado
            String comando = MiEntradaSalida.solicitarCadena("Introduce un comando: ");

            switch (comando) {
                case "coger objeto":
                    Comandos.cogerObjeto(habitaciones[jugador.getPosicion()], jugador);
                    break;
                case "leer":
                    Comandos.leerObjeto(habitaciones[jugador.getPosicion()], jugador);
                    break;
                case "combinar":
                    Comandos.combinarObjeto(habitaciones[jugador.getPosicion()], jugador);
                    break;
                case "examinar objeto":
                    Comandos.examinarObjeto(habitaciones[jugador.getPosicion()], jugador);
                    break;
                case "ayuda":
                    Comandos.mostrarAyuda(); //este método es simplemente un menú con los comandos que puede usar el jugador
                    break;
                case "ir derecha":
                    Comandos.irDerecha(jugador, habitaciones);
                case "ir izquierda": //igual que ir derecha, pero aquí la habitación donde no se puede ir a la izquierda es la 0
                    Comandos.irIzquierda(jugador, habitaciones);
                case "mirar":
                    habitaciones[jugador.getPosicion()].getDescripcion();
                    System.out.println("Objetos disponibles: ");
                    Comandos.mostrarObjetosHabitacionActual(habitaciones[jugador.getPosicion()]);
                    break;
                case "salir":
                    jugando = false; //para que salga del bucle while
                    break;
                case "inventario":
                    Comandos.mostrarInventario(jugador);
                    break;
                case "regresar":
                    Comandos.regresar(jugador, habitaciones);
                    break;
                default:
                    //si el comando no coincide con los disponibles
                    System.out.println("Comando desconocido. Escribe 'ayuda' para ver los comandos disponibles.");
            }


        }
        System.out.println("¡Gracias por jugar!");


    }
}
