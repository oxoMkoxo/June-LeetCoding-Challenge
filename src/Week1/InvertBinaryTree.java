/*
 * 226. Invert Binary Tree
 * 
 * Invert a binary tree.
 * 
 * 	Example:
 * 
 * 		Input:
 * 		     4
 * 		   /   \
 * 		  2     7
 * 		 / \   / \
 * 		1   3 6   9
 * 
 * 		Output:
 * 		     4
 * 		   /   \
 * 		  7     2
 * 		 / \   / \
 * 		9   6 3   1
 * 
 */

package Week1;

import java.util.*;

public class InvertBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	TreeNode root;

	public void Construct(StringTokenizer st) {
		if (!st.hasMoreTokens()) {
			this.root = null;
			return;
		}
		root = new TreeNode(Integer.parseInt(st.nextToken()), null, null);
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode remNode = queue.pollFirst();
			String stToken = null;
			if (st.hasMoreTokens()) {
				stToken = st.nextToken();
				if (!stToken.equals("null")) {
					remNode.left = new TreeNode(Integer.parseInt(stToken), null, null);
					queue.add(remNode.left);
				}
			} else {
				return;
			}
			if (st.hasMoreTokens()) {
				stToken = st.nextToken();
				if (!stToken.equals("null")) {
					remNode.right = new TreeNode(Integer.parseInt(stToken), null, null);
					queue.add(remNode.right);
				}
			} else {
				return;
			}
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return root;
		}
		TreeNode left = null;
		TreeNode right = null;

		if (root.left != null) {
			left = invertTree(root.left);
		}
		if (root.right != null) {
			right = invertTree(root.right);
		}
		root.left = right;
		root.right = left;
		return root;

	}

	public void display(TreeNode root) {
		System.out.print("[");
		LinkedList<TreeNode> queue = new LinkedList<>();
		if (root == null) {
			System.out.print("]");
			return;
		}
		System.out.print(root.val);
		if (root.left != null) {
			queue.add(root.left);
		}
		if (root.right != null) {
			queue.add(root.right);
		}
		while (!queue.isEmpty()) {
			TreeNode remNode = queue.pollFirst();
			System.out.print("," + remNode.val);
			if (remNode.left != null) {
				queue.add(remNode.left);
			}
			if (remNode.right != null) {
				queue.add(remNode.right);
			}
		}
		System.out.print("]");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String tree = scn.next();
		StringTokenizer st = new StringTokenizer(tree, "[\\[\\],]");
		InvertBinaryTree obj = new InvertBinaryTree();
		obj.Construct(st);
		obj.invertTree(obj.root);
		obj.display(obj.root);
		scn.close();
	}

}
