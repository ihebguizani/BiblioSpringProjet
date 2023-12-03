package E_commerceDbachna.models;

import lombok.Data;

@Data
public class ArticleDTO {
    private Long idArticle;
    private double prix;
    private String nomArticle;
    private String categoryId;
    private String description;


    public static Article getArticleFromDTO(ArticleDTO articleDTO){
        Article article = new Article();
        article.setIdArticle(articleDTO.getIdArticle());
        article.setNomArticle(articleDTO.getNomArticle());
        article.setPrix(articleDTO.getPrix());
        article.setDescription(articleDTO.getDescription());
        return article;
    }
}

