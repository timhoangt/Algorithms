/*
Timothy Hoang
4/1/19
CMPT435-111
*/
public class Problem3 {

	
	public static int sum(int n)
	{
		// Complete this method to compute the sum of the series 1^1 + 2^2 + 3^3 + ….. + n^n
		// Full credits will be awarded to a recursive algorithm
		// Non-recursive algorithm will be scored out of 10 points
		// Feel free to change the return type or parameters
	    if (n == 1) {
	        return 1; //base case when n = 1
	    } 
		else 
		{
        	return (int)Math.pow(n, n) + sum(n - 1); //general case gets power of n^n and adds sum of previous powers
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method
		int upperbd = 4;
		// Test your method
		System.out.println("Given n = " + upperbd + ", the sum of 1^1 + 2^2 + 3^3 + ….. + n^n is " + sum(upperbd));
		// Your method should return 288
			
	}
}
