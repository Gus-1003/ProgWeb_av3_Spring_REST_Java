package com.example.demo.repository;

import com.example.demo.domain.Classificacao;
import com.example.demo.domain.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificacaoRepository extends JpaRepository<Classificacao, Long> {
}
