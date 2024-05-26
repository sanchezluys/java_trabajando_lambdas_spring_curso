package com.aluracursos.sanchezluys.screenmatch.principal;

import com.aluracursos.sanchezluys.screenmatch.modelo.DatosEpisodio;
import com.aluracursos.sanchezluys.screenmatch.modelo.DatosSerie;
import com.aluracursos.sanchezluys.screenmatch.modelo.DatosTemporadas;
import com.aluracursos.sanchezluys.screenmatch.modelo.Episodio;
import com.aluracursos.sanchezluys.screenmatch.service.ConsumoAPI;
import com.aluracursos.sanchezluys.screenmatch.service.ConvierteDatos;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

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
        //
        System.out.println("**************************");
        System.out.println(" Usando Streams");
        EjemploStreams ejemploStreams = new EjemploStreams();
        ejemploStreams.muestraEjemplo();

        // identificando los mejores episiodios
        System.out.println("***********************");
        System.out.println("Identificando los 5 mejores episodios");
        System.out.println("Serie: "+nombreSerie);
        System.out.println("********************************");
        // convertir todas las informaciones a una lista del tipo DatosEpisodio
        List<DatosEpisodio> datosEpisodios = temporadas.stream()
                .flatMap(t-> t.episodios().stream())
                .collect(Collectors.toList());  //.toList() es inmutable, con el usado si es mutable

        // top 5 episodios
        datosEpisodios.stream()
                .filter(e-> !e.evaluacion().equalsIgnoreCase("N/A"))
                .peek(e-> System.out.println("Aplicando el filtro de N/A "+ e))
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                .peek(e-> System.out.println("Aplicando el filtro de ordenado Mayor a menor "+ e))
                .map(e-> e.titulo().toUpperCase())
                .peek(e-> System.out.println("Aplicando llevar a mayuscula el titulo "+ e))
                .limit(5)
                .peek(e-> System.out.println("Aplicando el limite de 5 registros "+ e))
                .forEach(System.out::println);

        // clase 03-08
        System.out.println("****************************");
        System.out.println("Convirtiendo los datos a una lista del tipo episiodios");
        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d)))
                .collect(Collectors.toList());
        //
        episodios.forEach(System.out::println);
        //
        System.out.println("**************************");
        System.out.println("Ahora busqueda de episodios a partir de un año");
        System.out.println("Indicar el año ");
        var fecha = teclado.nextInt();
        teclado.nextLine();
        //
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        LocalDate fechaBusqueda = LocalDate.of(fecha, 1,1);
        episodios.stream()
                .filter(e -> e.getFechaLanzamiento() != null && e.getFechaLanzamiento().isAfter(fechaBusqueda))
                .forEach(e -> {
                    System.out.println("Temporada "+ e.getTemporada() + " Episodio "+ e.getTitulo()+
                            " Fecha Lanzamiento: "+ e.getFechaLanzamiento().format(dtf) );
                });
        //***
        System.out.println("*************************");
        System.out.println("Ahora se bucsa un episodio con una palabra o pedazo de oracion:");
        System.out.println("***************************");
        System.out.println("Ingrese el titulo de la temporada o lo que recuerde para buscar: ");
        var pedazoTitulo= teclado.nextLine();
        Optional<Episodio> episodioBuscado = episodios.stream()
                .filter(e -> e.getTitulo().toUpperCase().contains(pedazoTitulo.toUpperCase()))
                .findFirst();

        if(episodioBuscado.isPresent()){
            System.out.println("Si se encontró una coicindencia ");
            System.out.println("El titulo encontrado es: " + episodioBuscado.get());
        }
        else{
            System.out.println("No se encontó ninguna coicidencia!");
        }



    }
}
