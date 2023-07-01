import java.util.*;
public class Number_Guess extends Main_Logic
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Number Guessing Game");
        System.out.println("Welcome to the game where you guess numbers");

        boolean result;
        do
        {
            System.out.println("Enter a number to guess");
            int num=sc.nextInt();
            result=guess(num);
            if(result==true)
            {
                System.out.println("Yes!!! the number Guessed is Correct");
                break;
            }
            else if(returnNum<num)
            {
                System.out.println("Well... The number guessed is too high");
                //System.out.println("Correct number is:"+returnNum);
                System.out.println("Try Again!");
            }
            else
            {
                System.out.println("Well... The number guessed is too low");
                //result=guess(num);
                System.out.println("Try Again!");
            }
        }while(true);
        sc.close();
    }
}