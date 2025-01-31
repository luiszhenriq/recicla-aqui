package br.com.luis.reclica_aqui.repository;

import br.com.luis.reclica_aqui.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlertRepository extends JpaRepository<Alert, UUID> {
}
