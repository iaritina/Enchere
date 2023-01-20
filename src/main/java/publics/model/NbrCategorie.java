package publics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "v_catnombre")
public class NbrCategorie {

    @Id
    private int idcategorie;
    @Column(name="count")
    private int count;
    @Column(name = "designation")
    private String designation;
}
