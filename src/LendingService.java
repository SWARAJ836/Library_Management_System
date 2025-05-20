public class LendingService {

    private InventoryManagement IM;

    public LendingService (InventoryManagement IM)
    {
        this.IM = IM;
    }

    // BOOK CHECKOUT
                public void checkoutBook(String isbn, String patronId) {
                Books book = IM.getBookByIsbn(isbn);
                Patrons patron = IM.getPatronById(patronId);

                if (book == null) {
                    System.out.println("Book not found.");
                    return;
                }
                if (patron == null) {
                    System.out.println("Patron not found.");
                    return;
                }
                if (!book.isAvailable()) {
                    System.out.println("Book is already borrowed.");
                    return;
                }

                book.borrow();
                patron.borrowBook(book);
                System.out.println("Book checked out successfully to " + patron.getPatronName());
            }

    // BOOK RETURN

                public void returnBook(String isbn, String patronId) {
                Books book = IM.getBookByIsbn(isbn);
                Patrons patron = IM.getPatronById(patronId);

                if (book == null) {
                    System.out.println("Book not found.");
                    return;
                }
                if (patron == null) {
                    System.out.println("Patron not found.");
                    return;
                }
                if (!patron.getBorrowedBooks().contains(book)) {
                    System.out.println("This book is not currently borrowed by " + patron.getPatronName());
                    return;
                }

                book.returnBook();
                patron.returnBook(book);
                System.out.println("Book returned successfully.");
            }


}
