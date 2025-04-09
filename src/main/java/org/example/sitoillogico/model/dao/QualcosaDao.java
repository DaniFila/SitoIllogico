package org.example.sitoillogico.model.dao;

import org.example.sitoillogico.model.entities.Qualcosa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QualcosaDao extends JpaRepository<Qualcosa,Long> {

    @Query("select q from Qualcosa q where q.c=org.example.sitoillogico.model.enums.Enumeratore.BBB")
    List<Qualcosa> filtroBBB();

}
