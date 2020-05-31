/**
 * Description of DiceRolling *
 * 
 * DiceRolling is a program used to :
 *
 * Use the random method to get 'n' number of dice throws
 * Find the count for each of the sum of the two dice values obatainable from 2 to 12.
 * Find the probability of each sum value obtained. 
 *
 **/

import java.util.Random;

public class DiceRolling
{
	public void simulate(int rolls)
	{
		Random rand = new Random();
		int[] counts = new int[13];
		for(int k=0; k < rolls; k++)
		{
			int d1=rand.nextInt(6)+1;
			int d2=rand.nextInt(6)+1;
			System.out.println("Roll is : " + d1 + " + " + d2 + " = " + (d1+d2));
			counts[d1+d2] += 1;
		}
		System.out.println("\n");
		for(int k=2; k<=12; k++)
		{
			System.out.println("Number of " + k + "'s = " + counts[k] + "\tProbability of getting a " + k + " = " + ((float)counts[k]/rolls));
		}
	}
	
	public void main()
	{
		DiceRolling obj = new DiceRolling();
		obj.simulate();
	}
}