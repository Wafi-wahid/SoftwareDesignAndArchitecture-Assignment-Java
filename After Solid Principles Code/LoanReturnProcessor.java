
import java.util.Date;

public class LoanReturnProcessor {
    public void processReturn(Loan loan, Staff receiver, Date returnDate) {
        loan.setReturnedDate(returnDate);
        loan.setReceiver(receiver);
        System.out.println("Book returned successfully on " + returnDate);
    }
}
