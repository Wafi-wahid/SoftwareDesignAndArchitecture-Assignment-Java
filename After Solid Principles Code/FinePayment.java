import java.util.Scanner;

/*NEW CLASS CREATED TO HANDLE THE FINE PAYMENT METHOD TAKEN FROM LOAN CLASS */
public class FinePayment {
    private FineCalculator fineCalculator;

    public FinePayment(FineCalculator fineCalculator) {
        this.fineCalculator = fineCalculator;
    }

    public boolean payFine(double totalFine) {
        if (totalFine > 0) {
            System.out.println("\nTotal Fine generated: Rs " + totalFine);
            System.out.println("Do you want to pay? (y/n)");

            Scanner input = new Scanner(System.in);
            String choice = input.next();
            input.close();

            return choice.equalsIgnoreCase("y"); // Returns true if paid, false otherwise
        } else {
            System.out.println("\nNo fine is generated.");
            return true; // No fine means payment is considered done
        }
    }
}
