package com.example.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="edifici")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String indirizzo;

    @Column(nullable = false)
    private String citta;

    public Edificio(long id, String nome, String indirizzo, String citta) {
        this.id = id;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }
}
