public class Book {


    private String id;
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private String available;
    private String price;




    public Book(String id,String title,String author, String isbn,String genre,String available ,String price ) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.available = available;
        this.price = price;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn(){ return isbn;}
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre(){return genre;}
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStatus() { return available; }
    public void setAvailable(String available) {
        this.available = available;
    }
    public void setStatus(String status) { this.available =status; }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='"+ isbn + '\''+
                ", genre='"+ genre +'\''+
                ", status='" + available + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
