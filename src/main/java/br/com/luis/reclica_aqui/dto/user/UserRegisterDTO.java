package br.com.luis.reclica_aqui.dto.user;

import br.com.luis.reclica_aqui.model.Gender;

import java.time.LocalDate;

public record UserRegisterDTO(
        String fullName,

        String email,

        LocalDate birthDay,

        Gender gender,

        String cpf,

        String phoneNumber,

        String password) {
}
