package io;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;


public class MiEntradaSalida {


    // 1. El Scanner se hace PRIVADO para protegerlo.
    // Solo esta clase puede usarlo.
    private static Scanner sc = new Scanner(System.in);


    public static int solicitarEntero(String mensaje) {
        // Variable que almacenará el entero introducido por teclado.
        int integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                integer = Integer.parseInt(sc.nextLine());
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico.
                System.out.println("Error: Debe introducir un número entero.");
            }


        }


        return integer;
    }


    public static int solicitarEnteroPositivo(String mensaje) {
        // Variable que almacenará el entero introducido por teclado.
        int integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto.
            try {
                integer = Integer.parseInt(sc.nextLine());


                // Comprobamos la segunda condición: que sea positivo.
                if (integer >= 0) {
                    // Si llegamos hasta aquí, el dato es correcto.
                    flag = false;
                } else {
                    // 2. Mensaje de error específico (error de lógica, no de formato).
                    System.out.println("Error: El número debe ser positivo o cero.");
                }
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico (error de formato).
                System.out.println("Error: Debe introducir un número entero.");
            }


        }


        return integer;
    }


    public static int solicitarEnteroEnRango(String mensaje, int limiteInferior, int limiteSuperior) {
        // Variable que almacenará el entero introducido por teclado.
        int integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto.
            try {
                integer = Integer.parseInt(sc.nextLine());


                // Comprobamos la segunda condición: el rango.
                if (integer >= limiteInferior && integer <= limiteSuperior) {
                    // Si llegamos hasta aquí, el dato es correcto.
                    flag = false;
                } else {
                    // 2. Mensaje de error específico (error de lógica).
                    System.out.println("Error: El número debe estar entre " + limiteInferior + " y " + limiteSuperior + ".");
                }
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico (error de formato).
                System.out.println("Error: Debe introducir un número entero.");
            }


        }


        return integer;
    }


    public static char solicitarCaracter(String mensaje) {
        char c = '0';
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el carácter por pantalla.
            System.out.println(mensaje);


            try {
                // Obtenemos el primer carácter de la línea.
                c = sc.nextLine().charAt(0);
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción (porque el usuario no escribió nada).
            catch (StringIndexOutOfBoundsException e) { // Es más específico que IndexOutOfBoundsException
                // 2. Mensaje de error específico.
                System.out.println("Error: No ha introducido ningún carácter. Inténtelo de nuevo.");
            }


        }


        return c;
    }


    public static char solicitarCaracterSN(String mensaje) {
        char c = '0';
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el carácter por pantalla.
            System.out.println(mensaje);


            String cadena = sc.nextLine();


            // Comprobamos que la longitud sea de 1 solo carácter.
            if (cadena.length() == 1) {
                c = cadena.toUpperCase().charAt(0);


                // Comprobamos si es S o N.
                if (c == 'S' || c == 'N') {
                    // Si llegamos hasta aquí, el dato es correcto.
                    flag = false;
                } else {
                    // 2. Mensaje de error específico (carácter incorrecto).
                    System.out.println("Error: Respuesta no válida. Debe introducir 'S' o 'N'.");
                }
            } else {
                // 2. Mensaje de error específico (longitud incorrecta).
                System.out.println("Error: Debe introducir un solo carácter ('S' o 'N').");
            }
        }


        return c;
    }


    public static String solicitarCadena(String mensaje) {
        String cadena = "";
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el string por pantalla.
            System.out.println(mensaje);


            // 3. Usamos .trim() para eliminar espacios en blanco al inicio y al final.
            cadena = sc.nextLine().trim();


            // Comprobamos que la cadena no esté vacía después de quitarle los espacios.
            if (!cadena.isEmpty()) {
                // Si llegamos hasta aquí, el dato es correcto.
                flag = false;
            } else {
                // 2. Mensaje de error específico.
                System.out.println("Error: No puede introducir una cadena vacía.");
            }
        }


        return cadena;
    }


    public static char solicitarCaracter(String mensaje, char caracter) {
        char c = '0';
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el carácter por pantalla.
            System.out.println(mensaje);


            try {
                // Obtenemos el primer carácter de la línea.
                c = sc.nextLine().charAt(0);
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción (porque el usuario no escribió nada).
            catch (StringIndexOutOfBoundsException e) { // Es más específico que IndexOutOfBoundsException
                // 2. Mensaje de error específico.
                System.out.println("Error: No ha introducido ningún carácter. Inténtelo de nuevo.");
            }
        }
        return c;
    }


    public static float solicitarFloatEnRango(String mensaje, float limiteInferior, float limiteSuperior) {
        // Variable que almacenará el float introducido por teclado.
        float integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el float por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto.
            try {
                integer = Integer.parseInt(sc.nextLine());


                // Comprobamos la segunda condición: el rango.
                if (integer >= limiteInferior && integer <= limiteSuperior) {
                    // Si llegamos hasta aquí, el dato es correcto.
                    flag = false;
                } else {
                    // 2. Mensaje de error específico (error de lógica).
                    System.out.println("Error: El número debe estar entre " + limiteInferior + " y " + limiteSuperior + ".");
                }
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico (error de formato).
                System.out.println("Error: No puede introducir ese número.");
            }


        }


        return integer;
    }


    public static char solicitarCaracterFM(String mensaje) {
        char c = '0';
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el carácter por pantalla.
            System.out.println(mensaje);


            String cadena = sc.nextLine();


            // Comprobamos que la longitud sea de 1 solo carácter.
            if (cadena.length() == 1) {
                c = cadena.toUpperCase().charAt(0);


                // Comprobamos si es S o N.
                if (c == 'F' || c == 'M') {
                    // Si llegamos hasta aquí, el dato es correcto.
                    flag = false;
                } else {
                    // 2. Mensaje de error específico (carácter incorrecto).
                    System.out.println("Error: Respuesta no válida. Debe introducir 'F' o 'M'.");
                }
            }
        }


        return c;
    }


    public static double solicitarDoublePositivo(String mensaje) {
        // Variable que almacenará el double introducido por teclado.
        double integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el double por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                integer = Integer.parseInt(sc.nextLine());
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico.
                System.out.println("Error: Debe introducir un número positivo.");
            }


        }


        return integer;
    }


    public static LocalDate solicitarLocalDate(String mensaje) {
        System.out.println(mensaje);
        // 3. Le pedimos la fecha al usuario en año, mes y día
        int dia = solicitarEnteroEnRango("Introduce el día", 1, 31);
        int mes = solicitarEnteroEnRango("Introduce el mes", 1, 12);
        int anyo = solicitarEntero("Introduce el año");
        LocalDate localDate = LocalDate.of(anyo, mes, dia);
        return localDate;
    }


    public static Period solicitarPeriodo(String mensaje) {
        System.out.println(mensaje);
        // 3. Le pedimos al usuario los años, meses y días del periodo
        int anyo = solicitarEnteroPositivo("Introduce los años");
        int mes = solicitarEnteroPositivo("Introduce los meses");
        int dia = solicitarEntero("Introduce los días");
        Period periodo = Period.of(dia, mes, anyo);
        return periodo;
    }


    public static boolean solicitarBoolean(String mensaje) {
        char c = '0';
        boolean booleano = true;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;


        while (flag) {
            // Pedimos el carácter por pantalla.
            System.out.println(mensaje);


            String cadena = sc.nextLine();


            // Comprobamos que la longitud sea de 1 solo carácter.
            if (cadena.length() == 1) {
                c = cadena.toUpperCase().charAt(0);


                // Comprobamos si es S o N.
                if (c == 'S' || c == 'N') {
                    // Si llegamos hasta aquí, el dato es correcto.
                    flag = false;
                } else {
                    // 2. Mensaje de error específico (carácter incorrecto).
                    System.out.println("Error: Respuesta no válida. Debe introducir 'S' o 'N'.");
                }
            } else {
                // 2. Mensaje de error específico (longitud incorrecta).
                System.out.println("Error: Debe introducir un solo carácter ('S' o 'N').");
            }
        }
        if (c == 'N') {
            booleano = false;
        }
        return booleano;
    }

    public static LocalDate sumarDiasMesesAnyosAFecha(LocalDate fecha, Period periodo) {
        fecha = fecha.plusDays(periodo.getDays());
        fecha = fecha.plusMonths(periodo.getMonths());
        fecha = fecha.plusYears(periodo.getYears());
        return fecha;
    }
}