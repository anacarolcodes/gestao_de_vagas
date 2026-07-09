
package br.com.anacarolina.gestao_vagas.modules.company.repository;

import br.com.anacarolina.gestao_vagas.modules.company.entities.JobEntities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntities, UUID> {

    // "contains - LIKE "

    // Select * from job where description like %filter% (começo, no fim ou em qualquer lugar)

    List<JobEntities> findByDescriptionContaining(String filter);


}