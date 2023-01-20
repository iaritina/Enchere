package publics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import publics.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
}
