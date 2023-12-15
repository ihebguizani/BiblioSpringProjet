package E_commerceDbachna.repositories;

import E_commerceDbachna.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CommandeRepo extends JpaRepository<Commande,Long> {
}
