import java.io.IOException;
import java.util.Scanner;

public class User extends Contact {
    public static void main(String[] args)throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("---Address Book System---");
        System.out.println("Welcome to Contact Address System.");
        int ch;
        String s;
        AddressBook address=new AddressBook();
        do{
            System.out.println("1.) Add Contact.");
            System.out.println("2.) Edit Contact.");
            System.out.println("3.) Remove Contact.");
            System.out.println("4.) Search for a Contact.");
            System.out.println("5.) Display all Contacts.");
            System.out.println("0.) Exit Program.");
            System.out.println("Enter Your Choice:");
            ch=sc.nextInt();

            sc.nextLine();
            switch(ch)
            {
                case 0://Exit Program
                System.out.println("Exitting Program:");
                System.exit(0);
                break;
                case 1://Add contact
                    System.out.print("Enter Name:");
                    name=sc.nextLine();
                    System.out.print("Enter Phone Number:");
                    PhoneNumber=sc.nextLine();
                    System.out.print("Enter Email address:");
                    email=sc.nextLine();
                    if(name==""||PhoneNumber==""||email=="")
                    {
                        System.out.println("Empty values...try again");
                    }
                    else
                        address.addContact(name,PhoneNumber,email);
                    break;
                    case 2://Edit Contact
                    System.out.println("Enter name:");
                    name=sc.nextLine();
                    s=address.searchContact(name);
                    if(s!="")
                    {
                        System.out.print("Enter Name:");
                        name=sc.nextLine();
                        System.out.print("Enter Phone Number:");
                        PhoneNumber=sc.nextLine();
                        System.out.print("Enter Email address:");
                        email=sc.nextLine();
                        if(name==""||PhoneNumber==""||email=="")
                        {
                            System.out.println("Empty values...try again");
                        }
                        else{
                            String updatedString=name+" "+PhoneNumber+" "+email;
                            address.editContact(name, updatedString);
                        }
                    }
                    else
                    {
                        System.out.println("Contact not present, just add it in ContactData");
                    }
                    break;
                case 3://Remove Contact
                    System.out.print("Delete all(A) or just 1 contact(S):");
                    char chr=sc.next().charAt(0);
                    chr=Character.toUpperCase(chr);
                    ch=Character.toUpperCase(chr);
                    sc.nextLine();
                    if(chr=='A')
                        address.deleteAllContact();
                    else if(chr=='S')
                    {
                        System.out.print("Enter Name:");
                        name=sc.nextLine();
                        address.removeContact(name);
                    }
                    break;
                case 4://Search Contact
                    System.out.print("Enter Name:");
                    name=sc.nextLine();
                    s=address.searchContact(name);
                    if(s=="")
                    {
                        System.out.println("Contact not present");
                    }
                    else
                    {
                        String[] st=s.split(" ");
                        System.out.println("Name\t Phone Number\t Email Address ");
                        for(int i=0;i<st.length;i++)
                        {
                            System.out.print(st[i]+"\t");
                        }
                        System.out.println();
                    }
                    break;
                case 5://Display all Contacts
                    address.DisplayAllContacts();
                    break;
                default:
                    System.out.println("Wrong Choice...Please Choose again.");
                    break;
            }

        }while(ch!=0);
    }
}
