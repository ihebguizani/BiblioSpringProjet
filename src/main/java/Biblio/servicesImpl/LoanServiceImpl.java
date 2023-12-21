package Biblio.servicesImpl;

import Biblio.models.Loan;
import Biblio.repositories.LoanRepo;
import Biblio.serviceInterfaces.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanRepo loanRepo;
    @Override
    public Loan addLoan(Loan loan) {
        return loanRepo.save(loan);
    }
}
