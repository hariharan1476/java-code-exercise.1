public class Book {
    private String author;
    private String title;
    private double price;
    private String publisher;
    private int stock;
    private static int successfulTransactions = 0;
    private static int unsuccessfulTransactions = 0;

    public Book(String author, String title, double price, String publisher, int stock) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.publisher = publisher;
        this.stock = stock;
    }

    public void displayBookDetails() {
        System.out.println("Author: " + author);
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
        System.out.println("Publisher: " + publisher);
        System.out.println("Stock: " + stock);
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    public static int getSuccessfulTransactions() {
        return successfulTransactions;
    }

    public static int getUnsuccessfulTransactions() {
        return unsuccessfulTransactions;
    }

    public boolean checkAvailability() {
        return stock > 0;
    }

    public void makeTransaction(int numCopies) {
        if (stock >= numCopies) {
            double totalCost = numCopies * price;
            System.out.println("Transaction Successful!");
            System.out.println("Total Cost: " + totalCost);
            stock -= numCopies;
            successfulTransactions++;
        } else {
            System.out.println("Required copies are not in stock.");
            unsuccessfulTransactions++;
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book("Author 1", "Book Title 1", 20.0, "Publisher A", 10);
        Book book2 = new Book("Author 2", "Book Title 2", 15.0, "Publisher B", 5);

        book1.displayBookDetails();
        System.out.println();

        // Updating the price of a book
        book1.updatePrice(25.0);

        // Checking book availability
        if (book1.checkAvailability()) {
            System.out.println("Book is available.");
            book1.makeTransaction(3);
        } else {
            System.out.println("Book is not available.");
        }

        System.out.println("Successful Transactions: " + Book.getSuccessfulTransactions());
        System.out.println("Unsuccessful Transactions: " + Book.getUnsuccessfulTransactions());
    }
}
