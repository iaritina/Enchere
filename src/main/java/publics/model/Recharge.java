package publics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "demandecredit")
public class Recharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddm", nullable = false)
    private Long iddm;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "iduser")
    private Utilisateur utilisateur;

    @Column(name = "periode")
    private Date periode;

    @Column(name = "somme")
    private Long somme;

}
