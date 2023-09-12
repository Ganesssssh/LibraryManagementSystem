import java.util.ArrayList;
import java.util.List;


public class Borrower {
    private String name;
    private String registeredNo;
    private List<Item> borrowedBooks;

    public String getName(){
        return name;
    }

    public String getRegisteredNo(){
        return registeredNo;
    }

    public List<Item> getBorrowedBooks(){
        return borrowedBooks;
    }

    public String toString(){
        return "Name "+name+ "| Registered No "+registeredNo;
    }

    public Borrower(String name, String registeredNo) {
        this.name = name;
        this.registeredNo = registeredNo;
        borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Item book) {
        if(book.getBorrowed()==true){
            System.out.println("Sorry!! The book is already borrowed.");
        }
        else {
            book.setBorrowed(true);
            borrowedBooks.add(book);
            System.out.println("Book borrowed successfully!");
        }
    }

    public void returnBook(Item book) {
        if(book.getBorrowed()==false){
            System.out.println("did not borrow the book");
        }
        else {
            borrowedBooks.remove(book);
            book.setBorrowed(false);
            System.out.println("Book borrowed successfully!");
        }

    }


}