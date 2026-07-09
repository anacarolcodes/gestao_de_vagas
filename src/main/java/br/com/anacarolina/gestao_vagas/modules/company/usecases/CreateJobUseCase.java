
package br.com.anacarolina.gestao_vagas.modules.company.usecases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import br.com.anacarolina.gestao_vagas.modules.company.entities.JobEntities;
import br.com.anacarolina.gestao_vagas.modules.company.repository.JobRepository;

import java.util.UUID;

@Service // camada regra de negocio
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    public JobEntities execute(JobEntities jobEntities) {
        // 1. Pega o ID da empresa que o seu SecurityFilter extraiu do token e salvou no contexto
        var auth = SecurityContextHolder.getContext().getAuthentication();

        // 2. O auth.getName() aqui vai retornar o Subject do Token (o ID que vimos na sua AuthUseCase)
        if (auth != null) {
            jobEntities.setCompanyId(UUID.fromString(auth.getName()));
        }

        // 3. Agora sim, com o ID preenchido, o banco aceita salvar
        return this.jobRepository.save(jobEntities);
    }
}