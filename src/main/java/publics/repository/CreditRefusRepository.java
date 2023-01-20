package publics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import publics.model.CreditRefus;

public interface CreditRefusRepository extends JpaRepository<CreditRefus,Long> {
}
