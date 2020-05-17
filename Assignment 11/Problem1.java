/*Timothy Hoang
4/28/19
CMPT435-111*/
import java.util.Arrays;

public class Problem1 {
	
	public static void Sort3way(int[] a)
	{
		//complete the code from here
		//given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first, then all 1s and all 2s in last
		//in-place, O(n) expected

		int low = 0; //initialize values
		int mid = 0;
		int high = a.length-1;
		int temp;

		while(mid <= high){ //while the mid pointer and high have not met
			if(a[mid] == 0){ //if the pointer scans 0
				temp = a[low]; //swap the low and mid values
				a[low] = a[mid];
				a[mid] = temp;
				low++; //move the low and mid pointers up by one
				mid++;
			}
			else if(a[mid] == 1){ //if the pointer scans 1
				mid++; //move the mid pointer up by one
			}
			else if(a[mid] == 2){ //if the pointer scans 2
				temp = a[high]; //swap the high and mid values
				a[high] = a[mid]; 
				a[mid] = temp;
				high--; //move the high pointer down by one
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method
		int[] testarray={0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		// Test your method
		Sort3way(testarray);
		System.out.println(Arrays.toString(testarray));
		// Your method should output {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
	}
}