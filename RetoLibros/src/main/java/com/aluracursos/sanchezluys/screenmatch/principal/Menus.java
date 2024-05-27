package com.aluracursos.sanchezluys.screenmatch.principal;
import com.aluracursos.sanchezluys.screenmatch.RetoLibros;

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
        System.out.println("║ Usando API de: https://gutendex.com/books/             ║");
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
        RetoLibros.revisar =false;
    }

    public void Menu() {
        // se muestra el menu disponible
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                         MENÚ                           ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Ver 5 titulos al azar                               ║");
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
        Opciones opcion = new Opciones();
        // se valida que se cumpla la seleccion disponible
        switch (seleccion) {
            case "1":
                //listado de libros 5 de ejemplo
                opcion.Opcion1();
                break;
            case "2":
                // listado 5 top descargados
                opcion.Opcion2();
                break;
            case "3":
                // Buscar un libro
                opcion.Opcion3();
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

    public void titulo1() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║  1. LISTADO DE 5 LIBROS AL AZAR                        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
    public void titulo2() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║  2. TOP 10 LIBROS MAS DESCARGADOS                      ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
    public void titulo3() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║  3. BUSCAR UN LIBRO POR TITULO                         ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}
