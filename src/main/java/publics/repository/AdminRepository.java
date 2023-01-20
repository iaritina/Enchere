package publics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import publics.model.Admin;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,String> {
}
