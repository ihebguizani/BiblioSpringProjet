package E_commerceDbachna.controller;

import E_commerceDbachna.models.*;
import E_commerceDbachna.repositories.CommandeRepo;
import E_commerceDbachna.servicesImpl.ArticleServiceImpl;
import E_commerceDbachna.servicesImpl.CommandeServiceImpl;
import E_commerceDbachna.servicesImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CommandeController {
    @Autowired
    private CommandeServiceImpl commandeService;
    @Autowired
    private ArticleServiceImpl articleService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CommandeRepo commandeRepo;

    @GetMapping("/allCommande")
    public List<Commande> getAllCommande(){
        return commandeService.getAllCommande();
    }
    @GetMapping("/commandeById/{id}")
    public Commande getCommandeById(@PathVariable Long idCommande){
        Commande commande = commandeService.getCommandeById(idCommande);
        return commande;
    }
    @PostMapping("/createCommande")
    public Commande create(@RequestBody CommandeDTO commandeDTO){
        Commande commande = CommandeDTO.getCommandeDto(commandeDTO);
        long idArticle = Long.parseLong(commandeDTO.getIdArticle());
        Article article = articleService.getArticleById(idArticle);
        commande.setArticle(article);
        long userId = Long.parseLong(commandeDTO.getUserId());
        User user = userService.getUserById(userId);
        commande.setUser(user);
        commandeRepo.save(commande);
        return commandeService.create(commande);
    }

}
