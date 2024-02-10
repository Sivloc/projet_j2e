package tsi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import tsi.models.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Participant findByEmail(String email);
}
