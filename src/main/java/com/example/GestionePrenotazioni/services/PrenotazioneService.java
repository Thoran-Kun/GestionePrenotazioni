package com.example.GestionePrenotazioni.services;

import com.example.GestionePrenotazioni.entities.Prenotazione;
import com.example.GestionePrenotazioni.repositories.PrenotazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;

    @Autowired
    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public void savePrenotazione(Prenotazione newPrenotazione){
        this.prenotazioneRepository.save(newPrenotazione);
        log.info("la prenotazione: " + newPrenotazione.toString() + " è stata salvata correttamente nel DB");
    }


}
