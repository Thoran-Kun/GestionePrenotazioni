package com.example.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="prenotazioni")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @ManyToOne
    @JoinColumn(name="utente_username")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name="postazione_codice")
    private Postazione postazione;

    @Column(nullable = false)
    private LocalDate dataPrenotazione;

    public Prenotazione(Utente utente, Postazione postazione, LocalDate dataPrenotazione) {
        this.utente = utente;
        this.postazione = postazione;
        this.dataPrenotazione = dataPrenotazione;
    }
}
