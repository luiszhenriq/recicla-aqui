package br.com.luis.reclica_aqui.repository;

import br.com.luis.reclica_aqui.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
