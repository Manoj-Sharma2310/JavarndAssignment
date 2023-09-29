import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        UserServiceImpl userService = new UserServiceImpl();
        LibraryServiceInterface service=new LibraryServiceImpl();
        UserInterFace uService= new UserServiceImpl();

       do{
           System.out.println("Welcome to Library Management System");
           System.out.println("""
                   1.Add Book
                   2.Show All Books
                   3.Show Available Books
                   4.Borrow Book
                   5.Return Book
                   6.Search By Title
                   7.Search By Author
                   8.Search By Genre
                   9.Add User
                   10.Show All Users
                   11.Show User Library Card
                   12.Exit
                   """);

               System.out.println("Enter Your Choice !");
               int ch = sc.nextInt();

           switch (ch) {
               case 1 -> service.addBook();
               case 2 -> service.showAllBooks();
               case 3 -> service.showAllAvailableBooks();
               case 4 -> service.borrowBook();
               case 5 -> service.returnBook();
               case 6 -> service.searchByTitle();
               case 7 -> service.searchByAuthor();
               case 8 -> service.searchByGenre();
               case 9 -> uService.addUser();
               case 10-> uService.showAllUser();
               case 11-> uService.userCard();
               case 12-> {
                   System.out.println("Thank you for Using Application !!");
                   System.exit(0);
               }
               default -> System.out.println("Please Enter Valid Choice !");
           }
       }
       while(true);
    }
}
