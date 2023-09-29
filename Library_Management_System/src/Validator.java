import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    public static final String RED="\u001B[31m";
    public static final String RESET="\u001B[0m";
    private static Pattern ID_PATTERN = Pattern.compile("^\\d{1,4}$");
    private static Pattern Author_Pattern=Pattern.compile("^[a-zA-Z ]+$");
    private static Pattern Genre_Pattern=Pattern.compile("^[a-zA-Z ]+$");
    private static Pattern Isbn_Pattern=Pattern.compile("^\\d{6}$");
    private static Pattern Price_Pattern=Pattern.compile("^\\d{3}$");
    private static Pattern userLibraryId_Pattern=Pattern.compile("^\\d{1,4}$");
    private static Pattern userName_Pattern=Pattern.compile("^[a-zA-Z]+$");
    private static Pattern userContact_Pattern=Pattern.compile("^\\d{10}$");

    static Scanner sc = new Scanner(System.in);



    public String validateId() {
        String bookid;
        while (true) {
            System.out.println("Enter Book ID ");
            bookid = sc.nextLine();
            if (!ID_PATTERN.matcher(bookid).matches()) {
                System.out.println(RED+"SORRY ! PLEASE ENTER VALID BOOK ID "+RESET);
            } else {
                break;
            }
        }
        return bookid;
    }
    public String validateAuthor(String input){
        String result;
        while (true){
            if(input=="Author"){
                System.out.println("Enter Author");
            }else{
                System.out.println("Enter Author");
            }
            result=sc.nextLine();
            if(!Genre_Pattern.matcher(result).matches()){
                System.out.println(RED+"Please Enter Valid "+input+RESET);
            }
            else{
                break;
            }

        }
        return result;
    }
    public String validateTitle(String input){
        String result;
        while (true){
            if(input=="Title"){
                System.out.println("Enter Title");
            }else{
                System.out.println("Enter Author");
            }
            result=sc.nextLine();
            if(!Author_Pattern.matcher(result).matches()){
                System.out.println(RED+"Please Enter Valid "+input+RESET);
            }
            else{
                break;
            }

        }
        return result;
    }

    public String validateIsbn(String input){
        String result;
        while (true){
            if(input=="Isbn"){
                System.out.println("Enter Isbn");
            }else{
                System.out.println("Enter Author");
            }
            result=sc.nextLine();
            if(!Isbn_Pattern.matcher(result).matches()){
                System.out.println(RED+"Please Enter Valid "+input+RESET);
            }
            else{
                break;
            }

        }
        return result;
    }

    public String validateGenre(String input){
        String result;
        while (true){
            if(input=="Genre"){
                System.out.println("Enter Genre");
            }else{
                System.out.println("Enter Genre");
            }
            result=sc.nextLine();
            if(!Genre_Pattern.matcher(result).matches()){
                System.out.println(RED+"Please Enter Valid "+input+RESET);
            }
            else{
                break;
            }

        }
        return result;
    }
    public String validatePrice(){
        String price;
        while(true){
            System.out.println("Enter Price ");
            price=sc.nextLine();
            if(!Price_Pattern.matcher(price).matches()){
                System.out.println(RED+"Enter valid Price"+RESET);
            }
            else{
                break;
            }
        }
        return price;
    }
    public String validateUserLibraryId(){
        String userLibraryId;
        while(true){
            System.out.println("Enter User ID ");
            userLibraryId=sc.nextLine();
            if(!userLibraryId_Pattern.matcher(userLibraryId).matches()){
                System.out.println(RED+"Enter valid User ID"+RESET);
            }
            else{
                break;
            }
        }
        return userLibraryId;
    }


    public String validateUserName(String input) {
        String result;
        while (true){
            if(input=="User Name"){
                System.out.println("Enter User Name");
            }else{
                System.out.println("Enter User Name");
            }
            result=sc.nextLine();
            if(!userName_Pattern.matcher(result).matches()){
                System.out.println(RED+"Please Enter Valid "+input+RESET);
            }
            else{
                break;
            }

        }
        return result;
    }

    public String validateuserContact(String input) {
        String result;
        while (true){
            if(input=="User Contact"){
                System.out.println("Enter User Contact");
            }else{
                System.out.println("Enter User Contact");
            }
            result=sc.nextLine();
            if(!userContact_Pattern.matcher(result).matches()){
                System.out.println(RED+"Please Enter Valid "+input+RESET);
            }
            else{
                break;
            }

        }
        return result;

    }

    public String validateuserIssueBook(String input) {
        String result;
        while (true){
            if(input=="User Contact"){
                System.out.println("Enter User id");
            }else{
                System.out.println("Enter User Contact");
            }
            result=sc.nextLine();
            if(!userContact_Pattern.matcher(result).matches()){
                System.out.println(RED+"Please Enter Valid "+input+RESET);
            }
            else{
                break;
            }

        }
        return result;
    }

}



