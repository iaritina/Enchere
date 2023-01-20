package publics.repository;
import org.springframework.data.jpa.repository.Query;
import publics.model.Enchere;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnchereRepository extends JpaRepository<Enchere,String> {
    @Query(value = "select * from v_enchere",nativeQuery = true)
    List<Enchere> nonVendue();

    @Query(value = "select * from v_bestsaleEnchere",nativeQuery = true)
    Enchere bestSale();

    @Query(value = "select * from v_nbrVente",nativeQuery = true)
    int nombreVente();
}


