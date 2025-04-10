package org.example.sitoillogico.model.dao;

import org.example.sitoillogico.model.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteDao extends JpaRepository<Utente,Long> {

    Utente findByUsernameAndPassword(String username,String password);
}
