package com.example.demo.dto;

import com.example.demo.controller.EtiquetaController;
import com.example.demo.domain.Etiqueta;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class EtiquetaResponseDTO extends RepresentationModel<EtiquetaResponseDTO> {

    String nome;

    public void addHateoasLinks(Long id ){
        this.add(linkTo(EtiquetaController.class).slash(id).withSelfRel());
        this.add(linkTo(EtiquetaController.class).withRel("GET"));
        this.add(linkTo(EtiquetaController.class).slash(id).withRel("DELETE"));
        this.add(linkTo(EtiquetaController.class).slash(id).withRel("PUT"));
        this.add(linkTo(EtiquetaController.class).withRel("POST"));
       }
}
