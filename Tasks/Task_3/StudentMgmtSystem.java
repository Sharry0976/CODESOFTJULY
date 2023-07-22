import java.io.BufferedReader;
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
public class StudentMgmtSystem {
    public void addStudent(int reg_Id,String name,String dateOfBirth,int Class,int roll)throws IOException
    {  
        PrintWriter outFile=new PrintWriter(new FileWriter("StudentRecords.txt",true));
        outFile.print(reg_Id+" ");
        outFile.print(name+" ");
        outFile.print(dateOfBirth+" ");
        outFile.print(Class+" ");
        outFile.println(roll+" ");
        outFile.close();
    }

    public void editExistingStudentData(int reg_Id,String updatedString)throws FileNotFoundException,IOException
    {
        File file=new File("StudentRecords.txt");
        List<String> lines=new ArrayList<>();
        Scanner sc=new Scanner(file);

        while(sc.hasNextLine())
        {
            lines.add(sc.nextLine());
        }
        sc.close();

        boolean recordFound=false;
        for(int i=0;i<lines.size();i++)
        {
            String line=lines.get(i);
            String[] st=line.split(" ");

            int studentId=Integer.parseInt(st[0].trim());

            if(studentId==reg_Id)
            {
                lines.set(i,updatedString);
                recordFound=true;
                break;
            }
        }
        if(recordFound)
        {
            BufferedWriter writer=new BufferedWriter(new FileWriter(file));
            for(String line:lines)
            {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
            System.out.println("Record Updated");
        }
    }

    public String searchStudent(int reg_Id)throws IOException,NumberFormatException
    {
        String s="";
        File file=new File("StudentRecords.txt");
        Scanner sc=new Scanner(file);
        //boolean recordFound=false;
        while(sc.hasNextLine())
        {
            String line=sc.nextLine();
            String[] st=line.split(" ");

            int stId=Integer.parseInt(st[0].trim());
            if(stId==reg_Id)
            {
                s=line;
                //recordFound=true;
            }
        }
        sc.close();
        return s;

    }
    public void displayAll()throws IOException
    {
        System.out.println("ID\tName \tDate of Birth \tClass \tRoll ");
        Scanner inFile=new Scanner(new FileReader("StudentRecords.txt"));
        while(inFile.hasNextLine())
        {  
            String s=inFile.nextLine();
            String[] st=s.split(" ");
            for(int i=0;i<st.length;i++)
            {
                System.out.print(st[i]+"\t");
            }
            System.out.println();
        }
    }
    public void DeleteAllStudent()throws IOException
    {
        new FileWriter("StudentRecords.txt", false).close();
        System.out.println("Deletion Successful");
    }
    public void DeleteStudent(int reg_Id)throws IOException
    {
        File file=new File("StudentRecords.txt");
        List<String> lines=new ArrayList<>();

        Scanner sc=new Scanner(file);
        while(sc.hasNextLine())
        {
            lines.add(sc.nextLine());
        }
        sc.close();
        boolean recordFound=false;
        for(Iterator<String> iterator=lines.iterator();iterator.hasNext();){
            String line=iterator.next();
            String[] stRec=line.split(" ");
            int stId=Integer.parseInt(stRec[0].trim());
            if(stId==reg_Id)
            {
                iterator.remove();
                recordFound=true;
                break;
            }
        }

        if(recordFound){
            BufferedWriter writer=new BufferedWriter(new FileWriter(file));
            for(String line:lines)
            {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
            System.out.println("Record deleted Successfully");
        }
        else
        {
            System.out.println("Record does not exist");
        }
    }
}
