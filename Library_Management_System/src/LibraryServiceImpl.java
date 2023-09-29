import java.util.ArrayList;
import java.util.List;


public class LibraryServiceImpl implements LibraryServiceInterface {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";


    Validator validator = new Validator();
    static List<Book> books = new ArrayList<>();


    UserServiceImpl userService = new UserServiceImpl();

    @Override
    public void addBook() {

        String bookid = validator.validateId();
        String Author = validator.validateAuthor("Author");
        String Title = validator.validateTitle("Title");
        String isbn = validator.validateIsbn("Isbn");
        String genre = validator.validateGenre("genre");
        String price = validator.validatePrice();


        Book book = new Book(bookid, Title, Author, isbn, genre, "Available", price);
        books.add(book);
        System.out.println(GREEN + "Book Added Successfully !!!" + RESET);

    }


    @Override
    public void showAllBooks() {
        boolean flag = false;
        System.out.println(GREEN+"All Books in Library"+RESET);
        System.out.println("\n=============================================================================================");
        System.out.format(CYAN + "%s%15s%15s%15s%15s%15s%15s", "ID", "TITLE", "AUTHOR", "ISBN", "GENRE", "PRICE", "STATUS" + RESET);
        System.out.println("\n=============================================================================================");

        for (Book book : books) {
            System.out.format("%s%15s%15s%15s%15s%15s%15s", book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getGenre(), book.getPrice(), book.getStatus());
            System.out.println();
            flag = true;
        }
        System.out.println("\n---------------------------------------------------------------------------------------------");
        if (!flag)
            System.out.println(RED + "There are no Books in Library" + RESET);
    }


    public void showAllAvailableBooks() {
        boolean flag = false;
        System.out.println(GREEN+"All Available Books in Library"+RESET);
        System.out.println("\n=============================================================================================");
        System.out.format(CYAN + "%s%15s%15s%15s%15s%15s%15s", "ID", "TITLE", "AUTHOR", "ISBN", "GENRE", "Price", "STATUS" + RESET);
        System.out.println("\n=============================================================================================");

        if (books.size() > 0) {
            for (Book book : books) {
                if (book.getStatus().equals("Available")) {
                    System.out.format("%s%15s%15s%15s%15s%15s%15s", book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getGenre(), book.getPrice(), book.getStatus());
                    System.out.println();
                    flag = true;
                }
            }
            System.out.println("Please provide your user ID");

        } else {
            System.out.println(RED + "No Books Available in the library" + RESET);
        }
        System.out.println("\n---------------------------------------------------------------------------------------------");
        if (!flag)
            System.out.println(RED + "There are no books with status Available" + RESET);

    }

    public void borrowBook() {
        String userLibraryId = validator.validateUserLibraryId();
        String bookid = validator.validateId();
         User user=new User(userLibraryId);
        if (user!=null &&  (userLibraryId.equals(user.getUserLibraryId()))) {
            boolean flag = false;
            for (Book book : books) {
                System.out.println(GREEN + "Borrowed Book Details: " + RESET);
                System.out.println("\n=============================================================================================");
                System.out.format(CYAN + "%s%15s%15s%15s%15s%15s", "ID", "AUTHOR", "ISBN", "GENRE", "TITLE    ", "PRICE" + RESET);
                System.out.println("\n=============================================================================================");
                System.out.println("");
                if (book.getId().equals(bookid) && book.getStatus().equals("Available")) {
                    System.out.format("%s%15s%15s%15s%15s%15s", book.getId(), book.getAuthor(), book.getIsbn(), book.getGenre(), book.getTitle(), book.getPrice());
                    flag = true;
                    book.setStatus("Not Available");
                }
                System.out.println("\n---------------------------------------------------------------------------------------------");
                System.out.println(GREEN + "\nBook Borrowed Successfully !!!" + RESET);
                userService.userBorrowedBook(userLibraryId, book);
            }
            if (!flag)
                System.out.println(RED + "This book is not available to borrow because borrowed by user" + RESET);
        }
        else{
            System.out.println(RED + "User is not available or pls add a user" + RESET);
        }
    }

    public void returnBook() {
        String bookid = validator.validateId();
        boolean flag = false;
        System.out.println(GREEN + "Returned Book Details: "+RESET);
        System.out.println("\n=============================================================================================");
        System.out.format(CYAN + "%s%15s%15s%15s%15s%15s", "ID", "AUTHOR", "ISBN", "GENRE", "TITLE", "PRICE"+ RESET);
        System.out.println("\n=============================================================================================");
        for (Book book : books) {

            if (book.getId().equals(bookid) && book.getStatus().equals("Not Available")) {
                System.out.format("%s%15s%15s%15s%15s%15s", book.getId(), book.getAuthor(), book.getIsbn(), book.getGenre(), book.getTitle(), book.getPrice());

                flag = true;

                book.setStatus("Available");

            }

        }
        System.out.println("\n---------------------------------------------------------------------------------------------");
        System.out.println(GREEN + "Book Returned Successfully !!!" + RESET);
        if (!flag)
            System.out.println(RED + "We can not return this book" + RESET);

    }

    @Override
    public void searchByTitle() {
        String title = validator.validateTitle("Title");
        boolean found = false;
        System.out.println(GREEN+"All Books in Library with Same Title"+RESET);
        System.out.println("\n=============================================================================================");
        System.out.format(CYAN + "%s%15s%15s%15s%15s%15s%15s", "ID", "AUTHOR", "ISBN", "GENRE", "TITLE", "PRICE", "STATUS" + RESET);
        System.out.println("\n=============================================================================================");

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                System.out.format("%s%15s%15s%15s%15s%15s%15s", book.getId(), book.getAuthor(), book.getIsbn(), book.getGenre(), book.getTitle(), book.getPrice(), book.getStatus());
                System.out.println();
                found = true;
            }
        }
        System.out.println("\n---------------------------------------------------------------------------------------------");

        if (!found) {
            System.out.println(RED + "Book with this Title isn't available" + RESET);
        }
    }


    @Override
    public void searchByAuthor() {
        String Author = validator.validateAuthor("Author");
        boolean found = false;
        System.out.println(GREEN+"All Books in Library with Same Author"+RESET);
        System.out.println("\n=============================================================================================");
        System.out.format(CYAN + "%s%15s%15s%15s%15s%15s%15s", "ID", "AUTHOR", "ISBN", "GENRE", "TITLE", "PRICE", "STATUS" + RESET);
        System.out.println("\n=============================================================================================");

        for (Book book : books) {
            if (book.getAuthor().equals(Author)) {
                System.out.format("%s%15s%15s%15s%15s%15s%15s", book.getId(), book.getAuthor(), book.getIsbn(), book.getGenre(), book.getTitle(), book.getPrice(), book.getStatus());
                System.out.println();
                found = true;
            }
        }
        System.out.println("\n---------------------------------------------------------------------------------------------");

        if (!found) {
            System.out.println(RED + "Book with this Author isn't available" + RESET);
        }
    }

    @Override
    public void searchByGenre() {
        String Genre = validator.validateGenre("Genre");
        boolean found = false;
        System.out.println(GREEN+"All Books in Library with Same Genre"+RESET);
        System.out.println("\n=============================================================================================");
        System.out.format(CYAN + "%s%15s%15s%15s%15s%15s%15s", "ID", "AUTHOR", "ISBN", "GENRE", "TITLE", "PRICE", "STATUS" + RESET);
        System.out.println("\n=============================================================================================");
        for (Book book : books) {
            if (book.getGenre().equals(Genre)) {
                System.out.format("%s%15s%15s%15s%15s%15s%15s", book.getId(), book.getAuthor(), book.getIsbn(), book.getGenre(), book.getTitle(), book.getPrice(), book.getStatus());
                System.out.println();
                found = true;
            }
        }
        System.out.println("\n---------------------------------------------------------------------------------------------");

        if (!found) {
            System.out.println(RED + "Book with this Genre isn't available" + RESET);
        }
    }

}
