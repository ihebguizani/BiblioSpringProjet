package E_commerceDbachna.repositories;

import E_commerceDbachna.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepo extends JpaRepository<Article,Long> {
}
