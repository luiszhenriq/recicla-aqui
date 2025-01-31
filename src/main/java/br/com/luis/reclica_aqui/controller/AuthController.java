package br.com.luis.reclica_aqui.controller;

import br.com.luis.reclica_aqui.dto.user.UserLoginDTO;
import br.com.luis.reclica_aqui.dto.user.UserRegisterDTO;
import br.com.luis.reclica_aqui.dto.user.UserResponseDTO;
import br.com.luis.reclica_aqui.infra.security.TokenJWT;
import br.com.luis.reclica_aqui.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRegisterDTO register) {
        return new ResponseEntity<>(service.register(register), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenJWT> login(@RequestBody UserLoginDTO login) {
        String tokenJWT = service.login(login);
        return ResponseEntity.ok(new TokenJWT(tokenJWT));
    }
}
