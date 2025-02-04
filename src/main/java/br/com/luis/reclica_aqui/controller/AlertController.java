package br.com.luis.reclica_aqui.controller;


import br.com.luis.reclica_aqui.dto.alert.AlertRequestDTO;
import br.com.luis.reclica_aqui.dto.alert.AlertResponseDTO;
import br.com.luis.reclica_aqui.service.AlertService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamado")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService service;

    @PostMapping
    public ResponseEntity<AlertResponseDTO> createAlert(@RequestBody @Valid AlertRequestDTO request) {
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    @GetMapping("/meus-alertas")
    public ResponseEntity<List<AlertResponseDTO>> getAllAlertsByUser() {
        return new ResponseEntity<>(service.getAlertsByUser(), HttpStatus.OK);
    }
}
