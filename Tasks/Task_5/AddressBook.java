import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    //add contact
    public void addContact(String name,String PhoneNumber, String email)throws IOException
    {
        PrintWriter outFile=new PrintWriter(new FileWriter("Contacts.txt",true));
        outFile.print(name+" ");
        outFile.print(PhoneNumber+" ");
        outFile.println(email+" ");
        outFile.close();
    }
    //edit contact
    public void editContact(String name,String updatedString)throws IOException,FileNotFoundException
    {
        File file=new File("Contacts.txt");
        List<String> contacts=new ArrayList<>();
        Scanner sc=new Scanner(file);

        while(sc.hasNextLine())
        {
            contacts.add(sc.nextLine());
        }
        sc.close();

        boolean recordFound=false;
        for(int i=0;i<contacts.size();i++)
        {
            String contact=contacts.get(i);
            String[] contactRow=contact.split(" ");
            if(name.contains(contactRow[0]))
            {
                contacts.set(i,updatedString);
                recordFound=true;
                break;
            }
        }
        if(recordFound)
        {
            BufferedWriter writer=new BufferedWriter(new FileWriter(file));
            for(String contact:contacts)
            {
                writer.write(contact);
                writer.newLine();
            }
            writer.close();
            System.out.println("Contact updated.");
        }
    }
    //remove contact
    public void removeContact(String name)throws IOException
    {
        File file=new File("Contacts.txt");
        List<String> contacts=new ArrayList<>();

        Scanner sc=new Scanner(file);
        while(sc.hasNextLine())
        {
            contacts.add(sc.nextLine());
        }
        sc.close();
        boolean recordFound=false;
        for(Iterator<String> iterator=contacts.iterator();iterator.hasNext();){
            String contact=iterator.next();
            String[] contactRec=contact.split(" ");
            if(name.equals(contactRec[0]))
            {
                iterator.remove();
                recordFound=true;
                break;
            }
        }

        if(recordFound){
            BufferedWriter writer=new BufferedWriter(new FileWriter(file));
            for(String contact:contacts)
            {
                writer.write(contact);
                writer.newLine();
            }
            writer.close();
            System.out.println("Contact deleted Successfully");
        }
        else
        {
            System.out.println("Contact does not exist");
        }
    }
    //Delete All Contact
    public void deleteAllContact()throws IOException
    {
        new FileWriter("Contacts.txt", false).close();
        System.out.println("All Contacts deleted successfully");
    }
    //display contact
    public void DisplayAllContacts()throws IOException
    {
        System.out.println("Name\t Phone Number\t email");
        Scanner inFile=new Scanner(new FileReader("Contacts.txt"));
        while(inFile.hasNextLine())
        {
            String s=inFile.nextLine();
            String[] st=s.split(" ");
            for(int i=0;i<st.length;i++)
            {
                System.out.print(st[i]+" ");
            }
            System.out.println();
        }
    }
    //search contact
    public String searchContact(String name)throws IOException
    {
        String s="";
        File file=new File("Contacts.txt");
        Scanner sc=new Scanner(file);
        while(sc.hasNextLine())
        {
            String contact=sc.nextLine();
            String[] st=contact.split(" ");

            if(name.contains(st[0]))
            {
                s=contact;
            }
        }
        sc.close();
        return s;
    }
}
