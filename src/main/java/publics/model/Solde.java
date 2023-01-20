package publics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "soldeuser")
public class Solde {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsolde", nullable = false)
    private Long idsolde;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "iduser")
    private Utilisateur utilisateur;

    @Column(name = "periode")
    private Timestamp periode;

    @Column(name = "somme")
    private int somme;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "iddm")
    private Recharge recharge;
}
