import java.io.*;
import java.util.Scanner;

//import java.util.ArrayList;

public class WordCounter_Main_Logic {
    public static int normalWordSize(String s)
    {
        s.trim();
        String words[]=s.split("[, .  ?]+");
        for(int i=0;i<words.length;i++)
        {
            System.out.print(words[i]+",");
        }
        System.out.println();
        int size=words.length;
        
        return size;
    }
    public static String readFile(String fileName)throws IOException
    {
        String str="";
        Scanner inFile=new Scanner(new FileReader(fileName));
        while(inFile.hasNext())
        {
            str+=inFile.nextLine();
        }
        return str;
    }
    
}
