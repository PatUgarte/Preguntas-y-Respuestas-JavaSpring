package com.example.popularonetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.popularonetomany.model.Pregunta;

public interface PreguntaJpaRepository extends JpaRepository<Pregunta, Long> {

}
