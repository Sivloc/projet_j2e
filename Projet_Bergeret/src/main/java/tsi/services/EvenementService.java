// EvenementService.java
package tsi.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tsi.models.Evenement;
import tsi.models.Participant;
import tsi.repositories.EvenementRepository;

import java.util.List;

@Service
public class EvenementService {
    @Autowired
    private EvenementRepository evenementRepository;

    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }

    public Evenement createEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    public Evenement getEvenementById(Long id) {
        return evenementRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        evenementRepository.deleteById(id);
    }

    public void inscrireParticipant(Participant participant ,Long id) {
        Evenement evenement = evenementRepository.findById(id).orElse(null);
        if (evenement != null) {
            evenement.addParticipant(participant);
            evenementRepository.save(evenement);
        }
    }
}
