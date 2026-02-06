package com.example.GestionePrenotazioni.repositories;

import com.example.GestionePrenotazioni.entities.Edificio;
import com.example.GestionePrenotazioni.entities.Postazione;
import com.example.GestionePrenotazioni.entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, String> {
    List<Postazione> findByTipoPostazioneAndEdificioCitta(TipoPostazione tipoPostazione, String citta);
}
