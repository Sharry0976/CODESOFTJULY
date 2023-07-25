public class AtmMethods extends BankAccount{
    //withdraw
    public void WithDraw(int accNo,int withdrawAmt)
    {
        if(amount<withdrawAmt)
        {
            System.out.println("Insufficient funds!!!");
        }
        else{
            amount=amount-withdrawAmt;
            System.out.println("Amount of Rs. "+withdrawAmt+"withdrawn from the account...");
            System.out.println("Total amount is: Rs. "+amount);
            
        }

    }
    //deposit
    public void Deposit(int accNo,int depositAmt)
    {
        amount=amount+depositAmt;
        System.out.println("Amount of Rs. "+depositAmt+"added to the account...");
        System.out.println("Total amount is: Rs. "+amount);
    }
    //Check Balance
    public void CheckBalance(int accNo)
    {
        System.out.println("Current Balance for account number:"+accNo+" is:"+amount);
    }
    //Display Profile
    public void DisplayProfile()
    {
        System.out.println("Account number: "+accountNo);
        System.out.println("Name: "+name);
    }
    public boolean validation(int accNo,int pinNo)
    {
        boolean isValid=false;
        if(accNo==accountNo && pinNo==pin)
            isValid=true;
        return isValid;  
    }
}
