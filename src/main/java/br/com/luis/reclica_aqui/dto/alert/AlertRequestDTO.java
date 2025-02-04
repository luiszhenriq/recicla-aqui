package br.com.luis.reclica_aqui.dto.alert;

import br.com.luis.reclica_aqui.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record AlertRequestDTO(

        @NotNull(message = "Este campo não pode ser nulo")
        UUID userId,

        @NotNull(message = "Este campo não pode ser nulo")
        Double latitude,

        @NotNull(message = "Este campo não pode ser nulo")
        Double longitude,

        @NotNull(message = "Este campo não pode ser nulo")
        Category category,

        @NotBlank(message = "Este campo não pode ser vazio")
        String description,

        LocalDateTime creationDate) {
}
