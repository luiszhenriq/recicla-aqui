package br.com.luis.reclica_aqui.repository;

import br.com.luis.reclica_aqui.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    UserDetails findByEmail(String email);

    User findUserByEmail(String email);
}
