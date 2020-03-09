package com.example.popularonetomany.model;

import java.util.List;

import java.lang.String;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "preguntas")
public class Pregunta {

	@Id
	@GeneratedValue
	private Long id;
	private String texto;
	private String categoria;
	@OneToMany(mappedBy = "pregunta")
	private List<Respuesta> listaDeRespuestas;

	public Pregunta() {
		super();
	}

	public Pregunta(Long id, String texto, String categoria, List<Respuesta> listaDeRespuestas) {
		super();
		this.id = id;
		this.texto = texto;
		this.categoria = categoria;
		this.listaDeRespuestas = listaDeRespuestas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Respuesta> getListaDeRespuestas() {
		return listaDeRespuestas;
	}

	public void setListaDeRespuestas(List<Respuesta> listaDeRespuestas) {
		this.listaDeRespuestas = listaDeRespuestas;
	}

	public void agregarRepuesta(Respuesta unRespuesta) {
		this.listaDeRespuestas.add(unRespuesta);		
	}

}
