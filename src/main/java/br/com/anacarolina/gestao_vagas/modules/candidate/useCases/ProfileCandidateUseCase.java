package br.com.anacarolina.gestao_vagas.modules.candidate.useCases;

import br.com.anacarolina.gestao_vagas.modules.candidate.repository.CandidateRepository;
import br.com.anacarolina.gestao_vagas.modules.company.dto.ProfileCandidateResponseDTO;
import br.com.anacarolina.gestao_vagas.modules.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        var candidateDTO = ProfileCandidateResponseDTO.builder()
                .description(candidate.getDescription())
                .username(candidate.getUsername())
                .email(candidate.getEmail())
                .name(candidate.getName())
                .id(candidate.getId())
                .build();
        return candidateDTO;
    }
}
