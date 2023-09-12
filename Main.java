import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Manager manager= new Manager();

        List<Borrower> borrowers = new ArrayList<>();

        System.out.println("Welcome to Library Management System");
        System.out.println("You have some options to choose");
        Scanner sc= new Scanner(System.in);
        while(true){
            System.out.println("\n1. Add Book\n2. Search Book\n3. Add Borrower\n4. Borrow Book\n5. Return Book\n6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter Item ID: ");
                String itemId = sc.nextLine();
                System.out.print("Enter Title: ");
                String title = sc.nextLine();
                System.out.print("Enter Author: ");
                String author = sc.nextLine();
                System.out.print("Enter ISBN: ");
                String isbn = sc.nextLine();

                Item item = new Item(itemId, title, author, isbn);
                manager.addBook(item);
                System.out.println("Book added successfully!");
            } else if (choice == 2) {
                // Search a book
                System.out.println("1. Search by Title\n2. Search by Author\n3. Search by ISBN");
                System.out.print("Enter your choice: ");
                int searchChoice = sc.nextInt();
                sc.nextLine(); // Consume newline
                if (searchChoice == 1) {
                    System.out.print("Enter Title to search: ");
                    String searchTitle = sc.nextLine();
                    Item searchResult = manager.searchByTitle(searchTitle);

                    if (searchResult != null) {
                        System.out.println("Search Result:");
                        System.out.println(searchResult);
                    } else {
                        System.out.println("No matching book found.");
                    }
                } else if (searchChoice == 2) {
                    System.out.print("Enter Author to search: ");
                    String searchAuthor = sc.nextLine();
                    List<Item> searchResults = manager.searchByAuthor(searchAuthor);
                    //Item itm = manager.searchByAuthors(searchAuthor);
                    //  System.out.println(itm);
                    if (!searchResults.isEmpty()) {
                        System.out.println("Search Results:");
                        for (Item item : searchResults) {
                            System.out.println(item);
                        }
                    } else {
                        System.out.println("No matching books found.");
                    }
                }else if (searchChoice == 3) {
                    System.out.print("Enter ISBN to search: ");
                    String searchISBN = sc.nextLine();
                    Item searchResult = manager.searchByISBN(searchISBN);

                    if (searchResult != null) {
                        System.out.println("Search Result:");
                        System.out.println(searchResult);
                    } else {
                        System.out.println("No matching book found.");
                    }
                }
            }
            else if (choice == 3) {
                System.out.print("Enter Borrower Name: ");
                String borrowerName = sc.nextLine(); // Tharun
                System.out.print("Enter Borrower Registered No: ");
                String borrowerRegisteredNo = sc.nextLine(); //123

                Borrower borrower = new Borrower(borrowerName, borrowerRegisteredNo);
                borrowers.add(borrower);
                System.out.println("Borrower added successfully!");

                //Borrow book
            } else if (choice == 4) {
                System.out.print("Enter Borrower Name: "); //Tharun
                String borrowerName = sc.nextLine();

                // Find the borrower by name
                Borrower borrower = findBorrowerByName(borrowers, borrowerName);
                if (borrower == null) {
                    System.out.println("Borrower not found.");
                } else {
                    System.out.print("Enter ISBN of the book to borrow: ");
                    String isbn = sc.nextLine();


                    Item bookToBorrow = manager.searchByISBN(isbn);
                    if (bookToBorrow == null) {
                        System.out.println("Book not found.");
                    } else {
                        borrower.borrowBook(bookToBorrow);

                    }
                }
            }

            // Return book
            else if (choice == 5) {
                System.out.print("Enter Borrower Name: ");
                String borrowerName = sc.nextLine();

                // Find the borrower by name
                Borrower borrower = findBorrowerByName(borrowers, borrowerName);
                if (borrower == null) {
                    System.out.println("Borrower not found.");
                } else {
                    System.out.print("Enter ISBN of the book to return: ");
                    String isbn = sc.nextLine();

                    // Find the book by ISBN
                    Item bookToReturn = manager.searchByISBN(isbn);
                    if (bookToReturn == null) {
                        System.out.println("Book not found.");
                    } else {
                        borrower.returnBook(bookToReturn);
                    }
                }
            } else if (choice == 6) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }

    private static Borrower findBorrowerByName(List<Borrower> borrowers, String name) {
        for (Borrower borrower : borrowers) {
            if (borrower.getName().equalsIgnoreCase(name)) {
                return borrower;
            }
        }
        return null;
    }
}