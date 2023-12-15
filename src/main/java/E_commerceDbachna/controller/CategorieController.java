package E_commerceDbachna.controller;

import E_commerceDbachna.models.Categorie;
import E_commerceDbachna.servicesImpl.CategorieServiceIplm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CategorieController {
    @Autowired
    private CategorieServiceIplm categorieService;

    @PostMapping("/categorieCreat")
    public Categorie createcategorie(@RequestBody Categorie categorie){
        return categorieService.createcategorie(categorie);
    }
    @GetMapping("/categories")
    public List<Categorie> getAllCategorie(){
        return categorieService.getAllCategorie();
    }
    @GetMapping("/categorie/{id}")
    public Categorie getById(@PathVariable Long id){
        Categorie categorie = categorieService.getCategorieById(id);
        return categorie;
    }
    @GetMapping("/article/categorie/{id}")
    public List<Categorie> deleteById(@PathVariable Long id){
        return categorieService.deleteCategorieById(id);
    }
    @PutMapping("/categorie/update/{id}")
    public void updateCategorie(@PathVariable Long id, @RequestBody Categorie categorie){
        categorie.setIdCategorie(id);
        categorieService.updateCategorie(categorie);

    }
}
