/*
 * 237. Delete Node in a Linked List
 * 
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Given linked list -- head = [4,5,1,9], which looks like following:
 * 
 * 	Example 1:
 * 		Input: head = [4,5,1,9], node = 5
 * 		Output: [4,1,9]
 * 	Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 * 
 * 	Example 2:
 * 		Input: head = [4,5,1,9], node = 1
 * 		Output: [4,5,9]
 * 	Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 * 
 * 	Note:
 * 		The linked list will have at least two elements.
 * 		All of the nodes' values will be unique.
 * 		The given node will not be the tail and it will always be a valid node of the linked list.
 * 		Do not return anything from your function.
 * 
 */
package Week1;

import java.util.*;

public class DeleteNodeInALinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	ListNode Root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		int n = scn.nextInt();
		StringTokenizer st = new StringTokenizer(s, "[\\[\\],]");
		DeleteNodeInALinkedList obj = new DeleteNodeInALinkedList();
		if (st.hasMoreTokens()) {
			obj.Root = obj.new ListNode(Integer.parseInt(st.nextToken()));
		}
		ListNode itr = obj.Root;
		ListNode nodeToBeDeleted = obj.Root;
		while (st.hasMoreTokens()) {
			itr.next = obj.new ListNode(Integer.parseInt(st.nextToken()));
			itr = itr.next;
			if (itr.val == n) {
				nodeToBeDeleted = itr;
			}
		}
		if (obj.Root != null && nodeToBeDeleted.next != null) {
			obj.deleteNode(nodeToBeDeleted);
		}
		obj.display(obj.Root);
		scn.close();
	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	public void display(ListNode node) {
		System.out.print("[");
		if (node == null) {
			System.out.print("]");
			return;
		}
		System.out.print(node.val);
		while (node.next != null) {
			System.out.print("," + node.next.val);
			node = node.next;
		}
		System.out.println("]");
	}

}
