import java.util.*;
public class Word_Counter
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Word Counter:");
        System.out.println("Text File(F) or You want to write(T)?");
        System.out.print("Specify(T or F):");//here T specifies 
        char ch=sc.next().charAt(0);
        if(Character.isAlphabetic(ch)&&(ch=='t'||ch=='T')&&(ch=='f'||ch=='F'))
            ch=Character.toUpperCase(ch);
        else
        {
            System.out.println("Wrong Choice!!!");
        }
        if(ch=='T')
        {

        }
        else if(ch=='F')
        {
            
        }
    }
}