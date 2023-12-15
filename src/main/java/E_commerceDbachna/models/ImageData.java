package E_commerceDbachna.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "ImageData")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageData {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;

    private String name;
    @Lob
    @Column(name = "imagedata",length = 1000)
    private byte[] imageData;
    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.MERGE}, fetch=FetchType.EAGER)
    @JoinColumn(name = "idArticle", nullable = false)
    private Article article;


}