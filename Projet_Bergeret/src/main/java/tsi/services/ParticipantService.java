package tsi.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tsi.models.Evenement;
import tsi.models.Participant;
import tsi.repositories.ParticipantRepository;
import java.util.List;

@Service
public class ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;

    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    public Participant createParticipant(Participant participant) {
        return participantRepository.save(participant);
    }
    public Participant findByEmail(String email) {
        return participantRepository.findByEmail(email);
    }
    public void addParticipant(Participant participant, Evenement evenement) {
        participantRepository.save(participant);
    }
    public void deletebyId(Long id) {
        participantRepository.deleteById(id);
    }

    public Participant findById(Long id) {
        return participantRepository.findById(id).orElse(null);
    }
}
