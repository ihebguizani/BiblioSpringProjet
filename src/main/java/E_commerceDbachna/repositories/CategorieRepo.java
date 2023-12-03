package E_commerceDbachna.repositories;

import E_commerceDbachna.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepo extends JpaRepository<Categorie,Long> {
}
