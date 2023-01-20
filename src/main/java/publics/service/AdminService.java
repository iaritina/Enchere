package publics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import publics.model.Admin;
import publics.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repo;

    public Admin log(Admin admin) {
        return Admin.auth(admin, repo.findAll());
    }
}
