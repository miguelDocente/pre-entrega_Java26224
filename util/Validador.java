package util;

import java.util.InputMismatchException;
import java.util.Scanner;

import exception.StockInsuficienteException;

/*
    Clase con métodos de validación reutilizables.
    Todos los metodos son estáticos: no necesitamos crear una instancia de Validador para usarlos.Se invocan directamente 

    

*/

public class Validador {
    // Validaciones de datos del producto
    // Estos métodos lanzan una excepción si el dato es invalido
    // no retornan nada: si terminan sin lanzar la ecxepcion el dato es valido.

    public static void validarNombre(String nombre){
        // Un nombre nulo o vacío no representa un producto válido
        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }

    public static void validarPrecio(double precio){
        // no sean negativos
        // aceptamos 0
        if ( precio < 0){
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
    }

    public static void validarStock( int stock){
        // stock negativo no es valido
        // usamos nuestra excepcion personalizada
        if (stock < 0){
            throw new StockInsuficienteException("El stock no puede ser negativo.");
        }
    }

    public static void validarCategoria (String categoria){
        if(categoria == null || categoria.isBlank()){
            throw new IllegalArgumentException("La categoria no puede estar vacia.");
        }
    }

    // Lectura por consola
    // 

    public static int leerEntero(Scanner sc , String mensaje){
        // bucle infinito que se rompe cuando el usuario ingresa un entero valido.
        while(true){
            System.out.println(mensaje);
            try {
                int valor = sc.nextInt();
                sc.nextLine(); // limpia el salto de línea pendiente
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número entero.Intente nuevamente.");
                sc.nextLine(); // limpia el salto de línea pendiente
            }
        }
    }

    public static double leerDouble(Scanner sc , String mensaje){
        while(true){
            System.out.println(mensaje);
            try {
                double valor = sc.nextDouble();
                sc.nextLine();
                return valor;
            } catch (Exception e) {
                System.out.println("Debe ingresar un número decimal.(coma o punto");
                sc.nextLine();
            }
        }
    }

    public static String leerTexto(Scanner sc , String mensaje){
        // lectura simple de texto
        System.out.println(mensaje);
        return sc.nextLine();
    }




}
