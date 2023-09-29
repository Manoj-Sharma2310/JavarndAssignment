import java.text.SimpleDateFormat;
import java.util.Calendar;

public class User {


    private String userLibraryId;
    private String userName;
    private String userContact;
    private String bookIssueDays=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());

    private String bookId;

    private String bookTitle;




    public User(String userLibraryId, String userName, String userContact){

        this.userLibraryId = userLibraryId;
        this.userName = userName;
        this.userContact = userContact;

    }


    public User(String userLibraryId, String userName, String userContact,String bookId, String bookTitle){

        this.userLibraryId = userLibraryId;
        this.userName = userName;
        this.userContact = userContact;
        this.bookId=bookId;
        this.bookTitle=bookTitle;

    }

    public User(String userLibraryId) {
        this.userLibraryId=userLibraryId;

    }

    public String getUserLibraryId() {
        return userLibraryId;
    }
    public void setUserLibraryId(String userLibraryId) {
        this.userLibraryId = userLibraryId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }



    public String getBookIssueDays() {
        return bookIssueDays;
    }

    public void setBookIssueDays(String bookIssueDays) {
        this.bookIssueDays = bookIssueDays;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String toString() {
        return "User{" +
                "userLibraryId='" + userLibraryId + '\'' +
                ", userName='" + userName + '\'' +
                ", userContact='" + userContact + '\'' +
                ", bookIssueDays='"+ bookIssueDays +'\''+
                '}';
    }

}

