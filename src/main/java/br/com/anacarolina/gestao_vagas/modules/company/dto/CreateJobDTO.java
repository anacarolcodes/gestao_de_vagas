package br.com.anacarolina.gestao_vagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateJobDTO {

    @Schema(example = "Vaga para pessoa desenvolveora júnior",
    requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;
    @Schema(example = "GymPass, Plano de saúde",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String benefits;
    @Schema(example = "JUNIOR",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String level;
}
