package Biblio.controller;

import Biblio.models.Book;
import Biblio.models.Loan;
import Biblio.models.LoanDTO;
import Biblio.models.User;
import Biblio.servicesImpl.BookServiceIpml;
import Biblio.servicesImpl.LoanServiceImpl;
import Biblio.servicesImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
    @Autowired
    private LoanServiceImpl loanServiceImpl;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private BookServiceIpml bookServiceIpml;

    @PostMapping("/addLoan")
    public Loan addLoan(@RequestBody LoanDTO loanDTO){
        Loan loan = LoanDTO.getLoanDto(loanDTO);
        Long userId = Long.parseLong(loanDTO.getUserId());
        Long idBook = Long.parseLong(loanDTO.getIdBook());
        Book book = bookServiceIpml.getByIdBook(idBook);
        User user = userService.getUserById(userId);
        loan.setUser(user);
        loan.setBook(book);

        return loanServiceImpl.addLoan(loan);
    }

}
