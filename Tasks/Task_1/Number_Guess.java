import java.util.*;
public class Number_Guess extends Main_Logic
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Number Guessing Game");
        System.out.println("Welcome to the game where you guess numbers");
        System.out.println("Enter a number to guess");
        int num=sc.nextInt();
        boolean result=guess(num);
        if(result==true)
            System.out.println("Yes!!! the number Guessed is Correct");
        else
        {
            System.out.println("No, the guess is incorrect!!!");
            System.out.println("Correct number is:"+returnNum);
        }
        sc.close();
    }
}