import java.util.ArrayList;
import java.util.List;


class Book {
    private String title;
    private String author;
    private int yearOfPublication;

    public Book(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}


class Novel extends Book {
    public Novel(String title, String author, int yearOfPublication) {
        super(title, author, yearOfPublication);
    }

    public void displayInformation() {
        System.out.println("Novel Information: " + getTitle() + " by " + getAuthor() +
                ", Published in " + getYearOfPublication());
    }
}


class Textbook extends Book {
    public Textbook(String title, String author, int yearOfPublication) {
        super(title, author, yearOfPublication);
    }

    public void displayInformation() {
        System.out.println("Textbook Information: " + getTitle() + " by " + getAuthor() +
                ", Published in " + getYearOfPublication());
    }
}

// Step 3: Library class
class Library {
    private List<Book> inventory;

    public Library() {
        this.inventory = new ArrayList<>();
    }

    public void addBook(Book book) {
        inventory.add(book);
        System.out.println("Book added to the library: " + book.getTitle());
    }

    public void removeBook(Book book) {
        inventory.remove(book);
        System.out.println("Book removed from the library: " + book.getTitle());
    }

    public void listBooks() {
        System.out.println("Books in the library:");
        for (Book book : inventory) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() +
                    ", Published in " + book.getYearOfPublication());
        }
    }
}


interface LibraryUser {
    void borrowBook(Book book);

    void returnBook(Book book);
}

class Student implements LibraryUser {
    private LibraryCard libraryCard;
    private final ArrayList<Book> booksBorrowed = new ArrayList<>();
    public int cin;
    public String fullName;
    public Student(int cin,String fullName) {
        this.libraryCard = new LibraryCard(cin,fullName);
    }

    @Override
    public void borrowBook(Book book) {
        System.out.println("Student borrowed the book: " + book.getTitle());
        booksBorrowed.add(book);
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("Student returned the book: " + book.getTitle());
        booksBorrowed.remove(book);
    }
}


class Teacher implements LibraryUser {
    private LibraryCard libraryCard;
    private final ArrayList<Book> booksBorrowed = new ArrayList<>();
    public int cin;
    public String fullName;

    public Teacher(int cin,String fullName) {
        this.libraryCard = new LibraryCard(cin,fullName);
    }

    @Override
    public void borrowBook(Book book) {
        System.out.println("Teacher borrowed the book: " + book.getTitle());
        booksBorrowed.add(book);
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("Teacher returned the book: " + book.getTitle());
        booksBorrowed.remove(book);
    }
}



class LibraryCard {
    public int Id;
    public String fullName;
    public LibraryCard(int x,String s){
        this.Id = x;
        this.fullName = s;
    }
}

// Example usage:
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create instances of books
        Book novelBook = new Novel("To Kill a Mockingbird", "Harper Lee", 1960);
        Book textbook = new Textbook("Introduction to Java", "John Doe", 2022);

        // Create an instance of the library
        Library library = new Library();

        // Add books to the library
        library.addBook(novelBook);
        library.addBook(textbook);

        // List all books in the library
        library.listBooks();

        // Create instances of library users (Student and Teacher)
        LibraryUser student = new Student(1464,"AHmed");
        LibraryUser teacher = new Teacher(56456,"azdada");

        // Demonstrate borrowing and returning books
        student.borrowBook(novelBook);
        teacher.borrowBook(textbook);

        student.returnBook(novelBook);
        teacher.returnBook(textbook);
    }
}
