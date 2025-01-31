package br.com.luis.reclica_aqui.service;


import br.com.luis.reclica_aqui.dto.alert.AlertRequestDTO;
import br.com.luis.reclica_aqui.dto.alert.AlertResponseDTO;
import br.com.luis.reclica_aqui.model.Alert;
import br.com.luis.reclica_aqui.model.User;
import br.com.luis.reclica_aqui.repository.AlertRepository;
import br.com.luis.reclica_aqui.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class AlertService {

    private final AlertRepository repository;
    private final UserRepository userRepository;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @Transactional
    public AlertResponseDTO create(AlertRequestDTO alertRequest) {

        User user = userRepository.findById(alertRequest.userId()).orElseThrow(() -> new RuntimeException("Usuário não foi encontrado"));

        Alert newAlert = new Alert(alertRequest);

        newAlert.setUser(user);

        Alert savedAlert = repository.save(newAlert);

        return new AlertResponseDTO(
                savedAlert.getId(),
                savedAlert.getLatitude(),
                savedAlert.getLongitude(),
                savedAlert.getCategory(),
                savedAlert.getStatus(),
                savedAlert.getDescription(),
                savedAlert.getCreationDate().format(formatter)
        );
    }


}
