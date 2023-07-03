//import java.util.ArrayList;

public class WordCounter_Main_Logic {
    public static int normalWordSize(String s)
    {
        s.trim();
        String words[]=s.split("[, .  ]+");
        int size=words.length;
        
        return size;
    }
}
