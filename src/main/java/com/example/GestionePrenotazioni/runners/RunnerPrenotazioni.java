package com.example.GestionePrenotazioni.runners;

import com.example.GestionePrenotazioni.entities.*;
import com.example.GestionePrenotazioni.services.EdificioService;
import com.example.GestionePrenotazioni.services.PostazioneService;
import com.example.GestionePrenotazioni.services.PrenotazioneService;
import com.example.GestionePrenotazioni.services.UtenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
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
        Edificio edificio = new Edificio(
                "Colosseo",
                "via Roma Capitale",
                "Roma");
        edificioService.saveEdificio(edificio);

        Utente utente = new Utente(
                "thor4n_Kun",
                "SalvatorePepe",
                "salvo@mail.it");
        utenteService.saveUtente(utente);

        Utente utente1 = new Utente(
                "Spider-man",
                "PeterParker",
                "spider@man.com");
        utenteService.saveUtente(utente1);

        Postazione postazione = new Postazione(
                "A001",
                "Tavolo di lavoro smart",
                TipoPostazione.OPENSPACE,
                4, edificio);
        postazioneService.savePostazione(postazione);

        //testo qualche risultato con la logica e vedo che succede in console
        LocalDate dataPre = LocalDate.now().plusDays(5);

        log.info("--- TENTATIVO 1: dovrebbe essere valida ---");
        Prenotazione prenotazione = new Prenotazione(utente, postazione, dataPre);
        prenotazioneService.savePrenotazione(prenotazione);

        log.info("--- TENTATIVO 2: stessa postazione ma con utente diverso (NON deve andare a buon fine) ---");
        Prenotazione prenotazione1 = new Prenotazione(utente1, postazione, dataPre);
        prenotazioneService.savePrenotazione(prenotazione1);

        log.info("--- TENTATIVO 3: stesso utente ma postazione diversa, anche questa dovrebbe fallire ---");
        //per far questo devo creare una nuova postazione di lavoro ma richiamare lo stesso utente
        Postazione postazione1 = new Postazione(
                "A002",
                "sala Riunioni",
                TipoPostazione.SALA_RIUNIONI,
                100,
                edificio);
        postazioneService.savePostazione(postazione1);

        Prenotazione prenotazione2 = new Prenotazione(utente, postazione1, dataPre);
        prenotazioneService.savePrenotazione(prenotazione2);

        // ricerco le postazioni
        log.info("--- RICERCA POSTAZIONI ---");
        postazioneService.ricercaPostazioni(TipoPostazione.OPENSPACE, "Roma")
                .forEach(p -> System.out.println("postazione trovata: " + p.getDescrizione()));
    }
}
