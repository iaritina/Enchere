package publics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import publics.model.Token;
import publics.repository.TokenRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TokenService {
    @Autowired
    public TokenRepository tokenRepository;
    public Token save(Token  tk){
        tokenRepository.save(tk);
        return tk;
    }
    public Boolean verification(String valeur, List<Token> tk) throws Exception{
        if(valeur==null){
            return false;
        }
        Optional<Token> deleteToken = tokenRepository.findById(valeur);
        for(int w=0;w<tk.size();w++){
            if(tk.get(w).getValeur().compareToIgnoreCase(valeur)==0)
                return Token.verification(tk.get(w).getDateexpiration());
        }
        return false;
    }
}
