package org.example.sitoillogico.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Altro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long e;
    private String f;

    @ManyToOne
    @JoinColumn(name = "id_qualcosa")
    private Qualcosa qualcosa;


}
