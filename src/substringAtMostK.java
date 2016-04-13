import java.util.HashMap;
import java.util.Map;
/**
 * Find longest substring with m distinct characters.
 * @author jiadong
 *
 */

public class substringAtMostK {
	
	public static String find(int m,String input){
		StringBuilder sb = new StringBuilder();
		Map<Character,Integer> myMap = new HashMap<Character,Integer>();
		int maxLength = Integer.MIN_VALUE;
		String res = "";
		for(int i=0;i<input.length();i++){
			char curChar = input.charAt(i);
			sb.append(curChar);
			if(!myMap.containsKey(curChar)){
				myMap.put(curChar,1);
				while(sb.length()>0&&myMap.size()>m){
					char toDelete = sb.charAt(0);
					sb.deleteCharAt(0);
					myMap.put(toDelete, myMap.get(toDelete)-1);
					if(myMap.get(toDelete) == 0){
						myMap.remove(toDelete);
					}
				}
			}else{
				myMap.put(curChar,myMap.get(curChar)+1);
			}
			if(sb.length() > maxLength){
				maxLength = sb.length();
				res = sb.toString();
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
