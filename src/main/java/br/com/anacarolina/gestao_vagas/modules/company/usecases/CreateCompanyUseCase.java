package br.com.anacarolina.gestao_vagas.modules.company.usecases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.anacarolina.gestao_vagas.modules.company.repository.CompanyRepository;
import br.com.anacarolina.gestao_vagas.modules.company.entities.CompanyEntities;
import br.com.anacarolina.gestao_vagas.modules.exceptions.UserFoundException;

@Service // camada regra de negocio 
public class CreateCompanyUseCase {

        @Autowired
        private CompanyRepository companyRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

    public CompanyEntities execute(CompanyEntities companyEntities){

        this.companyRepository
        .findByUsernameOrEmail(companyEntities.getUsername(), companyEntities.getEmail())
        .ifPresent((user) -> {
            throw new UserFoundException();
        });

        var passwordEncoder = this.passwordEncoder.encode(companyEntities.getPassword());
        companyEntities.setPassword(passwordEncoder);

      return this.companyRepository.save(companyEntities);
    }
}

