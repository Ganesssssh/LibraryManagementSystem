import java.util.ArrayList;
import java.util.List;

public class Manager {

    private List<Item> items;

    public Manager(){

        items= new ArrayList<>();
    }


    // add a book
    public void addBook(Item book){

        items.add(book);
    }

    //     search with title
    public  Item searchByTitle(String title){
        for(Item i:items){
            if(i.getTitle().equalsIgnoreCase(title)){
                return i;
            }
        }
        return null;
    }
    public List<Item> searchByAuthor(String author) {
        List<Item> results = new ArrayList<>();
        for (Item item : items) {
            if (item.getAuthor().equalsIgnoreCase(author)) {
                results.add(item);
            }
        }
        return results;
    }

    //    public Item searchByAuthors(String author) {
//        Item itm = null;
//        for (Item item : items) {
//            if (item.getAuthor().equalsIgnoreCase(author)) {
//                itm = item;
//            }
//        }
//        return itm;
//    }
    public Item searchByISBN(String isbn) {
        for (Item item : items) {
            if (item.getIsbn().equals(isbn)) {
                return item;
            }
        }
        return null;
    }

    public void display() {
        for (Item item : items) {
            System.out.println(item);
        }
    }
}