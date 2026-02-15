package br.com.anacarolina.gestao_vagas.modules.company.controllers;

import br.com.anacarolina.gestao_vagas.modules.company.entities.CompanyEntities;
import br.com.anacarolina.gestao_vagas.modules.company.usecases.CreateCompanyUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {
    
    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntities companyEntities){
        try{
            var result =  this.createCompanyUseCase.execute(companyEntities);
            return ResponseEntity.ok().body(result);
        }catch(Exception e){
        e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
