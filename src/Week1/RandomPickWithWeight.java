/*
 * 528. Random Pick with Weight
 * 
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly 
 * picks an index in proportion to its weight.
 * 
 * 	Note:
 * 		1 <= w.length <= 10000
 * 		1 <= w[i] <= 10^5
 * 		pickIndex will be called at most 10000 times.
 * 
 * 	Example 1:
 * 		Input: 
 * 			["Solution","pickIndex"]
 * 			[[[1]],[]]
 * 		Output: [null,0]
 * 
 * 	Example 2:
 * 		Input: 
 * 			["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * 			[[[1,3]],[],[],[],[],[]]
 * 			Output: [null,0,1,1,1,0]
 * 
 * 	Explanation of Input Syntax:
 * 		The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, 
 * 		the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
package Week1;

import java.util.*;

public class RandomPickWithWeight {
	int[] wArr = null;
	Random randNum = null;

	public RandomPickWithWeight(int[] w) {
		for (int i = 1; i < w.length; i++) {
			w[i] = w[i] + w[i - 1];
		}
		this.wArr = w;
		this.randNum = new Random();
	}

	public int pickIndex() {
		int lo = 0;
		int hi = wArr.length - 1;
		int num = randNum.nextInt(wArr[hi]);
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (wArr[mid] <= num) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		String p = scn.nextLine();
		StringTokenizer st = new StringTokenizer(s, "[\\[\\],\"]");
		StringTokenizer st2 = new StringTokenizer(p, "[\\[\\],]");
		int[] w = new int[st2.countTokens()];
		for (int i = 0; i < w.length; i++) {
			w[i] = Integer.parseInt(st2.nextToken());
		}
		RandomPickWithWeight obj = new RandomPickWithWeight(w);
		while (st.hasMoreTokens()) {
			String op = st.nextToken();
			switch (op) {
			case "Solution":
				System.out.print("[null");
				break;
			case "pickIndex":
				System.out.print("," + obj.pickIndex());
				break;
			default:
				break;
			}
		}
		System.out.print("]");
		scn.close();

	}

}
