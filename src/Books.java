
// Class for Books
public class Books {

    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private boolean isAvailable;

    // CONSTRUCTOR
    public Books(String title, String author, String isbn, int publicationYear)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.isAvailable=true;
    }

    // DEFAULT CONSTRUCTOR
    public Books()
    {
        this.title = "";
        this.author = "";
        this.isbn = "";
        this.publicationYear = 0;
        this.isAvailable=true;
    }

    // GETTERS
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isAvailable()
    {
        return isAvailable;
    }

    // SETTERS
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void borrow() {
       isAvailable = false;
        }

    public void returnBook() {
      isAvailable = true;
        }

    @Override
    public String toString() {
        return "Books{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }
}
