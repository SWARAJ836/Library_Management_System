import java.util.ArrayList;
import java.util.HashMap;

// Class for LIBRARY INVENTORY MANAGEMENT
public class InventoryManagement {
    private ArrayList<Books> bookList;
    private HashMap<String, Patrons> patronList;


    // CONSTRUCTOR
    public InventoryManagement() {
        // empty Book list
        bookList = new ArrayList<>();
        // empty Patron list
        patronList = new HashMap<>();
    }

    // ==== **** BOOK MANAGEMENT **** ==== ==== **** BOOK MANAGEMENT **** ==== ==== **** BOOK MANAGEMENT **** ====

    // Adding a New Book to the Inventory
                public void addBook(Books book) {
                    bookList.add(book);
                    System.out.println("Book added is : " + book);
                }

    // Remove Book by ISBN
                public void removeBook(String isbn)
                    {
                        Books bookToRemove = getBookByIsbn(isbn);
                        if (bookToRemove !=null)
                        {
                            bookList.remove(bookToRemove);
                            System.out.println("Book has been Removed having below details " );
                            System.out.println(bookToRemove);
                        }else
                            System.out.println("Book Not Found");

                    }

    // Find Book by ISBN
    private Books findBookByIsbn(String isbn) {
        for (Books book : bookList) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) return book;
        }
        return null;
    }





    // Update Book by ISBN
                public void updateBook(String isbn, String newTitle, String newAuthor, int newYear)
                {

                    Books bookToUpdate = findBookByIsbn(isbn);
                    if (bookToUpdate != null )
                    {
                        bookToUpdate.setTitle(newTitle);
                        bookToUpdate.setAuthor(newAuthor);
                        bookToUpdate.setPublicationYear(newYear);
                        System.out.println("Book Details UPDATED with below mentioned new Details.");
                        System.out.println(bookToUpdate);
                    } else
                        System.out.println("Book not found.");


                }
    // ==== SEARCHING BOOK ==== ==== SEARCHING BOOK ==== ==== SEARCHING BOOK ==== ==== SEARCHING BOOK ====

    // Search Book by Title
                    public void searchByTitle(String title)
                    {
                        boolean found = false;
                        for (Books b : bookList) {
                            if (b.getTitle().equalsIgnoreCase(title)) {
                                System.out.println("Found: " + b);
                                found = true;
                            }
                        }
                        if (!found) System.out.println("No book found with title: " + title);


                    }

    // Search Book by Author
                    public void searchByAuthor(String author)
                    {

                        boolean found = false;
                        for (Books b : bookList) {
                            if (b.getAuthor().equalsIgnoreCase(author)) {
                                System.out.println("Found: " + b);
                                found = true;
                            }
                        }
                        if (!found) System.out.println("No book found by author: " + author);


                    }

    // Search Book by ISBN
                    public void searchByIsbn(String isbn)
                    {

                        for (Books b : bookList) {
                            if (b.getIsbn().equalsIgnoreCase(isbn))
                            {
                                System.out.println("Found: " + b);
                            }
                        }
                        System.out.println("No book found with ISBN: " + isbn);


                    }

    // Display all books
                    public void displayAllBooks() {
                        if (bookList.isEmpty()) {
                            System.out.println("No books in the inventory.");
                        } else {
                            for (Books b : bookList) {
                                System.out.println(b);
                            }

                        }
                    }

    //Display All the Books
            public void showAllBooks() {
                System.out.println("List of ALL Books in the INVENTORY:");
                for (Books b : bookList) {
                    System.out.println(b);
                }

            }
    // Display Available Books
            public void showAvailableBooks() {
                System.out.println("Below are the List of AVAILABLE Books :");
                for (Books b : bookList) {
                if (b.isAvailable()) {

                    System.out.println(b);
                    }
                }
            }
    // Display Borrowed Books
            public void showBorrowedBooks() {
                System.out.println("Below are the List of BORROWED Books :");
                for (Books b : bookList) {
                    if (!b.isAvailable()) {

                        System.out.println(b);
                    }
                    else
                        System.out.println("No BORROWED Books to Display :");
                }
            }


            public Books getBookByIsbn(String isbn) {
                for (Books book : bookList) {
                    if (book.getIsbn().equalsIgnoreCase(isbn)) {
                        return book;
                    }
                }
                return null;
            }


    // ==== **** PATRON MANAGEMENT **** ====

            // Add Patron
            public void addPatron(Patrons patron)
            {
                patronList.put(patron.getPatronId(), patron);
                System.out.println("Patron added.");
            }

            // Update Patron
            public void updatePatron(String newName, String id) {
                Patrons patron = patronList.get(id);
                if (patron != null) {
                    patron.setPatronName(newName);
                    System.out.println("Patron updated.");
                } else {
                    System.out.println("Patron not found.");
                }
            }

            // Get Patron by ID
            public Patrons getPatronById(String id) {
                return patronList.get(id);
            }

            // Show all Patrons
            public void showPatrons()
            {
                for (Patrons p : patronList.values())
                    System.out.println(p);
            }

}