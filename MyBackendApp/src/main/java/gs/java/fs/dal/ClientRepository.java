package gs.java.fs.dal;

import gs.java.fs.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

   @Query("select c from Client c where c.mail = :email")
   Optional<Client> findClientByEmail(String email);

}