package E_commerceDbachna.controller;

import E_commerceDbachna.models.*;
import E_commerceDbachna.repositories.ArticleRepo;
import E_commerceDbachna.servicesImpl.ArticleServiceImpl;
import E_commerceDbachna.servicesImpl.CategorieServiceIplm;
import E_commerceDbachna.servicesImpl.ImageServiceImpl;
import E_commerceDbachna.servicesImpl.UserServiceImpl;
import javassist.bytecode.ByteArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ArticleController {
    @Autowired
    private ArticleServiceImpl articleService;
    @Autowired
    private CategorieServiceIplm categorieService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ArticleRepo articleRepo;

    @GetMapping("/article/{id}")
    public Article getById(@PathVariable Long id) {
        Article article = articleService.getArticleById(id);
        return article;
    }


    @GetMapping("/articles")
    public List<ArticleDTO> getAll() {
        List<ArticleDTO> articleDTOS = new ArrayList<>();
        List<Article> articles = articleService.getAllArticle();
        articles.forEach(article -> {
            articleDTOS.add(ArticleDTO.getArticleDTOFromArticle(article));
        });
        return articleDTOS;
    }

    @GetMapping("/test")
    public String test() {
        return "test is working";
    }

    @PostMapping("/articleCreat")
    public Article create(@RequestBody ArticleDTO articledDto) {
        Article article = ArticleDTO.getArticleFromDTO(articledDto);
        byte[] imageBytes = articledDto.getImageBase64().getBytes();
        long categoryID = Long.parseLong(articledDto.getCategoryId());
        Categorie categorie = categorieService.getCategorieById(categoryID);
        article.setCategorie(categorie);
        long userId = Long.parseLong(articledDto.getUserId());
        User user = userService.getUserById(userId);
        article.setImage(imageBytes);
        article.setUser(user);

        return articleService.create(article);
    }

    @GetMapping("/article/delete/{id}")
    public List<Article> deleteById(@PathVariable Long id) {
        Article article = getById(id);
        article.setCategorie(null);
        article.setUser(null);
        Article x = articleRepo.save(article);
        articleRepo.delete(x);
        return articleService.getAllArticle();
    }

    @PutMapping("/article/update/{id}")
    public void updateArticle(@PathVariable Long id, @RequestBody Article article1) {
        Article article = getById(id);
        article.setNomArticle(article1.getNomArticle());
        article.setPrix(article1.getPrix());
        article.setDescription(article1.getDescription());
        articleRepo.save(article);

    }





    @GetMapping("/user/{userId}")
    public List<ArticleDTO> getArticlesByUser(@PathVariable Long userId) {
        User user = new User();  // Assuming you have a User entity and can create a user object by ID
        user.setUserId(userId);
        List<ArticleDTO> articleDTOS = new ArrayList<>();
        List<Article> articles = articleService.findArticlesByUser(user);
        articles.forEach(article -> {
            articleDTOS.add(ArticleDTO.getArticleDTOFromArticle(article));
        });
        return articleDTOS;
    }

    @GetMapping("/categorie/{categorieId}")
    public List<Article> getArticlesByCategorie(@PathVariable Long idCategorie) {
        Categorie categorie = new Categorie();  // Assuming you have a Categorie entity and can create a categorie object by ID
        categorie.setIdCategorie(idCategorie);
        return articleService.findArticlesByCategorie(categorie);
    }
}



