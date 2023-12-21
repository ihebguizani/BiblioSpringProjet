package Biblio.servicesImpl;

import Biblio.models.Book;
import Biblio.repositories.BookRepo;
import Biblio.serviceInterfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceIpml implements BookService {
    @Autowired
    private BookRepo bookRepo;
    @Override
    public Book createBook(Book book){
        return bookRepo.save(book);
    }
    @Override
    public List<Book> getAllBook(){
        return bookRepo.findAll();
    }
    @Override
    public List<Book> deleteBook(Long idBook){
        bookRepo.deleteById(idBook);
        return getAllBook();
    }
    @Override
    public Book updateBook(Book book){
        return bookRepo.save(book);
    }
    @Override
    public Book getByIdBook(Long idBook){
        Optional<Book> optionalBook = bookRepo.findById(idBook);
        if (optionalBook.isPresent()){
            return optionalBook.get();
        }
        return null;
    }
    @Override
    public List<Book> searchBooks(String title, String author, Long idCategorie){
        if (title != null && author != null && idCategorie != null) {
            return bookRepo.findByTitleAndAuthorAndAndCategorieIdCategorie(title, author, idCategorie);
        } else if (title != null && author != null) {
            return bookRepo.findByTitleAndAndAuthor(title,author);
        } else if (title != null && idCategorie != null) {
            return bookRepo.findByTitleAndCategorieIdCategorie(title, idCategorie);
        } else if (author != null && idCategorie != null) {
            return bookRepo.findByAuthorAndCategorieIdCategorie(author, idCategorie);
        } else if (title != null) {
            return bookRepo.findByTitle(title);
        } else if (author != null) {
            return bookRepo.findByAuthor(author);
        } else if (idCategorie != null) {
            return bookRepo.findByCategorieIdCategorie(idCategorie);
        } else {
            return bookRepo.findAll();
        }
    }


}
