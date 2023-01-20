package publics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import publics.model.NbrCategorie;
import publics.repository.NbrCategorieRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NbrCategorieService {
    @Autowired
    private NbrCategorieRepository repo;

    public List<NbrCategorie> list(){
        return repo.findAll();
    }
}
