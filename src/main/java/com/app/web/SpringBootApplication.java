package com.app.web;

import com.app.web.entidad.Estudiante;
import com.app.web.repositorio.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}

//	@Autowired
//	EstudianteRepositorio estudianteRepositorio;

	@Override
	public void run(String... args) throws Exception {
//		estudianteRepositorio.save(new Estudiante("Hernan","Fonseca","hernanfpalomera@gmail.com"));
//		estudianteRepositorio.save(new Estudiante("Andre","Carillo","andrecar@gmail.com"));
	}
}
