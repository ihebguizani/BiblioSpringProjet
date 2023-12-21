package Biblio.repositories;

import Biblio.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String auther);
    List<Book> findByCategorieIdCategorie(Long idCategorie);
    List<Book> findByTitleAndAndAuthor(String title,String auther);
    List<Book> findByTitleAndCategorieIdCategorie(String title,Long idCategorie);
    List<Book> findByAuthorAndCategorieIdCategorie(String auther,Long idCategorie);
    List<Book> findByTitleAndAuthorAndAndCategorieIdCategorie(String title,String auther,Long idCategorie);
}
