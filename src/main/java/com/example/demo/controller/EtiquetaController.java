package com.example.demo.controller;


import com.example.demo.domain.Etiqueta;
import com.example.demo.dto.EtiquetaRequestDTO;
import com.example.demo.dto.EtiquetaResponseDTO;
import com.example.demo.service.EtiquetaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/etiqueta")
@CrossOrigin(origins = "*")
public class EtiquetaController {

    EtiquetaService service;
    ModelMapper modelMapper = new ModelMapper();


    public EtiquetaController(EtiquetaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Etiqueta> findAll(){
        return service.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<EtiquetaResponseDTO> findById(@PathVariable Long id){
        Optional<Etiqueta> c  = service.findById(id);
        if (c.isPresent()){
            Etiqueta etiqueta = c.get();
            EtiquetaResponseDTO etiquetaResponseDto = modelMapper.map(etiqueta, EtiquetaResponseDTO.class);
            etiquetaResponseDto.addHateoasLinks(etiqueta.getId());

            return ResponseEntity.ok().body(etiquetaResponseDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Etiqueta> insert(@RequestBody EtiquetaRequestDTO c) throws URISyntaxException {
        Etiqueta novo = modelMapper.map(c, Etiqueta.class);
        service.create(novo);
        URI uri = new URI("/etiqueta/" + novo.getId());
        return ResponseEntity.created(uri).build();
    }



    @PutMapping("/{id}")
    public ResponseEntity<Etiqueta> update (@PathVariable Long id, @RequestBody Etiqueta c){
        if (service.findById(id).isPresent()){
            Etiqueta atualizado = service.update(c);
            return ResponseEntity.ok().body(atualizado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id ){
        if (service.findById(id).isPresent()){
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
