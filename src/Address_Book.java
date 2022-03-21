import java.util.Scanner;
public class Address_Book {
    Scanner sc = new Scanner(System.in);
    Contact contact = new Contact();
    public void setContact(){
        System.out.println("Enter the First Name=");
        contact.setFirstname(sc.next());
        System.out.println("Enter the Last Month=");
        contact.setLastname(sc.next());
        System.out.println("Enter the Address");
        contact.setAddress(sc.next());
        System.out.println("Enter the City");
        contact.setCity(sc.next());
        System.out.println("Enter the State");
        contact.setState(sc.next());
        System.out.println("Enter the Phone Number");
        contact.setPhoneno(sc.next());
        System.out.println("Enter the Zip-Code");
        contact.setZip(sc.next());
        System.out.println("Enter the Email");
        contact.setEmail(sc.next());
    }
    public void showContact(){
        System.out.println(contact.toString());
    }
    public static void main(String[] args) {
        Address_Book address_book = new Address_Book();
        address_book.setContact();
        address_book.showContact();
    }
}