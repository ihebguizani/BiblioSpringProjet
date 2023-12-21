package Biblio.controller;

import Biblio.models.Book;
import Biblio.servicesImpl.BookServiceIpml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookServiceIpml bookServiceIpml;

    @PostMapping("/addBook")
    public Book createBook(@RequestBody Book book){
        return bookServiceIpml.createBook(book);
    }
    @GetMapping("/books")
    public List<Book> getAllBook(){
        return bookServiceIpml.getAllBook();
    }
    @GetMapping("/updateBook/{idBook}")
    public Book updateBook(@PathVariable Long idBook, @RequestBody Book book){
        book.setIdBook(idBook);
        return  bookServiceIpml.updateBook(book);
    }
    @GetMapping("/deleteBook/{idBook}")
    public List<Book> deleteBook(@PathVariable Long idBook){
        return bookServiceIpml.deleteBook(idBook);
    }
    @GetMapping("/bookById/{idBook}")
    public Book getByIdBook(@PathVariable Long idBook){
        return bookServiceIpml.getByIdBook(idBook);
    }
    @GetMapping()
    public List<Book> searchBooks(@RequestParam String title,
                                  @RequestParam String auther,
                                  @RequestParam Long idCategorie){
        return bookServiceIpml.searchBooks(title, auther, idCategorie);
    }
}
