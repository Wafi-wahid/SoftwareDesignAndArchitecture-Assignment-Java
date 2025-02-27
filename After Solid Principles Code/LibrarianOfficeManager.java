
public class LibrarianOfficeManager {
    private static int currentOfficeNumber = 0;

    public int assignOfficeNumber() {
        return currentOfficeNumber++;
    }
}
