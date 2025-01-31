package br.com.luis.reclica_aqui.dto.user;

import br.com.luis.reclica_aqui.model.Gender;

import java.time.LocalDate;
import java.util.UUID;

public record UserResponseDTO(
        UUID id,

        String fullName,

        String email,

        LocalDate birthDay,

        Gender gender,

        String cpf,

        String phoneNumber
) {
}
