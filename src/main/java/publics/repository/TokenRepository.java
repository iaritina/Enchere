package publics.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import publics.model.Recharge;
import publics.model.Token;

import java.util.List;

public interface TokenRepository extends JpaRepository<Token,String> {
    @Modifying
    @Transactional
    @Query(value = "delete from token where idadmin=:id", nativeQuery = true)
    void expire(int id);
    @Modifying
    @Transactional
    @Query(value = "delete from token where valeur=:value", nativeQuery = true)
    void deconnex(String value);

}
