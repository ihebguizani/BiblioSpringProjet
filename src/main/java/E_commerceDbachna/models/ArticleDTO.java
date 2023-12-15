package E_commerceDbachna.models;

import lombok.Data;

@Data
public class ArticleDTO {
    private Long idArticle;
    private double prix;
    private String nomArticle;
    private String categoryId;
    private String userId;
    private String idImage;
    private String description;
    private String imageBase64;


    public static Article getArticleFromDTO(ArticleDTO articleDTO){
        Article article = new Article();
        article.setIdArticle(articleDTO.getIdArticle());
        article.setNomArticle(articleDTO.getNomArticle());
        article.setPrix(articleDTO.getPrix());
        article.setDescription(articleDTO.getDescription());
        return article;
    }

    public static ArticleDTO getArticleDTOFromArticle(Article article){
        ArticleDTO articleDto = new ArticleDTO();
        articleDto.setIdArticle(article.getIdArticle());
        articleDto.setNomArticle(article.getNomArticle());
        articleDto.setPrix(article.getPrix());
        articleDto.setDescription(article.getDescription());
        if(article.getImage() != null){
            articleDto.setImageBase64(new String(article.getImage()));
        }
        return articleDto;
    }
}

