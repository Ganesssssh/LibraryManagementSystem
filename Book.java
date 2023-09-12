public class Book {

    private String title;
    private String author;
    private String isbn;


    // parameterised constructor

    public Book(String title, String author, String isbn){
        this.title=title;
        this.author=author;
        this.isbn=isbn;
    }

    // getters and setters
    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getIsbn(){
        return isbn;
    }

    public  String toString(){
        return "Title:"+ title+  " Author: "+ author+" Isbn: "+isbn;
    }

}