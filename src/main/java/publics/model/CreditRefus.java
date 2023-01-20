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
@Table(name = "creditrefus")
public class CreditRefus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcredrefuse", nullable = false)
    private Long idcredrefuse;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "iddm")
    private Recharge recharge;

}
