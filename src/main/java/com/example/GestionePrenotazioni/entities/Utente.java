package com.example.GestionePrenotazioni.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="utenti")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Utente {
    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(name="mail",nullable = false)
    private String mail;

    public Utente(String username, String nomeCompleto, String mail) {
        this.username = username;
        this.nomeCompleto = nomeCompleto;
        this.mail = mail;
    }
}
