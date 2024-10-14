package gs.java.fs.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Long id;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "prix_de_vente", nullable = false)
    private Integer prixDeVente;

    @Column(name = "stock", nullable = false, updatable = true, insertable = true)
    private Integer stock;

    @Enumerated(EnumType.STRING)
    @Column(name = "catégorie", updatable = true, nullable = false, insertable = true)
    private Description categorie;

    @Column(name = "avis", nullable = false, length = 250)
    private String avis;

    @Column(name = "référence", nullable = false, length = 250)
    private Integer reference;


}

