package E_commerceDbachna.serviceInterfaces;

import E_commerceDbachna.models.Categorie;

import java.util.List;

public interface CategorieService {
    Categorie createcategorie(Categorie categorie);
    List<Categorie> getAllCategorie();
    Categorie getCategorieById(Long id);
    List<Categorie> deleteCategorieById(Long id);
    Categorie updateCategorie(Categorie categorie);
}
