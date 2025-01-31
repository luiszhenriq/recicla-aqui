package br.com.luis.reclica_aqui.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String fullName;

    private String email;

    private LocalDate birthDay;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String cpf;

    private String phoneNumber;

    private String password;
}
