package com.example.popularonetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.popularonetomany.model.Respuesta;

public interface RespuestaJpaRepository extends JpaRepository<Respuesta, Long> {

}
