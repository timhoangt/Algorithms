/*Timothy Hoang
3/10/19
CMPT435-111*/



public class Problem1 {

	public static int count(double[] A, double x){
		// given sorted array A, and a value x, return the number of times x occurs in A
		// complete the method count() here
		// O(log n) expected
		// O(n) or slower will be graded out of 10 points

		int start = 0; //initialize all of the variables
		int end = A.length;
		int first;
		int last;
		int mid;
		int number;
		first = 1; //first and last need to be set to a number here or else it will not work
		last = 1;

		
		//first occurrence of x
		while(start<=end){ //while there is a set to search
			mid = (start + end) / 2; //get the middle point of the set
			if (mid != 0 && A[mid] == x && A[mid-1] != x){ //if its not the first number and matches what you're searching for and the number before does not match what you're searching for
				first = mid; //you found the first occurence of what you're looking for
				start = 0; //reset the start and end points of where you're searching
				end = A.length; 
				break;
			}
			else if (mid == 0 && A[mid] == x){ //if the number you're looking for is the first number
				first = mid; //you found the first occurence of what you're looking for
				start = 0; //reset the start and end point of where you're searching
				end = A.length;
				break;
			}
			else if (A[mid] == x && A[mid-1] == x){ //if the midpoint is what you're looking for and the number before is also what you're looking for
				end = mid-1; //move the end of where you're looking to the number before the midpoint
			}
			else if(A[mid]> x){ //if the midpoint is greater than the number you're looking for
				end = mid-1; //move the endpoint of where you're looking to the number before the midpoint
			}
			else{ //if the midpoint is less than the number you're looking for
				start = mid+1; //move the startpoint of where you're looking to the number after the midpoint
			}
		}

		//last occurrence of x
		while(start<=end){ 
			mid = (start + end) / 2; 
			if (mid != A.length-1 && A[mid] == x && A[mid+1] != x){ //if its not the last number and the midpoint is what you're searching for and the number after is not what you're searching for
				last = mid; //that is the last occurence of what you're looking for
				break;
			}
			else if (mid == A.length-1 && A[mid] == x){ //if the nubmer you're looking for is the last number
				last = mid; //you found the last occurence of the nubmer you're looking for
				break;
			}
			else if (A[mid] == x && A[mid+1] == x){ //if the midpoint is the nubmer you're looking for and the number after is also the number you're looking for
				start = mid+1; //move the startpoint of where you're looking to the number after the midpoint
			}
			else if(A[mid]> x){ //if the midpoint is greater than the number you're looking for
				end = mid-1; //move the endpoint to the number before the midpoint
			}
			else{ //if the midpoint is less than the number you're looking for
				start = mid+1; //move the endpoint of where you're looking to the number after the midpoint
			}
		}

		number = last - first + 1; //get the number of times your nubmer appears
		return number;
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test your count() method here
		
		double[] testarray = {1.3, 2.1, 2.1, 2.1, 2.1, 6.7, 7.5, 7.5, 8.6, 9.0};
		double t1 = 2.1;
		double t2 = 7.5;
		double t3 = 1.3;
		System.out.println(t1+" appears "+ count(testarray, t1) + " times");
		System.out.println(t2+" appears "+ count(testarray, t2) + " times");
		System.out.println(t3+" appears "+ count(testarray, t3) + " times");
	}

}
