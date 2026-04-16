package com.example.utils;

import java.util.Scanner;

public class ScannerUtil {
    // Usamos un único Scanner estático para toda la aplicación
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Pide un texto al usuario y se asegura de que no envíe una cadena vacía.
     */
    public static String leerTexto(String mensaje) {
        String entrada;
        do {
            System.out.print(mensaje);
            entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("Error: El campo no puede estar vacío. Intente nuevamente.");
            }
        } while (entrada.isEmpty());
        return entrada;
    }

    /**
     * Pide un número entero y evita que el programa colapse (NumberFormatException)
     * si el usuario escribe letras o símbolos.
     */
    public static int leerEntero(String mensaje) {
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
            try {
                // Leemos como texto y luego lo convertimos.
                // Esto evita el clásico bug de que el "Enter" se quede en el buffer.
                numero = Integer.parseInt(scanner.nextLine().trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número entero válido.");
            }
        }
        return numero;
    }

    /**
     * Sobrecarga del método anterior: Pide un entero, pero obligando a que
     * esté dentro de un rango específico.
     */
    public static int leerEntero(String mensaje, int min, int max) {
        int numero;
        do {
            numero = leerEntero(mensaje);
            if (numero < min || numero > max) {
                System.out.println("Error: Por favor, ingrese una opción entre " + min + " y " + max + ".");
            }
        } while (numero < min || numero > max);
        return numero;
    }
}