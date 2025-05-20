import java.util.ArrayList;
import java.util.List;

// Class for Patrons
public class Patrons {

   private String patronName;
   private String patronId;
   private List<Books> borrowedBooks;



    // GETTERS
   public Patrons ( String patronName, String patronId)
   {
       this.patronName = patronName;
       this.patronId = patronId;
       this.borrowedBooks = new ArrayList<>();
   }

    public String getPatronName() {
        return patronName;
    }

    public String getPatronId() {
        return patronId;
    }

    public List<Books> getBorrowedBooks() {
       return borrowedBooks;
   }

    // SETTERS
    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public void borrowBook(Books book){
       borrowedBooks.add(book);
    }

    public void returnBook(Books book){
       borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Patrons{" +
                "patronId='" + patronId + '\'' +
                ", patronName='" + patronName + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }



}
