import java.util.*;
public class Number_Guess extends Main_Logic
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Number Guessing Game");
        System.out.println("Welcome to the game where you guess numbers");
        int score=0;
        int guessChoice=3;
        boolean result;
        do
        {
            guessChoice--;
            System.out.println("Enter a number to guess");
            int num=sc.nextInt();
            result=guess(num);
            if(result==true)
            {
                System.out.println("Yes!!! the number Guessed is Correct");
                System.out.println("Want to play again?");
                System.out.print("Press 'Y' or 'y' to continue,N or n to exit:");
                guessChoice=3;
                score++;
                char ch=sc.next().charAt(0);
                if(ch=='y'||ch=='Y')
                {
                    continue;
                }
                else if(ch=='n'||ch=='N')
                {
                    System.out.println("Score:"+score);
                    break;
                }
                else
                {
                    System.out.println("Wrong Input selected...");
                    break;
                }

            }
            else if(returnNum<num)
            {
                System.out.println("Well... The number guessed is too high");
                System.out.println("Try Again!");
            }
            else
            {
                System.out.println("Well... The number guessed is too low");
                System.out.println("Try Again!");
            }
            if(guessChoice>0 && guessChoice<2)
                System.out.println("Only "+guessChoice+" choice left");
            else if(guessChoice>=2)
                System.out.println("Only "+guessChoice+" choices left");
            else
            {
                System.out.println("No more choice left...exit");
                System.out.println("Score:"+score);
                break;
            }
        }while(true);

        sc.close();
    }
}