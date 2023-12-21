package Biblio.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanDTO {
    private String userId;
    private String idBook;
    private Long idLoan;
    private LocalDate startDate;
    private LocalDate endDate;

    public static Loan getLoanDto(LoanDTO loanDTO){
        Loan loan = new Loan();
        loan.setIdLoan(loanDTO.getIdLoan());
        loan.setStartDate(loanDTO.getStartDate());
        loan.setEndDate(loanDTO.getEndDate());
        return loan;
    }
}
