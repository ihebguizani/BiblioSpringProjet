package E_commerceDbachna.servicesImpl;

import E_commerceDbachna.models.Categorie;
import E_commerceDbachna.repositories.CategorieRepo;
import E_commerceDbachna.serviceInterfaces.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceIplm implements CategorieService {
    @Autowired
    private CategorieRepo categorieRepo;
    @Override
    public Categorie createcategorie(Categorie categorie) {
        return categorieRepo.save(categorie);
    }
    @Override
    public List<Categorie> getAllCategorie() {
        return categorieRepo.findAll();
    }
    @Override
    public Categorie getCategorieById(Long id){
        Optional<Categorie> optionalCategorie = categorieRepo.findById(id);
        if (optionalCategorie.isPresent()){
            return optionalCategorie.get();
        }
        return null;
    }
    @Override
    public List<Categorie> deleteCategorieById(Long id) {
        categorieRepo.deleteById(id);
        return getAllCategorie();
    }
    @Override
    public Categorie updateCategorie(Categorie categorie){
        return categorieRepo.save(categorie);
    }
}
