package gs.java.fs.domain.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "commande", schema = "public")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commande_id", nullable = false)
    private Long id;

    @Column(name = "montant", nullable = false, precision = 5, scale = 2) // scale =  2 chiffres après la virgule
    private Integer montant;

    @Column(name = "date_commande", nullable = false)
    private LocalDate dateCommande;

    @Column(name = "quantité", nullable = false)
    private Integer quantite;

    @Column(name = "n_commande", nullable = false)
    private Integer nCommande;

    @ManyToOne
    private Livreur deliveredBy;
}
