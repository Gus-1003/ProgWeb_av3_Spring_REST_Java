package com.example.demo.controller;



import com.example.demo.domain.Classificacao;
import com.example.demo.dto.ClassificacaoRequestDTO;
import com.example.demo.dto.ClassificacaoResponseDTO;
import com.example.demo.service.ClassificacaoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classificação")
@CrossOrigin(origins = "*")
public class ClassificacaoController {

   ClassificacaoService service;
    ModelMapper modelMapper = new ModelMapper();


    public ClassificacaoController(ClassificacaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Classificacao> findAll(){
        return service.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<ClassificacaoResponseDTO> findById(@PathVariable Long id){
        Optional<Classificacao> c  = service.findById(id);
        if (c.isPresent()){
            Classificacao classificacao = c.get();
            ClassificacaoResponseDTO classificacaoResponseDto = modelMapper.map(classificacao, ClassificacaoResponseDTO.class);
            classificacaoResponseDto.addHateoasLinks(classificacao.getId());

            return ResponseEntity.ok().body(classificacaoResponseDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Classificacao> insert(@RequestBody ClassificacaoRequestDTO c) throws URISyntaxException {
        Classificacao novo = modelMapper.map(c, Classificacao.class);
        service.create(novo);
        URI uri = new URI("/classificação/" + novo.getId());
        return ResponseEntity.created(uri).build();
    }



    @PutMapping("/{id}")
    public ResponseEntity<Classificacao> update (@PathVariable Long id, @RequestBody Classificacao c){
        if (service.findById(id).isPresent()){
            Classificacao atualizado = service.update(c);
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
