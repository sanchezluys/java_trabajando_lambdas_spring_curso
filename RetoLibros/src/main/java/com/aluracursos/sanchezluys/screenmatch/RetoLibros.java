package com.aluracursos.sanchezluys.screenmatch;
import com.aluracursos.sanchezluys.screenmatch.principal.Menus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetoLibros implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RetoLibros.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menus menu = new Menus();
		menu.Encabezado();
		menu.Menu();
		menu.RevisarSeleccion();
	}
}
