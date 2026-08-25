package br.com.anacarolina.gestao_vagas.modules.candidate.useCases;

import br.com.anacarolina.gestao_vagas.modules.candidate.entity.ApplyJobEntity;
import br.com.anacarolina.gestao_vagas.modules.candidate.repository.ApplyJobRepository;
import br.com.anacarolina.gestao_vagas.modules.candidate.repository.CandidateRepository;
import br.com.anacarolina.gestao_vagas.modules.company.repository.JobRepository;
import br.com.anacarolina.gestao_vagas.modules.exceptions.JobNotFoundException;
import br.com.anacarolina.gestao_vagas.modules.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    // id do candidato
    //id da vaga
    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {
        this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });
        // validar se o candidato existe
        this.candidateRepository.findById(idCandidate).orElseThrow(() -> {
            throw new UserNotFoundException();

        });
        //validar se a vaga existe
        this.jobRepository.findById(idJob)
                .orElseThrow(() -> {
                    throw new JobNotFoundException();
                });

        //candidato se inscrever na vaga
        var applyJob = ApplyJobEntity.builder()
                .candidateId(idCandidate)
                .jobId(idJob).build();

        applyJob = applyJobRepository.save(applyJob);
        return applyJob;
    }
}