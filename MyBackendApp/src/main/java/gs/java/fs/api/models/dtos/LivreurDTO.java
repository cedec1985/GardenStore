package gs.java.fs.api.models.dtos;
import gs.java.fs.domain.entities.Livreur;

public record LivreurDTO(
        Long id,
        String nom,
        String prénom,
        String nomContact,
        String email,
        String societe

) {
    public static LivreurDTO fromEntity(Livreur livraison) {
        if (livraison == null)
            return null;

        return new LivreurDTO(
                livraison.getId(),
                livraison.getNom(),
                livraison.getPrénom(),
                livraison.getNomContact(),
                livraison.getEmail(),
                livraison.getSociete()
                );
    }
}