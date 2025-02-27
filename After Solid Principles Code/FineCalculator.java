import java.time.temporal.ChronoUnit;
import java.util.Date;
import LMS.Library;
/*NEW CLASS CREATED TO HANDLE THE LOAN CLASS METHOD */
public class FineCalculator {
    public double computeFine(Date issuedDate, boolean finePaid) {
        if (finePaid) {
            return 0; // No fine if already paid
        }

        long days = ChronoUnit.DAYS.between(issuedDate.toInstant(), new Date().toInstant());
        days = -days - Library.getInstance().book_return_deadline;

        return (days > 0) ? days * Library.getInstance().per_day_fine : 0;
    }
}
