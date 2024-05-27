package com.aluracursos.sanchezluys.screenmatch.principal;
import java.util.Scanner;

public class Menus {
    public void Encabezado() {
        // emoticones: ⚠️🔥📝✅❎📂⚙️🏷️📦📆🗓️🕑🏁➡️⬆️🎁🛒🛍️✏️🖍️✂️🔒🔓💎😀😃
        //**
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║ ALURA LATAM    MAYO 2024  BY: SANCHEZLUYS              ║");
        System.out.println("║ RETO: LIBROS DEL CURSO DE JAVA LAMBDAS/SPRING          ║");
        System.out.println("║ Profesor(es): Genesys Rondon                           ║");
        System.out.println("║ Backend con JAVA 17                                    ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Usando API de: https://gutendex.com/?ref=public_apis   ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }

    public void Despedida() {
        // se muestra el mensaje de despedida
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                         DESPEDIDA                      ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Muchas gracias por usar esta Aplicación                ║");
        System.out.println("║ Nos vemos pronto!!                                     ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        ;
    }

    public void Menu() {
        // se muestra el menu disponible
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                         MENÚ                           ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Ver 5 titulos                                       ║");
        System.out.println("║ 2. Ver los 10 libros mas descargados                   ║");
        System.out.println("║ 3. Buscar un titulo                                    ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ 4. Salir                                               ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.print("\uD83D\uDCDD Ingrese su opción: ");
    }

    public void RevisarSeleccion() {
        Scanner teclado = new Scanner(System.in); // Initialize the Scanner
        var seleccion = teclado.nextLine();
        // se valida que se cumpla la seleccion disponible
        switch (seleccion) {
            case "1":
                //listado de libros 5 de ejemplo
                this.Opcion1();
                break;
            case "2":
                // listado 5 top descargados
                this.Opcion2();
                break;
            case "3":
                // Buscar un libro
                this.Opcion3();
                break;
            case "4":
                // Salir
                this.Despedida();
                break;
            default:
                System.out.println("\nOpcion invalida. Por favor, seleccione una opcion valida.");
                this.Menu();
                this.RevisarSeleccion();
                break;
        }
    }

    public void Opcion1() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                         OPCION 1                       ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
    public void Opcion2() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                         OPCION 2                       ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
    public void Opcion3() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                         OPCION 3                       ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}
