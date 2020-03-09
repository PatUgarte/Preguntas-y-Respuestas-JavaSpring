package com.example.popularonetomany.respository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.popularonetomany.model.Pregunta;
import com.example.popularonetomany.model.Respuesta;
import com.example.popularonetomany.repository.RespuestaJpaRepository;

@Service
public class RespuestaService {

	@Autowired
	RespuestaJpaRepository respuestaJpaRepository;

	public void insertarRespuestas(List<Respuesta> respuestas) {
		respuestaJpaRepository.saveAll(respuestas);
	}

	public List<Respuesta> generarLista(Pregunta pregunta, Integer correctaIndex, String[] textoRespuestas) {
		List<Respuesta> listaDeRespuestas = new ArrayList<>();

		for (int i = 0; i < textoRespuestas.length; i++) {
			
			Respuesta objetoRespuesta = new Respuesta(textoRespuestas[i], false, pregunta);
			
			if(correctaIndex.equals(i)) objetoRespuesta.setCorrecta(true);
			
			listaDeRespuestas.add(objetoRespuesta);
		}
		
		return listaDeRespuestas;
	}

}
