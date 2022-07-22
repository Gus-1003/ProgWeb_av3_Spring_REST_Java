package com.example.demo.service;

import com.example.demo.domain.Camisa;
import com.example.demo.repository.CamisaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CamisaService {
    CamisaRepository repository;

    public CamisaService(CamisaRepository repository) {
        this.repository = repository;
    }

    public Camisa create(Camisa c){
        return repository.save(c);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Camisa update(Camisa c){
        return repository.saveAndFlush(c);
    }

    public Optional<Camisa> findById(Long id){
        return repository.findById(id);
    }

    public List<Camisa> findAll(){
        return repository.findAll();
    }
}
