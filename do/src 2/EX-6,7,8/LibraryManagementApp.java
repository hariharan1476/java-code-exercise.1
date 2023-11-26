import java.util.Scanner;

class Book {
    private String bookTitle;
    private String bookAuthor;
    private int bookNoOfCopies;
    private boolean bookAvailability;
    private String bookEdition;
    private String bookPublisher;

    public Book(String title, String author, int noOfCopies, String edition, String publisher) {
        bookTitle = title;
        bookAuthor = author;
        bookNoOfCopies = noOfCopies;
        bookAvailability = true;
        bookEdition = edition;
        bookPublisher = publisher;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String title) {
        bookTitle = title;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String author) {
        bookAuthor = author;
    }

    public int getBookNoOfCopies() {
        return bookNoOfCopies;
    }

    public void setBookNoOfCopies(int noOfCopies) {
        bookNoOfCopies = noOfCopies;
    }

    public boolean isBookAvailability() {
        return bookAvailability;
    }

    public void setBookAvailability(boolean availability) {
        bookAvailability = availability;
    }

    public String getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(String edition) {
        bookEdition = edition;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String publisher) {
        bookPublisher = publisher;
    }

    public void displayBookDetails() {
        System.out.println("Title: " + bookTitle);
        System.out.println("Author: " + bookAuthor);
        System.out.println("No. of Copies: " + bookNoOfCopies);
        System.out.println("Availability: " + (bookAvailability ? "Available" : "Not Available"));
        System.out.println("Edition: " + bookEdition);
        System.out.println("Publisher: " + bookPublisher);
    }
}

class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public void displayBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isBookAvailability()) {
                System.out.println("===============");
                book.displayBookDetails();
                System.out.println("===============");
            }
        }
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getBookTitle().equalsIgnoreCase(title)) {
                if (book.isBookAvailability()) {
                    book.setBookAvailability(false);
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("Book is not available for borrowing.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getBookTitle().equalsIgnoreCase(title)) {
                if (!book.isBookAvailability()) {
                    book.setBookAvailability(true);
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book is already available.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getBookTitle().equalsIgnoreCase(title)) {
                System.out.println("Book Details:");
                System.out.println("===============");
                book.displayBookDetails();
                System.out.println("===============");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

public class LibraryManagementApp {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "John Doe", 5, "2nd Edition", "ABC Publications");
        Book book2 = new Book("Python Basics", "Jane Smith", 3, "1st Edition", "XYZ Publishers");
        Book book3 = new Book("Data Structures", "David Johnson", 2, "3rd Edition", "PQR Books");
        Book[] books = { book1, book2, book3 };

        Library library = new Library(books);
        Scanner scanner = new Scanner(System.in);

        int choice;
        String title;

        do {
            System.out.println("\n===== Library Management Menu =====");
            System.out.println("1. Display Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Search for a Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice:");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        library.displayBooks();
                        break;
                    case 2:
                        System.out.print("Enter the title of the book to borrow: ");
                        title = scanner.nextLine();
                        library.borrowBook(title);
                        break;
                    case 3:
                        System.out.print("Enter the title of the book to return: ");
                        title = scanner.nextLine();
                        library.returnBook(title);
                        break;
                    case 4:
                        System.out.print("Enter the title of the book to search: ");
                        title = scanner.nextLine();
                        library.searchBook(title);
                        break;
                    case 5:
                        System.out.println("Exiting the program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } while (choice != 5);

            scanner.close();
        }
    }
