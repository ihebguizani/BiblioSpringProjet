package Biblio.serviceInterfaces;

import Biblio.models.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    List<Book> getAllBook();
    Book getByIdBook(Long idBook);
    Book updateBook(Book book);
    List<Book> deleteBook(Long idBook);
     List<Book> searchBooks(String title, String author, Long idCategorie);
}
