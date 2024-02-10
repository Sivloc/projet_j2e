package tsi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import tsi.models.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
}
