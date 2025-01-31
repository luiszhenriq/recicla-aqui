package br.com.luis.reclica_aqui.dto.alert;

import br.com.luis.reclica_aqui.model.Category;
import br.com.luis.reclica_aqui.model.Status;

import java.util.UUID;

public record AlertResponseDTO(
        UUID id,

        Double latitude,

        Double longitude,

        Category category,

        Status status,

        String description,

        String creationDate) {
}
