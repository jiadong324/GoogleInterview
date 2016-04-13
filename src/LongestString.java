
/**
 * Given a matrix contains characters, returns the longest consecutive character sequence. 
 * @author jiadong
 *
 */
public class LongestString {
	
	public static int returnLongest(char[][] matrix){
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] dp = new int[rows][cols];
		int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};		
		int ans = 0;
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){		
				ans = Math.max(ans,findLongest(matrix,i,j,dp,directions));
			}
		}
		return ans;
	}
	public static int findLongest(char[][] matrix, int x, int y, int[][] dp, int[][] directions){	
		if(x < 0|| y < 0 || x > matrix.length || y > matrix[0].length){
			return 0;
		}
		if(dp[x][y]!=0){
			return dp[x][y];
		}
		int max = 1;
		for(int i=0;i<4;i++){
			int curRow = x + directions[i][0];
			int curCol = y + directions[i][1];
			if(curRow>=0&&curRow<matrix.length&&curCol>=0&&curCol<matrix[0].length&&matrix[curRow][curCol] - matrix[x][y] == 1){
				// have not visited [curRow,curCol]
				if(dp[curRow][curCol] == 0){
					findLongest(matrix,curRow,curCol,dp,directions);
				}
				max = Math.max(1+dp[curRow][curCol],max);
			}
		}
		return dp[x][y]=max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix= {{'k','b','g'},{'h','c','d'},{'l','a','i'}};
		System.out.print(returnLongest(matrix));
		
	}

}
