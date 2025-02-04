package br.com.luis.reclica_aqui.dto.user;

import br.com.luis.reclica_aqui.model.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UserRegisterDTO(
        @NotBlank(message = "Este campo não pode ser vazio")
        String fullName,

        @NotBlank(message = "Este campo não pode ser vazio")
        @Email
        String email,

        @NotNull(message = "Este campo não pode ser nulo")
        LocalDate birthDay,

        @NotNull(message = "Este campo não pode ser nulo")
        Gender gender,

        @NotBlank(message = "Este campo não pode ser vazio")
        String cpf,

        @NotBlank(message = "Este campo não pode ser vazio")
        String phoneNumber,

        @NotBlank(message = "Este campo não pode ser vazio")
        String password) {
}
