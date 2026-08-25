package br.com.anacarolina.gestao_vagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobDTO {

    @Schema(example = "Vaga para pessoa desenvolveora júnior",
    requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    @NotNull
    private String description;
    @Schema(example = "GymPass, Plano de saúde",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    @NotNull
    private String benefits;
    @Schema(example = "JUNIOR",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    @NotNull
    private String level;
}
