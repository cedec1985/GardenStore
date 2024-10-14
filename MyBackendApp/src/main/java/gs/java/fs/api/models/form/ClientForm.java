package gs.java.fs.api.models.form;

import gs.java.fs.api.validation.constraints.Password;
import gs.java.fs.domain.entities.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientForm(
        @NotBlank
        String nom,
        @Password
        String password,
        @NotBlank
        String prenom,
        @NotBlank
        String mail,
        @NotNull
        Integer telephone,
        @Valid
        AddresseForm addresse

) {
    public Client ToEntity(){
        Client client = new Client();
        client.setNom( nom );
        client.setPassword( password );
        client.setAddresse(addresse.toEntity());
        client.setMail(mail);
        client.setPrenom(prenom);
        client.setTelephone(telephone);
        client.setPrenom(prenom);
        return client;
    }

}
