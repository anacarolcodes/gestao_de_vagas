
package br.com.anacarolina.gestao_vagas.modules.company.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.anacarolina.gestao_vagas.modules.company.entities.JobEntities; 
    

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntities, UUID> {

}