/*
 * 1029. Two City Scheduling
 * 
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], 
 * and the cost of flying the i-th person to city B is costs[i][1].
 * 
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 * 
 * 	Example 1:
 * 		Input: [[10,20],[30,200],[400,50],[30,20]]
 * 		Output: 110
 * 	Explanation: 
 * 		The first person goes to city A for a cost of 10.
 * 		The second person goes to city A for a cost of 30.
 * 		The third person goes to city B for a cost of 50.
 * 		The fourth person goes to city B for a cost of 20.
 * 		The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 * 
 * 	Note:
 * 		1 <= costs.length <= 100
 * 		It is guaranteed that costs.length is even.
 * 		1 <= costs[i][0], costs[i][1] <= 1000
 * 
 */
package Week1;

import java.util.*;

public class TwoCityScheduling {
	class Pair implements Comparable<Pair> {
		Integer A = 0;
		Integer B = 0;

		Pair(int val1, int val2) {
			A = val1;
			B = val2;
		}

		public int compareTo(Pair p) {
			return ((Integer) (this.A - this.B)).compareTo((Integer) (p.A - p.B));
		}
	}

	public int twoCitySchedCost(int[][] costs) {
		PriorityQueue<Pair> heap = new PriorityQueue<>();
		for (int i = 0; i < costs.length; i++) {
			heap.add(new Pair(costs[i][0], costs[i][1]));
		}
		int sum = 0;
		for (int i = 1; i <= costs.length / 2; i++) {
			sum += heap.remove().A;
		}
		while (!heap.isEmpty()) {
			sum += heap.remove().B;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		StringTokenizer st = new StringTokenizer(s, "[\\[\\],]");
		int[][] costs = new int[st.countTokens() / 2][2];
		int i = 0;
		while (st.hasMoreTokens()) {
			int[] arr = new int[2];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			costs[i] = arr;
			i++;
		}
		TwoCityScheduling obj = new TwoCityScheduling();
		System.out.println(obj.twoCitySchedCost(costs));
		scn.close();
	}

}
