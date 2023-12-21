package Biblio.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Id
    private Long idBook;

    private String title;
    private String author;
    private String isbn;
    private LocalDate publicationDate;
    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;


}
