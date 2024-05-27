package com.aluracursos.sanchezluys.screenmatch.principal;

import com.aluracursos.sanchezluys.screenmatch.model.Datos;
import com.aluracursos.sanchezluys.screenmatch.model.DatosLibros;
import com.aluracursos.sanchezluys.screenmatch.service.ConsumoAPI;
import com.aluracursos.sanchezluys.screenmatch.service.ConvierteDatos;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Opciones {
    Menus menu = new Menus();
    public static final String URL_BASE="https://gutendex.com/books/";
    ConsumoAPI consumoAPI = new ConsumoAPI();
    ConvierteDatos conversor = new ConvierteDatos();
    //**
    public void Opcion1()
    {
        menu.titulo1();
        var json= consumoAPI.obtenerDatos(URL_BASE);
        var datos = conversor.obtenerDatos(json, Datos.class);
        // vamoa a obtener solo 5 libros al azar
        AtomicInteger contador = new AtomicInteger(1);
        // Convertir el flujo a una lista
        List<DatosLibros> listaLibros = datos.resultados().stream().collect(Collectors.toList());
        // Mezclar la lista
        Collections.shuffle(listaLibros);
        // Obtener los primeros 10 elementos de la lista mezclada
        listaLibros.stream()
                .limit(5)
                .forEach(libro -> System.out.println(contador.getAndIncrement() + ". " + libro.titulo() + " - " + libro.autor()));
    }
    public void Opcion2()
    {
        menu.titulo2();
        var json= consumoAPI.obtenerDatos(URL_BASE);
        //System.out.println(json);
        // vamos a obtener el top de los 10 libros mas descargados
        var datos = conversor.obtenerDatos(json, Datos.class);
        //System.out.println("Lista libros: "+ datos);
        AtomicInteger contador = new AtomicInteger(1);
        datos.resultados().stream()
                        .sorted(Comparator.comparing(DatosLibros::numeroDescargas).reversed())
                        .limit(10)
                        //.map(libro -> libro.titulo().toUpperCase())
                        .forEach(libro -> System.out.println(contador.getAndIncrement() + ". " + libro.titulo().toUpperCase() + " - " + libro.autor()));

    }
    public void Opcion3()
    {
        menu.titulo3();


    }

}
