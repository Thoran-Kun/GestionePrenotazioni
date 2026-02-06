package com.example.GestionePrenotazioni.runners;

import com.example.GestionePrenotazioni.entities.Edificio;
import com.example.GestionePrenotazioni.entities.Utente;
import com.example.GestionePrenotazioni.services.EdificioService;
import com.example.GestionePrenotazioni.services.PostazioneService;
import com.example.GestionePrenotazioni.services.PrenotazioneService;
import com.example.GestionePrenotazioni.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerPrenotazioni implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private PostazioneService postazioneService;

    @Override
    public void run(String... args) throws Exception {

        //inizio popolando le tabelle nel DB con le mie Entity
        Edificio edificio = new Edificio("Colosseo", "via Roma Capitale", "Roma");
        edificioService.saveEdificio(edificio);
    }
}
