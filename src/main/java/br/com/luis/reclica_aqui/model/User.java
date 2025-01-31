package br.com.luis.reclica_aqui.model;


import br.com.luis.reclica_aqui.dto.user.UserRegisterDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

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

    public User(UserRegisterDTO userRegister) {
        this.fullName = userRegister.fullName();
        this.email = userRegister.email();
        this.birthDay = userRegister.birthDay();
        this.gender = userRegister.gender();
        this.cpf = userRegister.cpf();
        this.phoneNumber = userRegister.phoneNumber();
        this.password = userRegister.password();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
