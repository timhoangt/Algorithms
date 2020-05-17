/*Timothy Hoang
5/5/19
CMPT435-111*/

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Coinchange {

	public static int greedycoinchange(int givenvalue, int[] givencoins)
	{
		
		// Complete the code here to make change of givenvalue using coins in the array givencoins
		// Minimize the number of coins used
		// Input: Coin denominations in array givencoins are already sorted in descending order
		// Output: The number of coins used to make change of givenvalue
		int s = givenvalue; //initialize how much we need to make change for how many coins we have and palce in array
		int coins = 0;
		int i = 0;

		while(i<givencoins.length && s>0){ //while there are still more coin denominations and money to make change for
			while(s>=givencoins[i]){ //while the denomination can fit in what we need to make change for
				s = s - givencoins[i]; coins++;//subtract the denomination from the value and add one to our coin count
			}
			i++; //move up to next coin denomination in the array
		}

		return coins; //return how many coins we used
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 0; // n cents
		
		Scanner reader = new Scanner(System.in);  
		
		System.out.println("Please enter the value you want to make change: ");
		
		n = reader.nextInt();
		
		int[] coins = {25, 10, 5, 1};
		
		
		System.out.println("used "+ greedycoinchange(n, coins)+" coins for "+ n + " cents");
		
		
		
	}

}
