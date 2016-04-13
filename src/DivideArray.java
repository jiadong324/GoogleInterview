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
		List<Integer> cur = new ArrayList<>();
		helper(input,0,cur,res);
		System.out.print(res.size());
		for(List<Integer> list:res){
			System.out.print(list.toString()+'\t');
		}
		
		return true;
		
	}
	public static void helper(int[] curNums,int pos,List<Integer> cur, List<List<Integer>> res){
		if(cur.size() == 5){
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		if(cur.size()== 0){
			cur.add(curNums[pos]);
		}
		
		for(int i=pos+1;i<curNums.length;i++){
			
			if(cur.get(cur.size()-1)+1 == curNums[i]){
				cur.add(curNums[i]);
				helper(curNums,pos+1,cur,res);
				cur.remove(cur.size()-1);
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,2,3,3,4,4,5,5,6};
		divide(input);
	}

}
