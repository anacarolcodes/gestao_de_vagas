package br.com.anacarolina.gestao_vagas.modules.company.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "job")
public class JobEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "Vaga para design")
    private String description;
    @NotBlank(message = "O campo título é obrigatório")

    @Schema(example = "SENIOR")
    private String level;

    @Schema(example = "Gympass, PLano de saúde")
    private String benefits;

//    @ManyToOne()
//    @JoinColumn(name = "company_id", insertable = false, updatable = false)
//    private CompanyEntities companyEntities;

    @Column(name = "company_id", nullable = false)
    private UUID companyId;


    @CreationTimestamp
    private LocalDateTime createdAt;

}
