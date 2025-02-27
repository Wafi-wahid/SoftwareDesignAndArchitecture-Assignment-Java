package LMS;

public class Librarian extends Staff {
    private int officeNo;

    public Librarian(int id, String n, String a, int p, double s, int of, LibrarianOfficeManager officeManager) {
        super(id, n, a, p, s);
        this.officeNo = (of == -1) ? officeManager.assignOfficeNumber() : of;
    }

    public int getOfficeNo() {
        return officeNo;
    }
}
