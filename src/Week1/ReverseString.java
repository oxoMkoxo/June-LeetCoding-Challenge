/*
 * 344. Reverse String
 * 
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 * 
 * 	Example 1:
 * 		Input: ["h","e","l","l","o"]
 * 		Output: ["o","l","l","e","h"]
 * 
 * 	Example 2:
 * 		Input: ["H","a","n","n","a","h"]
 * 		Output: ["h","a","n","n","a","H"]
 */
package Week1;

import java.util.*;

public class ReverseString {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		StringTokenizer st = new StringTokenizer(s, "[\\[\\],\"]");
		if (st.countTokens() == 0) {
			scn.close();
			throw new Exception("\"\" is not a valid value of type character\r");
		}
		char[] arr = new char[st.countTokens()];
		int i = 0;
		while (st.hasMoreTokens()) {
			arr[i] = st.nextToken().charAt(0);
			i++;
		}
		reverseString(arr);
		System.out.print("[\"" + arr[0] + "\"");
		for (int j = 1; j < arr.length; j++) {
			System.out.print("," + "\"" + arr[j] + "\"");
		}
		System.out.print("]");
		scn.close();

	}

	public static void reverseString(char[] s) {
		for (int i = 0; i < s.length / 2; i++) {
			s[i] = (char) (s[s.length - i - 1] + s[i]);
			s[s.length - i - 1] = (char) (s[i] - s[s.length - i - 1]);
			s[i] = (char) (s[i] - s[s.length - i - 1]);
		}
	}

}
