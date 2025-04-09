package org.example.sitoillogico.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sitoillogico.model.enums.Enumeratore;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Qualcosa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long a;
    private String b;
    @Enumerated(EnumType.STRING)
    private Enumeratore c;
    private LocalDate d;

    @OneToMany(mappedBy = "qualcosa",fetch = FetchType.EAGER)
    private List<Altro> altri;
}
