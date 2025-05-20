import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("--------Welcome to SWARAJ Library Management System--------");

    InventoryManagement IM = new InventoryManagement();
    LendingService LS = new LendingService(IM);

    do {
        System.out.println("=== Library Inventory Menu ===");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Update Book");
        System.out.println("4. Search a Book by Title / Author / ISBN :");

        System.out.println("5. Add Patron");
        System.out.println("6. Update Patron");

        System.out.println("7. Checkout Book");
        System.out.println("8. Return Book");
        System.out.println("9. Show All Books");
        System.out.println("10. Show Available Books");
        System.out.println("11. Show Borrowed Books");
        System.out.println("12. Show All Patrons");
        System.out.println("13. Exit");

        System.out.print("---- Please Enter choice: ----");

        choice = scanner.nextInt();
        scanner.nextLine();

        // SWITCH CASE
        switch (choice) {
            case 1 -> {
                System.out.print("Enter Title: ");
                String title = scanner.nextLine();
                System.out.print("Enter Author: ");
                String author = scanner.nextLine();
                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine();
                System.out.print("Enter Publication Year: ");
                int publicationYear = scanner.nextInt();
                IM.addBook(new Books(title, author, isbn, publicationYear));
            }


            case 2 -> {
                System.out.print("Enter ISBN to remove: ");
                String isbn = scanner.nextLine();
                IM.removeBook(isbn);
            }

            case 3 -> {
                System.out.print("Enter ISBN to update: ");
                String isbn = scanner.nextLine();
                System.out.print("New Title: ");
                String title = scanner.nextLine();
                System.out.print("New Author: ");
                String author = scanner.nextLine();
                System.out.print("New Year: ");
                int year = scanner.nextInt(); scanner.nextLine();
                IM.updateBook(isbn, title, author, year);

            }




            case 4 -> {
                System.out.println("A. -> To Search By Title\n B. -> To Search By Author\n C. To Search By ISBN");
                String opt = scanner.nextLine();
                switch (opt.toLowerCase()) {
                    case "a" -> {
                        System.out.print("Title: ");
                        IM.searchByTitle(scanner.nextLine());
                    }
                    case "b" -> {
                        System.out.print("Author: ");
                        IM.searchByAuthor(scanner.nextLine());
                    }
                    case "c" -> {
                        System.out.print("ISBN: ");
                        IM.searchByIsbn(scanner.nextLine());
                    }
                    default -> System.out.println("Invalid option.");
                }
            }

            case 5 -> {
                System.out.print("Patron ID: ");
                String id = scanner.nextLine();
                System.out.print("Name: ");
                String name = scanner.nextLine();
                IM.addPatron(new Patrons(name,id));
            }
            case 6 -> {
                System.out.print("Patron ID to update: ");
                String id = scanner.nextLine();
                System.out.print("New Name: ");
                String name = scanner.nextLine();
                IM.updatePatron(name,id);
            }

            case 7 -> {
                System.out.print("ISBN: ");
                String isbn = scanner.nextLine();
                System.out.print("Patron ID: ");
                String patronId = scanner.nextLine();
                LS.checkoutBook(isbn, patronId);
            }

            case 8 -> {
                System.out.print("ISBN: ");
                String isbn = scanner.nextLine();
                System.out.print("Patron ID: ");
                String patronId = scanner.nextLine();
                LS.returnBook(isbn, patronId);
            }
            case 9 -> IM.showAllBooks();
            case 10 -> IM.showAvailableBooks();
            case 11 -> IM.showBorrowedBooks();
            case 12 -> IM.showPatrons();



            default -> System.out.println("Invalid choice.");

        }


    }   while (choice != 13);

    scanner.close();



    }
}