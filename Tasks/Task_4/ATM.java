import java.util.Scanner;

public class ATM extends BankAccount
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int ch;
        AtmMethods atm=new AtmMethods();
        int accNo,pinNo;
        System.out.println("Enter your account number:");
        accNo=sc.nextInt();
        System.out.println("Enter your account pin:");
        pinNo=sc.nextInt();
        boolean validate=atm.validation(accNo, pinNo);
        if(!validate)
        {
            System.out.println("Account number or PIN are not same...try again");
        }
        else
        {
            do
            {
                System.out.println("Welcome to Atm System");
                System.out.println("1.)Display Account Info");
                System.out.println("2.)Check Balance.");
                System.out.println("3.)Deposit Balance.");
                System.out.println("4.)Withdraw Balance.");
                System.out.println("0.)Exit program.");
                System.out.print("Enter your Choice:");
                ch=sc.nextInt();

                switch(ch)
                {
                    case 0://exit program
                        System.out.println("Exitting program:");
                        System.exit(0);
                        break;
                    case 1://Deisplay profile
                        atm.DisplayProfile();
                        break;
                    case 2://check balance
                        atm.CheckBalance(accNo);
                        break;
                    case 3:
                        System.out.println("Enter the amount you want to deposit:");
                        int depositAmt=sc.nextInt();
                        atm.Deposit(accNo, depositAmt);
                        break;
                    case 4:
                        System.out.println("Enter the amount you want to withdraw:");
                        int withdrawAmt=sc.nextInt();
                        atm.WithDraw(accNo, withdrawAmt);
                        break;
                    default:
                        System.out.println("Wrong Input...try again:");
                        break;
                }
            }while(ch!=0);
        }
        sc.close();
    }
}