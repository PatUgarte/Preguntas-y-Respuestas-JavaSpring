package com.example.popularonetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.popularonetomany.model.Pregunta;
import com.example.popularonetomany.model.Respuesta;
import com.example.popularonetomany.respository.PreguntaService;
import com.example.popularonetomany.respository.RespuestaService;

@Controller
public class PreguntasYRespuestasController {

	@Autowired
	PreguntaService preguntaService;
	@Autowired
	RespuestaService respuestaService;

	@GetMapping("/preguntas/add")
	public String agregarPregunta() {
		return "add-pregunta";
	}

	@PostMapping("/preguntas/added")
	public String insertarPregunta(Pregunta pregunta, Model model) {
		preguntaService.insertarPregunta(pregunta);
		model.addAttribute(pregunta);
		return "added-pregunta";
	}

	@PostMapping("/respuestas/add")
	public String insertarRespuesta(Pregunta pregunta, Model model) {
		model.addAttribute(pregunta);
		return "add-respuesta";
	}

	@PostMapping("/pregunta/created")
	public String preguntaCreada(Pregunta pregunta, Integer correcta, String... respuestas) {
		List<Respuesta> listaDeRespuestas = respuestaService.generarLista(pregunta, correcta, respuestas);
		preguntaService.insertarRespuestaEnPregunta(listaDeRespuestas);
		respuestaService.insertarRespuestas(listaDeRespuestas);
		return "added-pregunta";
	}
}
