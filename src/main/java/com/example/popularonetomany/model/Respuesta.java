package com.example.popularonetomany.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respuestas")
public class Respuesta {
	@Id
	@GeneratedValue
	private Long id;
	private String texto;
	private Boolean correcta;
	@ManyToOne
	@JoinColumn(name = "pregunta_id", nullable = true)
	private Pregunta pregunta;

	public Respuesta() {
		super();
	}

	public Respuesta(String texto, Boolean correcta, Pregunta pregunta) {
		super();
		this.texto = texto;
		this.correcta = correcta;
		this.pregunta = pregunta;
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

	public Boolean getCorrecta() {
		return correcta;
	}

	public void setCorrecta(Boolean correcta) {
		this.correcta = correcta;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

}
