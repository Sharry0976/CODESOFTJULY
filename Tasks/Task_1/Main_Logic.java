//import java.util.*;

import java.util.Random;

public class Main_Logic {
    static int returnNum;
    public static boolean guess(int Guess)
    {
        boolean result=false;
        int GenNum=generateNumber();
        //System.err.println(GenNum);
        if(Guess==GenNum)
            result=true;
        return result;
    }
    private static int generateNumber()
    {
        Random rand=new Random(System.currentTimeMillis());
        int guess=rand.nextInt(101);
        if(guess==0)
            guess+=1;
        returnNum=guess;
        return guess;
    }
}
