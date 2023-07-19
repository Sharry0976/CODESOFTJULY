import java.util.*;
import java.io.IOException;
public class Word_Counter extends WordCounter_Main_Logic
{
    public static void main(String[] args)throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Word Counter:");
        System.out.println("Text File(F) or You want to write(T)?");
        System.out.print("Specify(T or F):");//here T specifies 
        char ch=sc.nextLine().charAt(0);
        String str;
        
        int word_size=0;
        if(Character.isLetter(ch)&&(ch=='t'||ch=='T'||ch=='f'||ch=='F'))
            ch=Character.toUpperCase(ch);
        else
        {
            System.out.println("Wrong Choice!!!");
        }
        if(ch=='T')
        {
            System.out.println("Enter the Text:");
            str=sc.nextLine();
            word_size=normalWordSize(str);
            if(word_size==0)
            {
                System.out.println("Empty String");
            }
        }
        else if(ch=='F')
        {
            String FileName;
            System.out.println("Enter the FileName:");
            FileName=sc.nextLine();
            str=readFile(FileName);
            word_size=normalWordSize(str);
            if(word_size==0)
            {
                System.out.println("Empty File.");
            }
        }
        System.out.println("Word size:"+word_size);
        sc.close();
    }
}