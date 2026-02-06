package com.example.GestionePrenotazioni.repositories;

import com.example.GestionePrenotazioni.entities.Postazione;
import com.example.GestionePrenotazioni.entities.Prenotazione;
import com.example.GestionePrenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);

    boolean existsByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);
}
