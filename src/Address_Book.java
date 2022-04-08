import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        System.out.println("Enter the First Name");
        fname = sc.next();
        int n = 0;
        for (i = 0; i < contactArrayList.size(); i++) {
            Contact contact = contactArrayList.get(i);
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
                n = 1;
                break;
            }
        }
        if (n == 0) {
            System.out.println("Contact is not Present");
        }
    }

    public void deleteContact() {
        System.out.println("Enter the First Name");
        fname = sc.next();
        int n = 0;
        for (i = 0; i < contactArrayList.size(); i++) {
            Contact contact = contactArrayList.get(i);
            if (fname.equals((contact.getFirstname()))) {
                contactArrayList.remove(i);
                System.out.println("Contact Named " + fname.toUpperCase() + " has been Deleted");
                n = 1;
                break;
            }
        }
        if (n == 0) {
            System.out.println("Contact is not Present");
        }
    }

    public void showContact() {
        for (i = 0; i < contactArrayList.size(); i++) {
            Contact contact = contactArrayList.get(i);
            System.out.println(contact.toString());
        }
    }

    public void store_Data() {
        try {
            String contactData = null;
            for (i = 0; i < contactArrayList.size(); i++) {
                Contact contact = contactArrayList.get(i);
                contactData = contact.getFirstname() + "," + contact.getLastname() + "," + contact.getAddress() + "," + contact.getCity() + "," + contact.getState() +
                        "," + contact.getPhoneno() + "," + contact.getZip() + "," + contact.getEmail() + "\n" + contactData;
            }
            Path file = Paths.get("Address_Book.txt");
            byte[] bytefile = contactData.getBytes();
            Files.write(file, bytefile);
        } catch (NullPointerException nullPointerException) {
            System.out.println("Conatct is blank");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void restoreData() {
        try {
            String data;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Address_Book.txt"));
            while ((data = bufferedReader.readLine()) != null && !data.equals("null")) {
                String[] seperatedData = data.split(",");
                Contact contact = new Contact();
                contact.setFirstname(seperatedData[0]);
                contact.setLastname(seperatedData[1]);
                contact.setAddress(seperatedData[2]);
                contact.setCity(seperatedData[3]);
                contact.setState(seperatedData[4]);
                contact.setPhoneno(seperatedData[5]);
                contact.setEmail(seperatedData[6]);
                contact.setZip(seperatedData[7]);
                contactArrayList.add(contact);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int Method_Number = 0;
        int Repeat;
        Address_Book address_book = new Address_Book();
        address_book.restoreData();
        do {
            System.out.println("Press 1 to Add Contact");
            System.out.println("Press 2 to Edit Contact");
            System.out.println("Press 3 to Delete Contact");
            System.out.println("Press 4 to View Contact");
            System.out.println("Press 5 to Save Contact");
            System.out.println("Press 6 to Restore Contact");
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
                case 5:
                    address_book.store_Data();
                    break;
                case 6:
                    address_book.restoreData();
                    break;
            }
            System.out.println("Do you Wish to Continue(1.Yes/2.No):");
            Repeat = sc.nextInt();
        }
        while (Repeat != 7);
    }
}