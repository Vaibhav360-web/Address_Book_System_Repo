import javax.lang.model.type.NullType;
import java.util.Scanner;

public class Address_Book {
    Scanner sc = new Scanner(System.in);
    Contact contact = new Contact();

    public void setContact() {
        System.out.println("Enter the First Name=");
        contact.setFirstname(sc.next());
        System.out.println("Enter the Last Name=");
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

    public void editContact() {
        int change = 0;
        String fname;
        System.out.println("Press 1 to Edit Contact");
        System.out.println("Press 2 to Delete Number");
        System.out.println("Press 3 to Exit");
        change = sc.nextInt();
        switch (change) {
            case 1:
                System.out.println("Enter the First Name");
                fname = sc.next();
                if (fname.equals(contact.getFirstname())) {
                    System.out.println("Contact is present");
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
                    System.out.println(contact.toString());
                } else {
                    System.out.println("Contact is not Present");
                }
                break;
            case 2:
                System.out.println("Enter the First Name");
                fname = sc.next();
                if (fname.equals((contact.getFirstname()))) {
                    contact = null;
                    try {
                        System.out.println(contact.toString());
                    }catch (NullPointerException ne){
                        System.out.println("Contact is Deleted");
                    }

                } else {
                    System.out.println("Contact is not Present");
                }
                break;
            default:
                System.out.println("Bye");
                break;
        }

    }

    public void showContact() {
        System.out.println(contact.toString());
    }

    public static void main(String[] args) {
        Address_Book address_book = new Address_Book();
        address_book.setContact();
        address_book.showContact();
        address_book.editContact();
    }
}