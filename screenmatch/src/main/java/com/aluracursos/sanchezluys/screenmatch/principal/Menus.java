package com.aluracursos.sanchezluys.screenmatch.principal;

public class Menus {
   public void Encabezado(){
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

   public void Despedida(){
       System.out.println("╔════════════════════════════════════════════════════════╗");
       System.out.println("║                         DESPEDIDA                      ║");
       System.out.println("╠════════════════════════════════════════════════════════╣");
       System.out.println("║ Muchas gracias por usar esta Aplicación                ║");
       System.out.println("║ Nos vemos pronto!!                                     ║");
       System.out.println("╚════════════════════════════════════════════════════════╝");;
   }

   public void Menu(){
       System.out.println("╔════════════════════════════════════════════════════════╗");
       System.out.println("║                         MENÚ                           ║");
       System.out.println("╠════════════════════════════════════════════════════════╣");
       System.out.println("║ 1. Ver 5 titulos                                       ║");
       System.out.println("║ 2. Ver los 10 libros mas descargados                   ║");
       System.out.println("║ 3. Buscar un titulo                                    ║");
       System.out.println("║ 4. Salir                                               ║");
       System.out.println("╚════════════════════════════════════════════════════════╝");
       System.out.print("Ingrese su opción: ");
   }
}
