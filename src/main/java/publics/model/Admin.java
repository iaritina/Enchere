package publics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idadmin;

    @Column(name ="email")
    private String email;
    @Column(name ="mdp")
    private String mdp;
    public static Admin auth(Admin admin, List<Admin> list){
        for(int r=0;r<list.size();r++){
            Admin comp=(Admin)list.get(r);
            if(comp.getEmail().compareToIgnoreCase(admin.getEmail())==0&&comp.getMdp().compareTo(admin.getMdp())==0)
                return comp;
        }
        return null;
    }
}
