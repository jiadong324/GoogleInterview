import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers, create a 7 number lottery ticket from the string. 
 * The 7 numbers in the lottery ticket must be from 1-59 and must be unique. All numbers in the string must be used in order.
 * @author jiadong
 */
public class LotteryNumber {
	
	public static List<List<Integer>> createLottery(String input){
		List<List<Integer>> res = new ArrayList<>();
		int len = input.length();
		if(len < 7 || len > 14){
			return res;
		}
		List<Integer> cur = new ArrayList<>();
		LotteryHelp(input,cur,res,7);
		for(List<Integer> tmp:res){
			System.out.print(tmp);
		}
		return res;
	}
	
	public static void LotteryHelp(String input,List<Integer> cur, List<List<Integer>> res, int limit){
		if(input.length()==0){
			if(limit == 0){
				res.add(cur);
				return;
			}			
		}
		if(limit == 0){
			return;
		}
		if(Integer.parseInt(input.substring(0,1)) > 0 && Integer.parseInt(input.substring(0,1)) < 60){
			cur.add(Integer.parseInt(input.substring(0,1)));
			LotteryHelp(input.substring(1),cur,res,limit-1);
		}
		if(input.length() > 1 && Integer.parseInt(input.substring(0,2)) > 0 && Integer.parseInt(input.substring(0,2)) < 60){
			cur.add(Integer.parseInt(input.substring(0,2)));
			LotteryHelp(input.substring(2),cur,res,limit-1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
