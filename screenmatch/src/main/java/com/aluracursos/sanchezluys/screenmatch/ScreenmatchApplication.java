package com.aluracursos.sanchezluys.screenmatch;

import com.aluracursos.sanchezluys.screenmatch.service.ConsumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hola mundo desde spring");
		//**********
		var consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&apikey=5e85123f");
		System.out.println(json);
	}
}
