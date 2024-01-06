package tn.esprit.foyer.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idEtudiant; // Clé primaire
     String nomEt;
     String prenomEt;
     Long cin;
     String ecole;
     LocalDate dateNaissance;


    @ManyToMany(mappedBy = "etudiants",fetch = FetchType.LAZY)
    List<Reservation> reservations;

    public Etudiant(String nomEt, String prenomEt, String ecole) {
        this.nomEt = nomEt;
        this.prenomEt = prenomEt;
        this.ecole = ecole;
    }
}

