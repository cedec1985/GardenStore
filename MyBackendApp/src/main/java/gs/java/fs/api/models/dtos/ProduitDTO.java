package gs.java.fs.api.models.dtos;

import gs.java.fs.domain.entities.Description;
import gs.java.fs.domain.entities.Produit;


public record ProduitDTO(Long id,
                         String nom,

                         Integer reference,
                         Integer prixDeVente,

                         Integer stock,

                         String avis,

                         Description categorie

                         )
{
    public static ProduitDTO fromEntity(Produit produit) {
        if (produit == null)
            return null;

        return new ProduitDTO(
                produit.getId(),
                produit.getNom(),
                produit.getReference(),
                produit.getPrixDeVente(),
                produit.getStock(),
                produit.getAvis(),
                produit.getCategorie()
                );
    }

}