
import java.util.*;

/**
 * Given a list of intervals, find minimum number of points which will intersect all intervals.
 * @author jiadong
 *
 */
public class countIntersect {
	
	public static class Interval{
		int start;
		int end;
		public Interval(int x,int y){
			start = x;
			end = y;
		}
	}
	
	public static int count(List<Interval> input){
		List<Interval> combine = new ArrayList<>();
		combine.add(input.get(0));
		for(int i=1;i<input.size();i++){
			Interval cur = combine.get(combine.size()-1);
			if(input.get(i).start <= cur.end){
				Interval newInterval = new Interval(cur.start,Math.max(input.get(i).end, cur.end));
				combine.remove(cur);
				combine.add(newInterval);
			}else{
				combine.add(input.get(i));
			}
		}
		return combine.size();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> input = new ArrayList<>();
		input.add(new Interval(0,4));
		input.add(new Interval(2,5));
		input.add(new Interval(6,9));
		input.add(new Interval(9,11));
		System.out.print(count(input));
	}

}
