package E_commerceDbachna.serviceInterfaces;

import E_commerceDbachna.models.Article;
import E_commerceDbachna.models.Categorie;
import E_commerceDbachna.models.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {
    Article create(Article article);
    Article getArticleById(Long id);
    List<Article> getAllArticle();
    List<Article> deleteArticleById(Long id);

    Article updateArt(Article article);

     List<Article> findArticlesByUser(User user);
     List<Article> findArticlesByCategorie(Categorie categorie);

}
