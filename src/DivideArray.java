import java.util.*;

/**
 * Check if all integers in the list can be grouped into 5 consecutive number. 
 * For example [1,2,2,3,3,4,4,5,5,6] should return True because it can be grouped into (1,2,3,4,5)(2,3,4,5,6) with no other elements left.
 * @author jiadong
 *
 */

public class DivideArray {

	
	public static boolean divide(int[] input){
		List<List<Integer>> res = new ArrayList<>();
		if(input == null || input.length%5 != 0){
			return false;
		}
		Arrays.sort(input);

		
		return true;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,2,3,3,4,4,5,5,6};
		divide(input);
	}

}
