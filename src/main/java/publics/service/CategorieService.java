package publics.service;

import publics.model.Categorie;
import publics.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import publics.model.Categorie;
import publics.repository.CategorieRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository repo;

    public ArrayList<Categorie> GetAll() {
        return new ArrayList<Categorie>(repo.findAll());
    }
}
