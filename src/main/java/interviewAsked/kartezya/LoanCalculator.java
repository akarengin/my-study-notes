package interviewAsked.kartezya;

/*
Welcome to JDoodle!

You can execute code here in 88 languages. Right now you’re in the Java IDE.

  1. Click the orange Execute button ▶ to execute the sample code below and see how it works.

  2. Want help writing or debugging code? Type a query into JDroid on the right hand side ---------------->

  3.Try the menu buttons on the left. Save your file, share code with friends and open saved projects.

Want to change languages? Try the search bar up the top.
*/

import java.util.ArrayList;
import java.util.List;

import static interviewAsked.kartezya.Loan.sum;

interface LoanStrategy {
    void calculate();
}

class CommercialCredit implements LoanStrategy {
    public void calculate() {
        sum += 21;
    }
}

class VehicleCredit implements LoanStrategy {
    public void calculate() {
        sum += 23;
    }
}

class HomeCredit implements LoanStrategy {
    public void calculate() {
        sum += 20;
    }
}

abstract class Loan {
    LoanStrategy loanStrategy;
    static int sum = 0;

    public Loan() {
    }

    public Loan(LoanStrategy loanStrategy) {
        this.loanStrategy = loanStrategy;
    }

    public void calculateLoans() throws UnknownLoanException {
        if (loanStrategy != null) {
            loanStrategy.calculate();
        } else {
            throw new UnknownLoanException();
        }
    }
}

class CommercialCreditLoan extends Loan {
    public CommercialCreditLoan() {
        loanStrategy = new CommercialCredit();
    }
}

class VehicleLoan extends Loan {
    public VehicleLoan() {
        loanStrategy = new VehicleCredit();
    }
}

class HomeLoan extends Loan {
    public HomeLoan() {
        loanStrategy = new HomeCredit();
    }
}

class BankingLoan extends Loan {
    public void calculateLoans(Loan loan) throws UnknownLoanException {
        loan.calculateLoans();
    }
}

class UnknownLoanException extends Exception {
    public UnknownLoanException() {
    }
}

public class LoanCalculator {

    public static void main(String args[]) throws UnknownLoanException {
        List<Loan> loans = new ArrayList<>();
        Loan com = new CommercialCreditLoan();
        Loan vec = new VehicleLoan();
        Loan hom = new HomeLoan();
        Loan bank = new BankingLoan();

        loans.add(com);
        loans.add(vec);
        loans.add(hom);
        loans.add(bank);

        for (Loan loan : loans) {
            loan.calculateLoans();
        }
        System.out.println("Total sum: " + sum);
    }


    // Could you please refactor the code below according to the object oriented principle to make it cleaner?
    public static double calculateLoans(List<Object> loans) throws UnknownLoanException {
        for (Object loan : loans) {
            if (loan instanceof CommercialCreditLoan tf) {
                sum += 21;
            } else if (loan instanceof VehicleLoan xs) {
                sum += 23;
            } else if (loan instanceof HomeLoan xmf) {
                sum += 20;
            } else
                throw new UnknownLoanException();
        }
        return sum;
    }

}
