package com.example.demo.controller;



import com.example.demo.domain.Camisa;
import com.example.demo.dto.CamisaRequestDTO;
import com.example.demo.dto.CamisaResponseDTO;
import com.example.demo.service.CamisaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/camisa")
@CrossOrigin(origins = "*")
public class CamisaController {

   CamisaService service;
    ModelMapper modelMapper = new ModelMapper();


    public CamisaController(CamisaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Camisa> findAll(){
        return service.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<CamisaResponseDTO> findById(@PathVariable Long id){
        Optional<Camisa> c  = service.findById(id);
        if (c.isPresent()){
            Camisa cliente = c.get();
            CamisaResponseDTO clienteResponseDto = modelMapper.map(cliente, CamisaResponseDTO.class);
            clienteResponseDto.addHateoasLinks(cliente.getId());

            return ResponseEntity.ok().body(clienteResponseDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Camisa> insert(@RequestBody CamisaRequestDTO c) throws URISyntaxException {
        Camisa novo = modelMapper.map(c, Camisa.class);
        service.create(novo);
        URI uri = new URI("/camisa/" + novo.getId());
        return ResponseEntity.created(uri).build();
    }



    @PutMapping("/{id}")
    public ResponseEntity<Camisa> update (@PathVariable Long id, @RequestBody Camisa c){
        if (service.findById(id).isPresent()){
            Camisa atualizado = service.update(c);
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
