package br.com.anacarolina.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
@Entity(name = "job")
public class JobEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String description;
    @NotBlank(message = "O campo título é obrigatório")
    private String level;
    private String benefits;

    @ManyToOne()
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private CompanyEntities companyEntities;

    @Column (name="company_id", nullable = false)
    private UUID companyId;


    @CreationTimestamp
    private LocalDateTime createdAt;
    
}
