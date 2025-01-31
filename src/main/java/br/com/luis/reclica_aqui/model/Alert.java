package br.com.luis.reclica_aqui.model;


import br.com.luis.reclica_aqui.dto.AlertRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "alerts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Double latitude;

    private Double longitude;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ABERTO;

    private String description;

    private LocalDateTime creationDate;

    public Alert(AlertRequestDTO request) {
        this.latitude = request.latitude();
        this.longitude = request.longitude();
        this.category = request.category();
        this.description = request.description();
        this.creationDate = LocalDateTime.now();
    }
}
