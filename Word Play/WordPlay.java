/**
 * Description of WordPlay *
 * 
 * WordPlay is a program used to :
 *
 * Replace every occurence of a vowel with a character provided.
 * Replace every occurence of a given character in a string with '+' for odd index positions and '*' for even index positions.
 *
 **/

import edu.duke.*;

public class WordPlay
{
    public boolean isVowel(char ch)
    {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
        {   
            return true;
        }
        else
        {   
            return false;
        }
    }
    
    public String replaceVowels(String phrase, char ch)
    {
        StringBuilder ph = new StringBuilder(phrase);
        for(int i=0; i < phrase.length() ;i++)
        {
            char currChar = phrase.charAt(i);
            if(isVowel(currChar))
            {
                ph.setCharAt(i, ch);
            }
        }
        return ph.toString();
    }
    
    public String emphasize(String phrase, char ch)
    {
        int c=0,indx = 0;
        char newcurrChar, newch;
        StringBuilder ph = new StringBuilder(phrase);
        for(int i=0; i < ph.length() ;i++)
        {
            char currChar = ph.charAt(i);
            newcurrChar = Character.toLowerCase(currChar);
            newch = Character.toLowerCase(ch);
            if (currChar == ch || newcurrChar == newch)
            {
                indx = phrase.indexOf(currChar, indx+1);
                if(indx % 2 == 0)
                {
                    ph.setCharAt(i, '*');
                }
                else if(indx % 2 != 0)
                {
                    ph.setCharAt(i, '+');
                }
            }
        }
        return ph.toString();
    }

    public void main()
    {
        System.out.println("The string is : Make U A New World");
        String s1 = replaceVowels("Make U A New World", '*');
        System.out.println("\nResult of replaceVowels = " + s1);
        System.out.println("\nThe string is : Mary Bella Abracadabra");
        String s2 = emphasize("Mary Bella Abracadabra", 'a');
        System.out.println("\nResult of emphasize = "+s2);
    }
}