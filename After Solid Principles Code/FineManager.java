package LMS;

import java.time.temporal.ChronoUnit;
import java.util.Date;

public class FineManager {
    private boolean finePaid = false;
    
    public double computeFine(Loan loan) {
        double totalFine = 0;

        if (!finePaid && loan.getReturnDate() != null) {
            Date iDate = loan.getIssuedDate();
            Date rDate = loan.getReturnDate();

            long daysLate = ChronoUnit.DAYS.between(iDate.toInstant(), rDate.toInstant()) - Library.getInstance().book_return_deadline;

            if (daysLate > 0)
                totalFine = daysLate * Library.getInstance().per_day_fine;
        }
        return totalFine;
    }

    public void payFine() {
        this.finePaid = true;
    }

    public boolean isFinePaid() {
        return finePaid;
    }
}
