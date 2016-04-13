import java.util.*;

/**
 * Given list of integers, find two elements such that their sum is closest to zero.
 * @author jiadong
 *
 */
public class TwoSumClosest {

	public static int[] findPair(int[] input){
		int[] res = new int[2];
		if(input == null || input.length == 0){
			return res;
		}
		Arrays.sort(input);
		
		int l = 0;
		int r = input.length - 1;
		
		int closest_l = l;
		int closest_r = r;
		
		int sum = Integer.MAX_VALUE;
		int closest = Integer.MAX_VALUE;
		while(l < r){
			sum = input[l] + input[r];
			if(Math.abs(sum) < Math.abs(closest)){
				closest = sum;
				closest_l = l;
				closest_r = r;
			}
			if(sum < 0){
				l++;
			}else{
				r--;
			}
		}
		res[0] = closest_l;
		res[1] = closest_r;
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,3,4,2,-1,3,-2,-10,3};
		System.out.print(findPair(input)[0]+"\t"+findPair(input)[1]);
	}

}
