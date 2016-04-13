import java.util.*;

/**
 * Find the Kth largest element in BST
 * @author jiadong
 *
 */
public class BSTKthLargest {
	
	public static class TNode{
		int val;
		TNode left;
		TNode right;
		public TNode(int x){
			val = x;
			left = null;
			right = null;
		}
	}
	
	public static int find(TNode root, int k){
		Stack<TNode> sta = new Stack<>();
		while(!sta.isEmpty()||root!=null){
			while(root!=null){
				sta.push(root);
				root = root.right;
			}
			root = sta.pop();
//			System.out.print(root.val);
			if(k-- == 0){
				return root.val;
			}
			root = root.left;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TNode a = new TNode(5);
		TNode b = new TNode(3);
		TNode c = new TNode(8);
		TNode d = new TNode(6);
		a.right = b;a.left = c;c.right=d;
		System.out.print(find(a,2));
	}

}
