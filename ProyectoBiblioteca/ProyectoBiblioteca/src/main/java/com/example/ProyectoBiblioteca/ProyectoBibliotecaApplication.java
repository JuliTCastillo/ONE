package com.example.ProyectoBiblioteca;

import com.example.ProyectoBiblioteca.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoBibliotecaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoBibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Principal principal = new Principal();
		principal.muestraElMenu();
	}
}
