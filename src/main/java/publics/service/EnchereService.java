package publics.service;
import org.springframework.beans.factory.annotation.Autowired;
import publics.repository.*;
import publics.model.*;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class EnchereService {
    @Autowired
    private EnchereRepository repo;
    public ArrayList<Enchere> findAll(){
        return new ArrayList<Enchere>(repo.findAll());
    }
    public ArrayList<Enchere> findNotSale(){
        return new ArrayList<Enchere>(repo.nonVendue());
    }
    public Enchere bestSale(){
        return repo.bestSale();
    }
    public int enchereNbr(){
        return repo.nombreVente();
    }
}
