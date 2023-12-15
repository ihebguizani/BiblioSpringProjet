package E_commerceDbachna.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticle;
    private double prix;
    private String nomArticle;
    private String description;
    private byte[] image;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCategorie", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Categorie categorie;
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.MERGE}, fetch=FetchType.EAGER)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

}
