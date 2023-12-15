package E_commerceDbachna.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    private String address;
    private Double prix;
    private String phone;
    private LocalDate dateCommande;
    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.MERGE}, fetch=FetchType.EAGER)
    @JoinColumn(name = "idArticle", nullable = false)
    private Article article;
    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.MERGE}, fetch=FetchType.EAGER)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

}
