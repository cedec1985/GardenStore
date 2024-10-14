package gs.java.fs.api.models.form;

import gs.java.fs.domain.entities.Description;
import gs.java.fs.domain.entities.Produit;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProduitForm (

    @NotBlank
    String nom,
    @Valid
    @NotNull
    Integer reference,
    @NotNull
    Integer prixDeVente,
     @NotNull
    Long id,
     @NotNull
    Integer stock,
     @NotBlank
    String avis,
    @NotBlank
    Description categorie
    )
{
    public Produit toEntity(){
        Produit produit = new Produit();
        produit.setNom( nom );
        produit.setReference(reference);
         produit.setPrixDeVente(prixDeVente);
         produit.setId(id);
         produit.setStock(stock);
         produit.setAvis(avis);
         produit.setCategorie(categorie);
        return produit;
    }
}
