package com.example.GestionePrenotazioni.services;

import com.example.GestionePrenotazioni.entities.Postazione;
import com.example.GestionePrenotazioni.entities.TipoPostazione;
import com.example.GestionePrenotazioni.repositories.PostazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostazioneService {

    private final PostazioneRepository postazioneRepository;

    @Autowired
    public PostazioneService(PostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }

    public void savePostazione(Postazione newPostazione){
        this.postazioneRepository.save(newPostazione);
        log.info("la postazione " + newPostazione.getDescrizione() + " è stata salvata correttamente nel DB!");
    }

    //ricerco della postazione per tipo e per città
    public List<Postazione> ricercaPostazioni(TipoPostazione tipoPostazione, String citta){
        log.info("ricerca della postazione: ", tipoPostazione, citta);
        return postazioneRepository.findByTipoAndEdificioCitta(tipoPostazione, citta);
    }
}
