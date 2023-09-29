import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserInterFace {

    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";


    Validator validator = new Validator();
    static List<User> users = new ArrayList<>();

    public void addUser() {


        String userLibraryId = validator.validateUserLibraryId();
        String userName = validator.validateUserName("UserName");
        String userContact = validator.validateuserContact("User Contact");

        User user = new User(userLibraryId, userName, userContact,"0","NA");
        users.add(user);
        System.out.println(GREEN + "User Added Successfully !!!" + RESET);

    }

    public void showAllUser() {
        boolean flag = false;
        System.out.println(GREEN+"All User's List...!!!!"+RESET);
        System.out.println("\n=================================================================");
        System.out.format(CYAN +"%s%18s%19s","USER_ID","USER_NAME","USER_CONTACT"+ RESET);
        System.out.println("\n=================================================================");
        for (User user : users) {
            System.out.format("%s%18s%19s",user.getUserLibraryId(),user.getUserName(),user.getUserContact());
            System.out.println();
            flag = true;
        }
        System.out.println("\n-----------------------------------------------------------------");
        if (!flag)
            System.out.println(RED + "There are no User's in List...!!!" + RESET);
    }
    public void userCard(){

        String userLibraryId = validator.validateUserLibraryId();
        boolean found = false;
        System.out.println(GREEN+"User Library Card"+RESET);
        System.out.println("\n===============================================================================================================");
        System.out.format(CYAN + "%s%18s%19s%17s%21s%27s","USER_ID","USER_NAME","USER_CONTACT","Book_Id","        Book_Title      ","Book_Issue_days"+ RESET);
        System.out.println("\n===============================================================================================================");

        for (User user : users) {
            if (user.getUserLibraryId().equals(userLibraryId)) {
                System.out.format("%s%18s%19s%17s%20s%30s",user.getUserLibraryId(),user.getUserName(),user.getUserContact(),user.getBookId(),user.getBookTitle(),user.getBookIssueDays());
                System.out.println();
                found = true;
            }
        }
        System.out.println("\n---------------------------------------------------------------------------------------------------------------");

        if (!found) {
            System.out.println(RED + "User with this ID isn't available" + RESET);
        }
    }


    public void userBorrowedBook(String userid, Book book){
        boolean found = false;
        System.out.println(" ");
        System.out.println(GREEN+"User Borrowed book Successfully"+RESET);
        System.out.println("\n===============================================================================================================");
        System.out.format(CYAN + "%s%18s%19s%17s%25s%25s","USER_ID","USER_NAME","USER_CONTACT","Book_Id   ","Book_Title          ","Book_Issue_days"+ RESET);
        System.out.println("\n===============================================================================================================");

        for (User user : users) {
            if (user.getUserLibraryId().equals(userid)) {
                user.setBookId((book.getId()));
                user.setBookTitle(book.getTitle());
                System.out.format("%s%18s%19s%17s%18s%30s", user.getUserLibraryId(), user.getUserName(), user.getUserContact(), book.getId(), book.getTitle(), user.getBookIssueDays());
                found = true;
            }

        }
        System.out.println("\n---------------------------------------------------------------------------------------------------------------");

        if (!found) {
            System.out.println(RED + "something went wrong with user borrowing book" + RESET);
        }
    }

}
