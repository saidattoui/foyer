package tn.esprit.foyer.services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.configuration.EntityNotFoundExceptionById;
import tn.esprit.foyer.entities.Etudiant;
import tn.esprit.foyer.entities.Reservation;
import tn.esprit.foyer.repository.EtudiantRepository;
import tn.esprit.foyer.repository.FoyerRepository;
import tn.esprit.foyer.repository.ReservationRepository;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class EtudiantServiceImpl implements  IEtudiantService{


    EtudiantRepository etudiantRepository;
    FoyerRepository foyerRepository;
    ReservationRepository reservationRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        Etudiant e = etudiantRepository.findById(idEtudiant).orElse(null);
        return e;
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        if (!etudiantRepository.existsById(idEtudiant)) {
            throw new EntityNotFoundExceptionById("Invlaid Id Etudiant was provided");
        }
            etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        Etudiant e = Etudiant.builder().ecole("esprit").nomEt("aaa").build();
        List<Etudiant> etudiants1 =  etudiantRepository.saveAll(etudiants);
        return etudiants1;
    }

    @Override
    public Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, String idReservation) {
        Etudiant e = etudiantRepository.findByNomEtAndPrenomEt( nomEt, prenomEt);
           Reservation r = reservationRepository.findById(idReservation).get();
           r.getEtudiants().add(e);
           reservationRepository.save(r);
            return e;

    }
}
