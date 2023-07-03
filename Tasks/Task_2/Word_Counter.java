import java.util.*;
public class Word_Counter extends WordCounter_Main_Logic
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Word Counter:");
        System.out.println("Text File(F) or You want to write(T)?");
        System.out.print("Specify(T or F):");//here T specifies 
        char ch=sc.nextLine().charAt(0);
        
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
            String str=sc.nextLine();
            word_size=normalWordSize(str);
        }
        else if(ch=='F')
        {

        }
        System.out.println("Word size:"+word_size);
        sc.close();
    }
}