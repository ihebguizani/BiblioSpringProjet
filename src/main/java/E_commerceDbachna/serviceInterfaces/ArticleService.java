package E_commerceDbachna.serviceInterfaces;

import E_commerceDbachna.models.Article;

import java.util.List;

public interface ArticleService {
    Article create(Article article);
    Article getArticleById(Long id);
    List<Article> getAllArticle();
    List<Article> deleteArticleById(Long id);

    Article updateArt(Article article);
}
