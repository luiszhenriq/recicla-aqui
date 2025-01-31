package br.com.luis.reclica_aqui.dto;

import br.com.luis.reclica_aqui.model.Category;

import java.time.LocalDateTime;
import java.util.UUID;

public record AlertRequestDTO(
        UUID userId,

        Double latitude,

        Double longitude,

        Category category,

        String description,

        LocalDateTime creationDate) {
}
