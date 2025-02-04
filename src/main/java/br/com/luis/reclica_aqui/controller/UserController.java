package br.com.luis.reclica_aqui.controller;


import br.com.luis.reclica_aqui.dto.user.UserResponseDTO;
import br.com.luis.reclica_aqui.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/perfil")
    public ResponseEntity<UserResponseDTO> perfil() {
        return new ResponseEntity<>(service.profile(), HttpStatus.OK);
    }
}
