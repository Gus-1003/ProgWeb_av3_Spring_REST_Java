package com.example.demo.dto;

import com.example.demo.controller.CamisaController;
import com.example.demo.domain.Camisa;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class CamisaResponseDTO extends RepresentationModel<CamisaResponseDTO> {

    String nome;


    public void addHateoasLinks(Long id ){
        this.add(linkTo(CamisaController.class).slash(id).withSelfRel());
        this.add(linkTo(CamisaController.class).withRel("GET"));
        this.add(linkTo(CamisaController.class).slash(id).withRel("DELETE"));
        this.add(linkTo(CamisaController.class).slash(id).withRel("PUT"));
        this.add(linkTo(CamisaController.class).withRel("POST"));
       }
}
