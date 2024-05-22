package com.aluracursos.sanchezluys.screenmatch.principal;

import com.aluracursos.sanchezluys.screenmatch.modelo.DatosEpisodio;
import com.aluracursos.sanchezluys.screenmatch.modelo.DatosSerie;
import com.aluracursos.sanchezluys.screenmatch.modelo.DatosTemporadas;
import com.aluracursos.sanchezluys.screenmatch.service.ConsumoAPI;
import com.aluracursos.sanchezluys.screenmatch.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    // crear el menu
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE="http://www.omdbapi.com/?t=";
    private final String API_KEY="&apikey=5e85123f";
    private final String SEASON="&Season=";
    private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraMenu(){

        System.out.println("Escriba el nombre de la serie a buscar: ");
        var nombreSerie = teclado.nextLine();
        // ajustamos por si escribe espacios
        nombreSerie=nombreSerie.replace(" ","+");
        //
        var json = consumoAPI.obtenerDatos(URL_BASE+ nombreSerie + API_KEY);
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println("json: "+json);
        System.out.println("datos: "+datos);
        // busca los datso
        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i < datos.totalTemporadas() ; i++) {

            var json4 = consumoAPI.obtenerDatos(URL_BASE + nombreSerie + SEASON + i + API_KEY);
            var datosTemporadas = conversor.obtenerDatos(json4, DatosTemporadas.class);
            //**
            System.out.println("Cuando i = "+i);
            System.out.println("-> json4: "+ json4);
            temporadas.add(datosTemporadas);
        }
        //** se imprime la lista
        temporadas.forEach(System.out::println);
        // ** listas dentro de listas
        // mostrar solo el titulo de los episiodios para las temporadas
        System.out.println("*********************");
        System.out.println("Listas dentro de listas");
        for (int i = 0; i < (datos.totalTemporadas()-1); i++) {
           List<DatosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporada.size(); j++) {
                System.out.println("Episodio-temporada: i="+i+" j="+j+" :" + episodiosTemporada.get(j).titulo());
            }
        }
        System.out.println("*******************************");
        System.out.println("USANDO FUNCIONES LAMBDA");
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())) );
    }
}
