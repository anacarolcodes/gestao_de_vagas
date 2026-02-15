package br.com.anacarolina.gestao_vagas.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;  
import br.com.anacarolina.gestao_vagas.modules.company.entities.JobEntities;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.anacarolina.gestao_vagas.modules.company.usecases.CreateJobUseCase;
import org.springframework.web.bind.annotation.PostMapping;
    


@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping("/")
    public JobEntities create (@Valid @RequestBody JobEntities jobEntities) {
        return this.createJobUseCase.execute(jobEntities);
    }
}