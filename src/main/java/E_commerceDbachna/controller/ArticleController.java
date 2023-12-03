package E_commerceDbachna.controller;

import E_commerceDbachna.models.Article;
import E_commerceDbachna.models.ArticleDTO;
import E_commerceDbachna.models.Categorie;
import E_commerceDbachna.servicesImpl.ArticleServiceImpl;
import E_commerceDbachna.servicesImpl.CategorieServiceIplm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ArticleController {
    @Autowired
    private ArticleServiceImpl articleService;
    @Autowired
    private CategorieServiceIplm categorieService;



    @GetMapping("/article/{id}")
    public Article getById(@PathVariable Long id){
        Article article = articleService.getArticleById(id);
        return article;
    }

    @GetMapping("/articles")
    public List<Article> getAll(){
        return articleService.getAllArticle();
    }

    @GetMapping("/test")
    public String test(){
        return "test is working";
    }

    @PostMapping("/articleCreat")
    public Article create(@RequestBody ArticleDTO articledDto){
        Article article = ArticleDTO.getArticleFromDTO(articledDto);
        long categoryID = Long.parseLong(articledDto.getCategoryId());
        Categorie categorie = categorieService.getCategorieById(categoryID);
        article.setCategorie(categorie);
        return articleService.create(article);
    }
    @GetMapping("/article/delete/{id}")
    public List<Article> deleteById(@PathVariable Long id){
        return articleService.deleteArticleById(id);
    }
    @PutMapping("/article/update/{id}")
    public void updateArticle(@PathVariable Long id, @RequestBody Article article){
        article.setIdArticle(id);
        articleService.updateArt(article);

    }
}
