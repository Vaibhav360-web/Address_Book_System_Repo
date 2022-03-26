import java.util.ArrayList;
import java.util.Scanner;

public class Address_Book {
    static Scanner sc = new Scanner(System.in);
    String fname;
    int i = 0;
    ArrayList<Contact> contactArrayList = new ArrayList<>();

    public void setContact() {
        Contact contact = new Contact();
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
        contactArrayList.add(contact);
    }


    public void editContact() {
        Contact contact = new Contact();
        System.out.println("Enter the First Name");
        fname = sc.next();
        for (i = 0; i < contactArrayList.size(); i++) {
            contact = contactArrayList.get(i);
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
            } else {
                System.out.println("Contact is not Present");
            }
        }
    }

    public void deleteContact() {
        Contact contact = new Contact();
        System.out.println("Enter the First Name");
        fname = sc.next();
        for (i = 0; i < contactArrayList.size(); i++) {
            contact = contactArrayList.get(i);
            if (fname.equals((contact.getFirstname()))) {
                contactArrayList.remove(i);
                System.out.println("Contact Named " + fname.toUpperCase() + " has been Deleted");
            }
            else{
                System.out.println("Contact is not Present");
            }
        }
    }

    public void showContact() {
        Contact contact = new Contact();
        for (i = 0; i < contactArrayList.size(); i++) {
            contact = contactArrayList.get(i);
            System.out.println(contact.toString());
        }
    }

    public static void main(String[] args) {
        int Method_Number = 0;
        int Repeat;
        Address_Book address_book = new Address_Book();
        do {
            System.out.println("Press 1 to Add Contact");
            System.out.println("Press 2 to Edit Contact");
            System.out.println("Press 3 to Delete Contact");
            System.out.println("Press 4 to View Contact");
            Method_Number = sc.nextInt();
            switch (Method_Number) {
                case 1:
                    address_book.setContact();
                    break;
                case 2:
                    address_book.editContact();
                    break;
                case 3:
                    address_book.deleteContact();
                    break;
                case 4:
                    address_book.showContact();
                    break;
            }
            System.out.println("Do you Wish to Continue(1.Yes/2.No):");
            Repeat = sc.nextInt();
        }
        while (Repeat != 2);
    }
}