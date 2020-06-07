/*
 * 518. Coin Change 2
 * 
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number 
 * of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 * 
 * 	Example 1:
 * 		Input: amount = 5, coins = [1, 2, 5]
 * 		Output: 4
 * 	Explanation: there are four ways to make up the amount:
 * 		5=5
 * 		5=2+2+1
 * 		5=2+1+1+1
 * 		5=1+1+1+1+1
 * 
 * 	Example 2:
 * 		Input: amount = 3, coins = [2]
 * 		Output: 0
 * 	Explanation: the amount of 3 cannot be made up just with coins of 2.
 * 
 * 	Example 3:
 *		Input: amount = 10, coins = [10] 
 *		Output: 1
 *
 *	Note:
 *		You can assume that
 *		0 <= amount <= 5000
 *		1 <= coin <= 5000
 *		the number of coins is less than 500
 *		the answer is guaranteed to fit into signed 32-bit integer
 */

package Week1;

import java.util.*;

public class CoinChange2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int amount = scn.nextInt();
		String s = scn.next();
		StringTokenizer st = new StringTokenizer(s, "[\\[\\],]");
		int[] coins = new int[st.countTokens()];
		int i = 0;
		while (st.hasMoreTokens()) {
			coins[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		CoinChange2 obj = new CoinChange2();
		System.out.println(obj.change(amount, coins));
		scn.close();

	}

	public int change(int amount, int[] coins) {
		if (coins.length == 0) {
			if (amount == 0) {
				return 1;
			} else {
				return 0;
			}
		}

		int[][] strg = new int[amount + 1][coins.length];
		for (int[] a : strg) {
			Arrays.fill(a, -1);
		}
		return recur(amount, coins, 0, strg);
	}

	public int recur(int amount, int[] coins, int indx, int[][] strg) {
		if (amount == 0) {
			return 1;
		}
		if (amount < 0) {
			return 0;
		}
		if (strg[amount][indx] != -1) {
			return strg[amount][indx];
		}
		int ans = 0;
		for (int i = indx; i < coins.length; i++) {
			ans += recur(amount - coins[i], coins, i, strg);
		}
		strg[amount][indx] = ans;
		return ans;
	}
}
