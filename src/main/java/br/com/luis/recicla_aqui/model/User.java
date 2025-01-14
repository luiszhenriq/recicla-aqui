package br.com.luis.recicla_aqui.model;


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

    private Gender gender;

    private String cpf;

    private String phoneNumber;

    private String profilePhoto;

    private String password;
}
