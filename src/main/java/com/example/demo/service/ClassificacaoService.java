package com.example.demo.service;

import com.example.demo.domain.Classificacao;
import com.example.demo.repository.ClassificacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassificacaoService {
    ClassificacaoRepository repository;

    public ClassificacaoService(ClassificacaoRepository repository) {
        this.repository = repository;
    }

    public Classificacao create(Classificacao c){
        return repository.save(c);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Classificacao update(Classificacao c){
        return repository.saveAndFlush(c);
    }

    public Optional<Classificacao> findById(Long id){
        return repository.findById(id);
    }

    public List<Classificacao> findAll(){
        return repository.findAll();
    }
}
