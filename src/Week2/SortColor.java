/*
 * 75. Sort Colors
 * 
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are 
 * adjacent, with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this problem.
 * 
 * 	Example:
 * 		Input: [2,0,2,1,1,0]
 * 		Output: [0,0,1,1,2,2]
 * 
 * 	Follow up:
 * 	A rather straight forward solution is a two-pass algorithm using counting sort.
 * 	First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's 
 * 	and followed by 2's.
 * 	Could you come up with a one-pass algorithm using only constant space?
 */
package Week2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SortColor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		StringTokenizer st = new StringTokenizer(s, "[\\[\\],]");
		int[] nums = new int[st.countTokens()];
		int i = 0;
		while (st.hasMoreTokens()) {
			nums[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		SortColor obj = new SortColor();
		obj.sortColors(nums);
		System.out.print("[" + nums[0]);
		for (i = 1; i < nums.length; i++) {
			System.out.print("," + nums[i]);
		}
		System.out.print("]");
		scn.close();
	}

	public void sortColors(int[] nums) {
		int lo = 0;
		int hi = nums.length - 1;
		int itr = hi;
		while (lo <= hi) {
			int val = nums[hi];
			if (val == 0) {
				swap(lo, hi, nums);
				lo++;
			} else if (val == 2) {
				swap(itr, hi, nums);
				itr--;
				hi--;
			} else {
				hi--;
			}
		}
	}

	public void swap(int lo, int hi, int[] nums) {
		int temp = nums[lo];
		nums[lo] = nums[hi];
		nums[hi] = temp;
	}

}
