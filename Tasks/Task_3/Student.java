import java.io.IOException;
import java.util.Scanner;

public class Student
    {
    public static void main(String[] args)throws IOException{
        Scanner sc=new Scanner(System.in);

        System.out.println("------Student Management System------");
        System.out.println("Options------");
        System.out.println("Press 1 to add student.");
        System.out.println("Press 2 to edit Existing student's information.");
        System.out.println("Press 3 to search for a student.");
        System.out.println("Press 4 to display all student.");
        System.out.println("Press 5 to delete students.");
        System.out.println("Press 0 to exit.");
        int ch;
        int reg_Id;//registration no
        String name;
        String dateOfBirth;
        int Class;
        int roll;
        String s;

        StudentMgmtSystem student=new StudentMgmtSystem();
    
        do
        {
            System.out.print("Enter a choice:");
            ch=sc.nextInt();

            switch (ch) {
                case 1://Add Student
                    System.out.println("Enter Registration id:");
                    reg_Id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Name:");
                    name=sc.nextLine();
                    System.out.println("Enter Date of Birth:");
                    dateOfBirth=sc.next();
                    System.out.println("Enter Class:");
                    Class=sc.nextInt();
                    System.out.println("Enter roll no:");
                    roll=sc.nextInt();
                    if(reg_Id==0||name==""||dateOfBirth==""||Class==0||roll==0)
                        System.out.println("Empty Values.");
                    else
                        student.addStudent(reg_Id,name,dateOfBirth,Class,roll);
                    break;
                case 2://Edit student
                    System.out.println("Enter Registration id:");
                    reg_Id=sc.nextInt();
                    sc.nextLine();
                    s=student.searchStudent(reg_Id);
                    if(s!="")
                    {
                        System.out.println("Enter Name:");
                        name=sc.nextLine();
                        System.out.println("Enter Date of Birth:");
                        dateOfBirth=sc.next();
                        System.out.println("Enter Class:");
                        Class=sc.nextInt();
                        System.out.println("Enter roll no:");
                        roll=sc.nextInt();
                        if(reg_Id==0||name==""||dateOfBirth==""||Class==0||roll==0)
                            System.out.println("Empty Values.");
                        else
                        {
                                String updatedString=reg_Id+" "+name+" "+dateOfBirth+" "+Class+" "+roll+" ";
                                student.editExistingStudentData(reg_Id,updatedString);
                        }
                    }
                    else
                    {
                        System.out.println("Record Not Present, just add it in StudentData");
                    }

                    break;
                case 3://Search for student
                    System.out.println("Enter the registration id");
                    reg_Id=sc.nextInt();
                    s=student.searchStudent(reg_Id);
                    if(s=="")
                    {
                        System.out.println("Record not present:");
                    }
                    else
                    {
                        String[] st=s.split(" ");
                        System.out.println("ID\t Name \t Date of Birth \t Class \t Roll ");
                        for(int i=0;i<st.length;i++)
                        {
                            System.out.print(st[i]+"\t");
                        }
                        System.out.println();
                    }
                    break;
                case 4://display all Students
                    student.displayAll();
                    break;
                case 5://delete student
                    System.out.print("Delete all(A) or just 1 student(S):");
                    char chr=sc.next().charAt(0);
                    chr=Character.toUpperCase(chr);
                    if(chr=='A')
                        student.DeleteAllStudent();
                    else if(chr=='S')
                    {
                        System.out.print("Enter Student id:");
                        reg_Id=sc.nextInt();
                        student.DeleteStudent(reg_Id);
                    }
                    break;
                case 0:
                    System.out.println("Exiting Program!!!");
                    System.exit(0);
                    break;
            
                default:
                    break;
            }
        }while (ch!=0);
        sc.close();
    }


}