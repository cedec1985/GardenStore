package gs.java.fs.api.models.dtos;

import gs.java.fs.domain.entities.Addresse;
import gs.java.fs.domain.entities.Client;

public record ClientDTO(
        Long id,
        String nom,
        String prenom,
        Addresse addresse,
        String mail,
        Integer telephone
        ) {

    public static ClientDTO fromEntity(Client client) {
        if (client == null)
            return null;

        return new ClientDTO(
                client.getId(),
                client.getNom(), client.getMail(), client.getAddresse(), client.getPrenom(), client.getTelephone()
        );
    }

}