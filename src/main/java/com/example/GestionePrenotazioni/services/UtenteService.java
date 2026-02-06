package com.example.GestionePrenotazioni.services;

import com.example.GestionePrenotazioni.entities.Utente;
import com.example.GestionePrenotazioni.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UtenteService {

    private final UtenteRepository utenteRepository;


    @Autowired
    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public void saveUtente(Utente newUtente){
        this.utenteRepository.save(newUtente);
        log.info("l'utente con nome: " + newUtente.getNomeCompleto() + " è salvato correttamente nel DB!");
    }
}





