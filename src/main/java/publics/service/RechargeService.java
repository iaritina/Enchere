package publics.service;

import org.springframework.beans.factory.annotation.Autowired;
import publics.repository.*;
import publics.model.*;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class RechargeService {
    @Autowired
    private RechargeRepository repo;
    public ArrayList<Recharge> findAll(){
        return new ArrayList<Recharge>(repo.notCheck());
    }
}
