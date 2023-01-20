package publics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import publics.model.TokenAge;

public interface TokenAgeRepository extends JpaRepository<TokenAge,String> {
}
