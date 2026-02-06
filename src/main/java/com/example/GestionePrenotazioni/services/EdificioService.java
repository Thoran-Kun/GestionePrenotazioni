package com.example.GestionePrenotazioni.services;

import com.example.GestionePrenotazioni.entities.Edificio;
import com.example.GestionePrenotazioni.repositories.EdificioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EdificioService {

    private final EdificioRepository edificioRepository;

    @Autowired
    public EdificioService(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

   public void saveEdificio(Edificio newEdificio){
        this.edificioRepository.save(newEdificio);
        log.info("l'edificio " + newEdificio.getNome() + " è stato salvato correttamente nel DB!");
   }

}
