package E_commerceDbachna.serviceInterfaces;

import E_commerceDbachna.models.Article;
import E_commerceDbachna.models.Commande;

import java.util.List;

public interface CommandeService {
    Commande create(Commande commande);
    List<Commande> getAllCommande();
    Commande getCommandeById(Long idCommande);
}
