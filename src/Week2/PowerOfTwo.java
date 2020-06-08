/*
 * 231. Power of Two
 * 
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * 	Example 1:
 * 		Input: 1
 * 		Output: true 
 * 	Explanation: 20 = 1
 * 
 * 	Example 2:
 * 		Input: 16
 * 		Output: true
 * 	Explanation: 24 = 16
 * 
 * 	Example 3:
 * 		Input: 218
 * 		Output: false
 */
package Week2;

import java.util.*;

public class PowerOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(isPowerOfTwo(n));
		scn.close();
	}

	public static boolean isPowerOfTwo(int n) {
		int count = 0;
		while (n != 0) {
			count += n & 1;
			n = n >> 1;
			if (count > 1) {
				return false;
			}
		}
		return (count == 1) ? true : false;
	}

}
