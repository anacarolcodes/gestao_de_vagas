package br.com.anacarolina.gestao_vagas.modules.company.repository;

import br.com.anacarolina.gestao_vagas.modules.company.entities.CompanyEntities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface CompanyRepository extends JpaRepository<CompanyEntities, UUID> {
    Optional<CompanyEntities> findByUsernameOrEmail(String username, String email);

    Optional<CompanyEntities> findByUsername(String username);
}