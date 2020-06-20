/**
 * Description of CharactersInPlay *
 * 
 * CharactersInPlay is a program used to :
 * 
 * Display all characters and their number of dialogues in a play.
 * Display all characters who have a number of dialogues within a specified range.
 *
 **/


import edu.duke.*;
import java.util.*;

public class CharactersInPlay
{
    private ArrayList<String> name;
    private ArrayList<Integer> count;
    
    public CharactersInPlay()
    {
        name = new ArrayList<String>();
        count = new ArrayList<Integer>();
    }
    
    public void update(String person)
    {
        int index = name.indexOf(person);
        if (index == -1){
            name.add(person);
            count.add(1);
        }
        else
        {
            int freq = count.get(index);
            count.set(index,freq+1);
        }
    }
    
    public void findAllCharacters()
    {
        FileResource fr = new FileResource();
        for(String line : fr.lines())
        {
            int index = line.indexOf('.');
            if(index == -1)
            {
                continue;
            }
            else
            {
                String person = line.substring(0,index);
                update(person);
            }
        }
    }
    
    public void tester()
    {
        findAllCharacters();
        for(int i=0; i < name.size(); i++)
        {
            if (count.get(i) > 1) 
            {
                System.out.println(name.get(i)+"  "+count.get(i));
            }
        }
    }
    
    public void charactersWithNumParts(int num1, int num2)
    {
        for(int i=0; i < name.size(); i++)
        {
            if (count.get(i) >= num1 && count.get(i) <= num2)
            {
                System.out.println(name.get(i)+"  "+count.get(i));
            }
        }
    }
    
    public void main()
    {
		CharactersInPlay obj = new CharactersInPlay();
        obj.tester();
        System.out.println("\n\n");
        obj.charactersWithNumParts(10,15);
    }
}