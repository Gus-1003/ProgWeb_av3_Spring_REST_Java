package com.example.demo.repository;

import com.example.demo.domain.Camisa;
import com.example.demo.domain.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
}
