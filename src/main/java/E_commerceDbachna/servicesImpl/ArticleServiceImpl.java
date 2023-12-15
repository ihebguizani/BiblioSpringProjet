package E_commerceDbachna.servicesImpl;

import E_commerceDbachna.models.Article;
import E_commerceDbachna.models.Categorie;
import E_commerceDbachna.models.User;
import E_commerceDbachna.repositories.ArticleRepo;
import E_commerceDbachna.serviceInterfaces.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepo articleRepo;

    @Override
    public Article create(Article article) {
        return articleRepo.save(article);
    }

    @Override
    public Article getArticleById(Long id) {

        Optional<Article> optionalArticle = articleRepo.findById(id);
        if (optionalArticle.isPresent()){
            return optionalArticle.get();
        }
        return null;
    }

    @Override
    public List<Article> getAllArticle() {
        return articleRepo.findAll();
    }

    @Override
    public List<Article> deleteArticleById(Long id) {
        articleRepo.deleteById(id);
        return getAllArticle();
    }
    @Override
    public Article updateArt(Article article){
        return articleRepo.save(article);
    }
    @Override
    public List<Article> findArticlesByUser(User user) {
        return articleRepo.findArticlesByUser(user);
    }

    @Override
    public List<Article> findArticlesByCategorie(Categorie categorie) {
        return articleRepo.findArticlesByCategorie(categorie);
    }

}
