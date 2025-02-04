package br.com.luis.reclica_aqui.service;


import br.com.luis.reclica_aqui.dto.user.UserLoginDTO;
import br.com.luis.reclica_aqui.dto.user.UserRegisterDTO;
import br.com.luis.reclica_aqui.dto.user.UserResponseDTO;
import br.com.luis.reclica_aqui.infra.security.TokenService;
import br.com.luis.reclica_aqui.model.User;
import br.com.luis.reclica_aqui.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final AuthenticationManager manager;
    private final TokenService tokenService;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserResponseDTO register(UserRegisterDTO userRegister) {

        if (this.repository.findByEmail(userRegister.email()) != null) {
            throw new RuntimeException("Este email já está cadastrado");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(userRegister.password());

        User newUser = new User(userRegister);

        newUser.setPassword(encryptedPassword);

        User savedUser = repository.save(newUser);

        return userResponseDTO(savedUser);
    }

    public String login(UserLoginDTO userLogin) {

        User user = (User) repository.findByEmail(userLogin.email());

        if (!this.passwordEncoder.matches(userLogin.password(), user.getPassword())) {
            throw new RuntimeException("Senha inválida");
        }

        var token = new UsernamePasswordAuthenticationToken(userLogin.email(), userLogin.password());
        var auth = manager.authenticate(token);

        return tokenService.generateToken((User) auth.getPrincipal());
    }

    public UserResponseDTO profile() {

        User user = repository.findUserByEmail(getAuthenticatedUser());

        return userResponseDTO(user);
    }

    private String getAuthenticatedUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }


    private UserResponseDTO userResponseDTO(User user) {

        return new UserResponseDTO(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getBirthDay(),
                user.getGender(),
                user.getCpf(),
                user.getPhoneNumber()
        );
    }
}
