package E_commerceDbachna.repositories;

import E_commerceDbachna.models.Article;
import E_commerceDbachna.models.Categorie;
import E_commerceDbachna.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepo extends JpaRepository<Article,Long> {
    List<Article> findArticlesByUser(User user);
    List<Article> findArticlesByCategorie(Categorie categorie);
}
