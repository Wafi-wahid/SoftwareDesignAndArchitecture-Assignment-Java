import LMS.Book;
import LMS.Borrower;
import LMS.HoldRequest;
import LMS.HoldRequestOperations;
import java.util.Date;

/* NEW CLASS CREATED TO MANAGE PLACE BOOK ON HOLD METHOD */
public class HoldRequestManager {
    private HoldRequestOperations holdRequestOperations;

    public HoldRequestManager(HoldRequestOperations holdRequestOperations) {
        this.holdRequestOperations = holdRequestOperations;
    }
    /*ADDED THESE METHODS FROM LIBRAY CLASS  */
    public void addHoldRequest(HoldRequest hr) {
        holdRequests.add(hr);
    }

    public void removeHoldRequest() {
        if (!holdRequests.isEmpty()) {
            holdRequests.remove(0);
        }
    }

    public void printHoldRequests() {
        if (!holdRequests.isEmpty()) {
            System.out.println("\nHold Requests:");
            for (int i = 0; i < holdRequests.size(); i++) {
                System.out.print(i + "-" + "\t\t");
                holdRequests.get(i).print();
            }
        } else {
            System.out.println("\nNo Hold Requests.");
        }
    }
//////////////////////////////////////////////////////////////////////////////

    public void placeBookOnHold(Borrower borrower, Book book) {
        HoldRequest hr = new HoldRequest(borrower, book, new Date());
        holdRequestOperations.addHoldRequest(hr); // Delegate storage responsibility
        borrower.addHoldRequest(hr); // Still modifying Borrower, but it's expected
        System.out.println("\nThe book " + book.getTitle() + " has been successfully placed on hold by " + borrower.getName() + ".\n");
    }
}

