import java.util.HashMap;
import java.util.Map;

/**
 * Sort an array of strings according to predefined character order. 
 * array：['animal','duck','snake','zebra','horse','mouse'], favorite letter:'zh',  output--->['zebra','horse','animal','duck','mouse','snake']
 * array：['aab','baa','caa','aaa','aaaa'], favorite letter:'ab',  output--->['aaa','aaaa','aab','baa','caa']
 * @param args
 */

public class StringSort {

	 public static void sort(String[] input, String fav,int low,int high){
	    	if(low < high){
	    		int idx = partition(input,fav,low,high);
	    		sort(input,fav,low,idx-1);
	    		sort(input,fav,idx+1,high);
	    	}
	    }
    public static int stringCompare(String str1,String str2,String fav){
    	Map<Character,Integer> favToIdx = new HashMap<>();
    	for(int i=0;i<fav.length();i++){
    		favToIdx.put(fav.charAt(i),i);
    	}
    	int p = 0;
    	while(p < str1.length() && p < str2.length()){
    		char c1 = str1.charAt(p);
    		char c2 = str2.charAt(p);
    		if(favToIdx.containsKey(c1)&&!favToIdx.containsKey(c2)){
    			return -1;
    		}
    		else if(!favToIdx.containsKey(c1)&&favToIdx.containsKey(c2)){
    			return 1;
    		}
    		else if(favToIdx.containsKey(c1)&&favToIdx.containsKey(c2)){
    			if(favToIdx.get(c1) < favToIdx.get(c2)){
    				return -1;
    			}
    			else return 1;
    		}
    		p++;
    	}
    	return str1.compareTo(str2);
    }
    public static int partition(String[] input,String fav,int low,int high){
    	String pivot = input[high];
    	int i = low - 1;
    	for(int j=low;j<=high-1;j++){    		
    		if(stringCompare(input[j],pivot,fav) < 0){
    			i++;
    			String tmp = input[i];
    			input[i] = input[j];
    			input[j] = tmp;
    		}
    	}
    	String str = input[i+1];
    	input[i+1] = input[high];
    	input[high] = str;    	
    	return i+1;
    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
