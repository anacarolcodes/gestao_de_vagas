package br.com.anacarolina.gestao_vagas.modules.controllers;

import br.com.anacarolina.gestao_vagas.modules.candidate.candidateEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @PostMapping("/")
    public void create(@RequestBody @Valid candidateEntity candidateEntity){
        System.out.println("Candidato");
        System.out.println(candidateEntity.getEmail());
    }


}