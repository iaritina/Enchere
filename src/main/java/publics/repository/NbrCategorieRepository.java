package publics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import publics.model.NbrCategorie;

public interface NbrCategorieRepository extends JpaRepository<NbrCategorie,String> {
}
