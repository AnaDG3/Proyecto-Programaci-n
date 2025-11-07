package aventura.app;

import java.util.Scanner;

/**
 * Clase principal del juego "Tu Propia Aventura".
 * Esqueleto para la Misión 1 (UD1-UD3).
 * VUESTRO TRABAJO es rellenar todos los TODO
 */
public class Juego {

    // --- NÚCLEO: Definición de Datos (FASE 1) ---
    // Esta parte os la damos HECHA. Es el "contrato" del núcleo.

    private static String descripcionJuego = "Te has enterado de que el interior de un castillo que está por tu zona se encuentra un tesoro, y nadie sabe lo que contiene.\n" +
            " Decidiste ir a buscarlo, pero cuando consiguiste entrar todas las puertas y ventanas se cerraron, quedando atrapado.";
    // El mapa de habitaciones.
    // TODO: (Skin) ¡Rellenad esto con vuestras descripciones!
    private static String[] habitaciones = {
            "Estás en un salón grande. Todo está muy oscuro, pero ves lo suficiente para percatarte de que hay una lampara de aceite. La enciendes y ves una escalera DERECHA.",  // Posición 0
            "Ahora te encuentras en una habitación con mucha humedad. Escuchas un sonido estraño que proviene de una habitación que está a tu IZQUIERDA.", // Posición 1
            "Resulta que el ruido venía de un armario antigüo con mucha profundidad. Dentro hay una llave.", // Posición 2
            // Borra las habitaciones y escribe las tuyas
    };

    // Los objetos que hay en cada habitación.
    // TODO: (Skin) Rellenad esto con vuestros objetos
    private static String[][] objetosMapa = {
            {"lamparaDeAceite", null},           // Objetos en Habitación 0
            {null, null},           // Objetos en Habitación 1
            {"llave", null},      // Objetos en Habitación 2
    };

    // El inventario del jugador. Tamaño fijo.
    private static String[] inventario = new String[5];

    // Variable que guarda la posición actual del jugador
    private static int habitacionActual = 0; // Empezamos en la primera habitación

    // --- FIN DE LA DEFINICIÓN DE DATOS ---


    public static void main(String[] args) {
        // Puedes utilizar la clase MiEntradaSalida, que viviría en el paquete io
        Scanner scanner = new Scanner(System.in);
        boolean jugando = true;

        System.out.println("¡Bienvenido a 'TU PROPIA AVENTURA'!");
        System.out.println("------------------------------------------");

        // TODO 1a: Muestra la descripción general del juego
        System.out.println(descripcionJuego);


        // TODO 1b: Muestra la descripción de la primera habitación
        // Pista: System.out.println(habitaciones[...]);
        System.out.println(habitaciones[0]);

        // TODO 2: Iniciar el bucle principal del juego (game loop)
        while (jugando) {

            // TODO 3: Leer el comando del usuario por teclado
            System.out.print("Introduce un comando:\n> ");
            //String comando = ...;
            String comando = scanner.nextLine();

            /*
            TODO 4: Crear un 'switch' o una estructura 'if-else if'
             para procesar el 'comando' del usuario.
             Debe gestionar como mínimo: "ayuda", "mirar", "inventario",
             "ir derecha", "ir izquierda", "coger [objeto]" y "salir".
             */
            switch (comando) {
                case "coger objeto":
                    if (habitacionActual == 0 && hayObjeto(habitacionActual)) {
                        System.out.println("Has encontrado una lámpara de aceite.");
                        inventario[0] = "lamparaDeAceite";
                    } else if (habitacionActual == 2 && hayObjeto((habitacionActual + 2))) {
                        inventario[1] = "llave";
                        System.out.println("Has encontrado una llave.");
                    }
                    break;
                case "ayuda":
                    break;
                case "ir derecha":
                    if (habitacionActual < habitaciones.length - 1) {
                        habitacionActual++;
                        System.out.println("\nTe has movido a la derecha.");
                        System.out.println(habitaciones[habitacionActual]);
                    } else {
                        System.out.println("No puedes ir más a la derecha. Has llegado al final del mapa.");
                    }
                    break;
                case "ir izquierda":
                    break;
                case "mirar":
                    System.out.println(habitaciones[habitacionActual]);
                    break;
                case "salir":
                    jugando = false;
                    break;
                case "inventario":
                    break;
                default:

            }


        }

        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }

    public static boolean hayObjeto(int habitacion) {
        boolean objetoEncontrado = false;
        if (habitacion == 0 && objetosMapa[habitacionActual][0] != null) {
            objetoEncontrado = true;
        } else if (habitacion == 2 && objetosMapa[habitacionActual][1] != null) {
            objetoEncontrado = true;
        }
        return objetoEncontrado;
    }

    /*
    (Opcional - Buenas Prácticas)
    Si el 'switch' se vuelve muy grande, podéis crear métodos privados
    para organizar el código, por ejemplo:
    private static void procesarComandoCoger(String comando) { ... }
    private static void mostrarInfoHabitacion() { ... }
    */
}