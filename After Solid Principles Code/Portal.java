public class Portal {
    private AuthenticationService authService = new AuthenticationService();
    
    public Person login(List<Person> persons, Librarian librarian) {
        Scanner input = new Scanner(System.in);

        System.out.println("\nEnter ID: ");
        int id = input.hasNextInt() ? input.nextInt() : -1;

        if (id == -1) {
            System.out.println("\nInvalid Input");
            return null;
        }

        System.out.println("Enter Password: ");
        String password = input.next();

        return authService.authenticate(id, password, persons, librarian);
    }
}
