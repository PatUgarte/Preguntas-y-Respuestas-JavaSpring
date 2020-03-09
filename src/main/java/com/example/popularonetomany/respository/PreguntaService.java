package com.example.popularonetomany.respository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.popularonetomany.model.Pregunta;
import com.example.popularonetomany.model.Respuesta;
import com.example.popularonetomany.repository.PreguntaJpaRepository;

@Service
public class PreguntaService {

	@Autowired
	PreguntaJpaRepository preguntaJpaRepository;

	public void insertarPregunta(Pregunta pregunta) {
		preguntaJpaRepository.save(pregunta);
	}

	public void insertarRespuestaEnPregunta(List<Respuesta> respuestas) {
		
		Pregunta pregunta = respuestas.get(0).getPregunta();
		
		pregunta.setListaDeRespuestas(respuestas);
		
		this.insertarPregunta(pregunta);
	}

}
