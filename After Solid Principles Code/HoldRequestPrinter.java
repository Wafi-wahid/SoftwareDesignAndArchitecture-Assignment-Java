

public class HoldRequestPrinter {
    public void printHoldRequests(HoldRequestOperations holdRequestOperations) {
        if (!holdRequestOperations.getHoldRequests().isEmpty()) {
            System.out.println("\nHold Requests are: ");
            System.out.println("-----------------------------------------------------------");
            System.out.println("No.\t\tBook's Title\t\t\tBorrower's Name\t\t\tRequest Date");
            System.out.println("-----------------------------------------------------------");

            for (int i = 0; i < holdRequestOperations.getHoldRequests().size(); i++) {
                System.out.print(i + "-" + "\t\t");
                holdRequestOperations.getHoldRequests().get(i).print();
            }
        } else {
            System.out.println("\nNo Hold Requests.");
        }
    }
}
