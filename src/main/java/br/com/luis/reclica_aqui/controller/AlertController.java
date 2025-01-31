package br.com.luis.reclica_aqui.controller;


import br.com.luis.reclica_aqui.dto.AlertRequestDTO;
import br.com.luis.reclica_aqui.dto.AlertResponseDTO;
import br.com.luis.reclica_aqui.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chamado")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService service;

    @PostMapping
    public ResponseEntity<AlertResponseDTO> createAlert(@RequestBody AlertRequestDTO request) {
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }
}
