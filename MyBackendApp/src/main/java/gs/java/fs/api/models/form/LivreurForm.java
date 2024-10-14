package gs.java.fs.api.models.form;

import gs.java.fs.domain.entities.Livreur;
import jakarta.validation.constraints.NotBlank;

public record LivreurForm(
        @NotBlank
        String nom,
        @NotBlank
        String prénom,
        @NotBlank
        String email,
        @NotBlank
        String nom_contact,
        @NotBlank
        String societe

) {
    public Livreur toEntity(){
        Livreur livreur = new Livreur();
        livreur.setNom( nom );
        livreur.setPrénom(prénom);
        livreur.setEmail(email);
        livreur.setNomContact(nom_contact);
        livreur.setSociete(societe);
        return livreur;
    }
}

