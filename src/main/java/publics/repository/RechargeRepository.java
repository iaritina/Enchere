package publics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import publics.model.Enchere;
import publics.model.Recharge;

import java.util.List;

public interface RechargeRepository extends JpaRepository<Recharge,String> {
    @Query(value = "select * from v_recharge",nativeQuery = true)
    List<Recharge> notCheck();
}
