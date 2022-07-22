package com.example.demo.dto;

import com.example.demo.controller.ClassificacaoController;
import com.example.demo.domain.Classificacao;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class ClassificacaoResponseDTO extends RepresentationModel<ClassificacaoResponseDTO> {

    String nome;

    public void addHateoasLinks(Long id ){
        this.add(linkTo(ClassificacaoController.class).slash(id).withSelfRel());
        this.add(linkTo(ClassificacaoController.class).withRel("GET"));
        this.add(linkTo(ClassificacaoController.class).slash(id).withRel("DELETE"));
        this.add(linkTo(ClassificacaoController.class).slash(id).withRel("PUT"));
        this.add(linkTo(ClassificacaoController.class).withRel("POST"));
       }
}
