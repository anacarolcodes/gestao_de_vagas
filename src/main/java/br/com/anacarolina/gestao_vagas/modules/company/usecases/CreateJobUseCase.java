
package br.com.anacarolina.gestao_vagas.modules.company.usecases;
import org.springframework.beans.factory.annotation.Autowired;      
import org.springframework.stereotype.Service;
import br.com.anacarolina.gestao_vagas.modules.company.entities.JobEntities;
import br.com.anacarolina.gestao_vagas.modules.company.repository.JobRepository;

@Service // camada regra de negocio
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    public JobEntities execute (JobEntities jobEntities) {
      return this.jobRepository.save(jobEntities);
     }
}