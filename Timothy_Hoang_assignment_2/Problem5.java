/*Timothy Hoang
2/10/19
CMPT435-111*/
public class Problem5 {

	
	
	public static boolean majority(int[] A)
	{
		/*
		Input: an array A of n integers (positive, negative, or 0), elements sorted in ascending order.
		Output: if there exists a majority element.
		An element is a majority if it appears more than n/2 times. For example, if the input list is: 
		{0, 0, 0, 0, 0, 0, 1, 1, 2, 4, 7}
		The output should be true, as 0 appears 6 times (>n/2 = 11/2 times).
		However, if the input list is:
		{0, 0, 0, 1, 1, 2, 3, 10, 10}
		The majority element does not exist.
		Design an algorithm that solves this problem.
		*/
		
		// Complete this method

		int check = A[0]; //number you are checking for multiples of
		int count = 0; //current count
		int maxcount = 0; //highest count you have
		boolean majority = false; //if you have a majority or not
		for (int i = 0; i < A.length; i++) //goes through the entire array
		{
			if (A[i] == check) //if the number in the array matches the number you are looking for
			{
				count++; //count up one
				if (count > maxcount) //if the count is bigger than the highest count you have
				{
					maxcount = count; //maxcount becomes your current count
				}
			}
			else if (A[i] != check) //if the number in the array does not match the number you are looking for
			{
				count = 1; //reset the count to one
				check = A[i]; //start checking for the new number
			}
		}
		if (maxcount > (A.length/2)) //if the maxcount is higher than half the size of the array
		{
			majority = true; //you have a majority
		}
		return majority;		
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Test your majority method
		
		int[] testarray1 = {0, 0, 0, 0, 0, 0, 1, 1, 2, 4, 7};
		
		int[] testarray2 = {0, 0, 0, 1, 1, 2, 3, 10, 10};
		
		
		System.out.println("Does there exist a majoirty element in testarray1? "+ majority(testarray1));
		System.out.println("Does there exist a majoirty element in testarray2? "+ majority(testarray2));
		
	}

}
