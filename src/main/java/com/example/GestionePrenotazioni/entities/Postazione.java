package com.example.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="postazioni")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Postazione {
    @Id
    private String codiceUnivoco;

    @Column(nullable = false)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPostazione tipoPostazione;

    @Column(nullable = false)
    private int maxOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    public Postazione(String codiceUnivoco, String descrizione, TipoPostazione tipoPostazione, int maxOccupanti, Edificio edificio) {
        this.codiceUnivoco = codiceUnivoco;
        this.descrizione = descrizione;
        this.tipoPostazione = tipoPostazione;
        this.maxOccupanti = maxOccupanti;
        this.edificio = edificio;
    }
}
