package br.com.anacarolina.gestao_vagas.modules.candidate.useCases;

import br.com.anacarolina.gestao_vagas.modules.company.entities.JobEntities;
import br.com.anacarolina.gestao_vagas.modules.company.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllJobsByFilterUseCase {

    @Autowired
    private JobRepository jobRepository;

    public List<JobEntities> execute(String filter) {
        return this.jobRepository.findByDescriptionContainingIgnoreCase(filter);
    }
}
