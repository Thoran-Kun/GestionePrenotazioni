package com.example.GestionePrenotazioni.services;

import com.example.GestionePrenotazioni.entities.Prenotazione;
import com.example.GestionePrenotazioni.exceptions.ValidationException;
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
//        this.prenotazioneRepository.save(newPrenotazione);
//        log.info("la prenotazione: " + newPrenotazione.toString() + " è stata salvata correttamente nel DB");
//        if(newPrenotazione == null){
//            throw new ValidationException("errore nel salvataggio della prenotazione :(");
//        }
//        this.prenotazioneRepository.save(newPrenotazione);
//        log.info("la prenotazione: " + newPrenotazione.toString() + " è stata salvata correttamente nel DB");
    //1. controllo se la postazione è già occupata per quella data
        //mi tornerà un booleano true o false in caso. Entro nella postazione Repository e controllo tramite metodo
        //se la postazione è occupata dando come parametro nella funzione creata nella repository la postazione appunto
        //e la data.
        boolean postazioneOccupata = prenotazioneRepository.existsByPostazioneAndDataPrenotazione(
                newPrenotazione.getPostazione(),newPrenotazione.getDataPrenotazione()
        );

        if(postazioneOccupata){
            log.error("impossibile salvare la prenotazione: la postazione {} è già occupata in data {}",
                  newPrenotazione.getPostazione().getCodiceUnivoco(),
                  newPrenotazione.getDataPrenotazione());
            return; // facendo così uscirò dal metodo senza salvare
        }

        //2. la traccia ci chiede che un utente può avere solo una prenotazione per giornata
        // quidni ora dovrò controllare che l'utente appunto non ha prenotato già per quella data
        boolean utenteOccupato = prenotazioneRepository.existsByUtenteAndDataPrenotazione(
                newPrenotazione.getUtente(),
                newPrenotazione.getDataPrenotazione()
        );

        if(utenteOccupato){
            log.error("impossibile salvare perchè l'utente {} ha già una prenotazione in carico per quella data {}",
                    newPrenotazione.getUtente().getUsername(),
                    newPrenotazione.getDataPrenotazione());
            return;
        }

        // adesso che ho stabilito i criteri per i quali un utente può prenotare una postazione
        //posso salvare nel DB

        prenotazioneRepository.save(newPrenotazione);
        log.info("la prenotazione: {} è stata salvata correttamente :)", newPrenotazione);
    }
}
