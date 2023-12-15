package E_commerceDbachna.servicesImpl;


import E_commerceDbachna.models.Commande;
import E_commerceDbachna.repositories.CommandeRepo;
import E_commerceDbachna.serviceInterfaces.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeRepo commandeRepo;
    @Override
    public Commande create(Commande commande){
        return this.commandeRepo.save(commande);
    }
    @Override
    public List<Commande> getAllCommande(){
        return commandeRepo.findAll();
    }
    @Override
    public Commande getCommandeById(Long idCommande){
        Optional<Commande> optionalCommande = commandeRepo.findById(idCommande);
        if (optionalCommande.isPresent()){
            return optionalCommande.get();
        }
        return null;
    }

}
