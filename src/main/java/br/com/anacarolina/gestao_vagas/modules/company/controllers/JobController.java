package br.com.anacarolina.gestao_vagas.modules.company.controllers;

import br.com.anacarolina.gestao_vagas.modules.company.dto.CreateJobDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.anacarolina.gestao_vagas.modules.company.entities.JobEntities;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.anacarolina.gestao_vagas.modules.company.usecases.CreateJobUseCase;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;


@RestController
@RequestMapping("/company/job")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping("/")
    @PreAuthorize(("hasRole('COMPANY')"))
    public JobEntities create (@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request) {
        var companyId = request.getAttribute("company_id");

//        jobEntities.setCompanyId(UUID.fromString(companyId.toString()));

       var jobEntities = JobEntities.builder()
                .benefits(createJobDTO.getBenefits())
                .companyId(UUID.fromString(companyId.toString()))
                .description(createJobDTO.getDescription())
                .level(createJobDTO.getLevel())
                .build(); //cria uma instancia de job entities

        return this.createJobUseCase.execute(jobEntities);
    }
}