public class AuthenticationService {
    public Person authenticate(int id, String password, List<Person> persons, Librarian librarian) {
        for (Person person : persons) {
            if (person.getID() == id && person.getPassword().equals(password)) {
                System.out.println("\nLogin Successful");
                return person;
            }
        }

        if (librarian != null && librarian.getID() == id && librarian.getPassword().equals(password)) {
            System.out.println("\nLogin Successful");
            return librarian;
        }

        System.out.println("\nSorry! Wrong ID or Password");
        return null;
    }
}
