package gs.java.fs.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "livreur", schema = "public")
public class Livreur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "livreur_id", nullable = false,insertable = false, updatable = false)
    private Long id;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "\"prénom\"", nullable = false, length = 50)
    private String prénom;

    @Column(name ="mail", length = 25)
    private String email;

    @Column(name = "nom_contact", nullable = false, length = 50)
    private String nomContact;

    @Column(name ="societe", nullable = false, length = 25)
    private String societe;

    @OneToMany (mappedBy = "deliveredBy")
    private List<Commande> commandes;


}