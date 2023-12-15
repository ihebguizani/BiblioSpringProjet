package E_commerceDbachna.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CommandeDTO {
    private String userId;
    private String idArticle;
    private Long idCommande;
    private LocalDate dateCommande;
    private String address;
    private Double prix;
    private String phone;
    public static Commande getCommandeDto(CommandeDTO commandeDTO){
        Commande commande = new Commande();
        commande.setIdCommande(commandeDTO.getIdCommande());
        commande.setDateCommande(commandeDTO.getDateCommande());
        commande.setPrix(commandeDTO.getPrix());
        commande.setAddress(commandeDTO.getAddress());
        commande.setPhone(commandeDTO.getPhone());
        return commande;
    }
}
