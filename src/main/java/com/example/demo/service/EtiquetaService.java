package com.example.demo.service;

import com.example.demo.domain.Camisa;
import com.example.demo.domain.Etiqueta;
import com.example.demo.repository.CamisaRepository;
import com.example.demo.repository.EtiquetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtiquetaService {
    EtiquetaRepository repository;

    public EtiquetaService(EtiquetaRepository repository) {
        this.repository = repository;
    }

    public Etiqueta create(Etiqueta c){
        return repository.save(c);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Etiqueta update(Etiqueta c){
        return repository.saveAndFlush(c);
    }

    public Optional<Etiqueta> findById(Long id){
        return repository.findById(id);
    }

    public List<Etiqueta> findAll(){
        return repository.findAll();
    }
}
