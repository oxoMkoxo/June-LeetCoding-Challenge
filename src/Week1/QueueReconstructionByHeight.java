/*
 * 406. Queue Reconstruction by Height
 * 
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), 
 * where h is the height of the person and k is the number of people in front of this person who have a height greater than 
 * or equal to h. Write an algorithm to reconstruct the queue.
 * 
 *	Note:
 *		The number of people is less than 1,100.
 *
 *	Example
 *		Input:
 *			[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *		Output:
 *			[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */


package Week1;

import java.util.*;

public class QueueReconstructionByHeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		StringTokenizer st = new StringTokenizer(s, "[\\[\\] ,]");
		int[][] people = new int[st.countTokens() / 2][2];
		for (int i = 0; i < people.length; i++) {
			people[i][0] = Integer.parseInt(st.nextToken());
			people[i][1] = Integer.parseInt(st.nextToken());
		}
		people = reconstructQueue(people);
		System.out.print("[");
		for (int i = 0; i < people.length; i++) {
			System.out.print("[" + people[i][0] + "," + people[i][1] + "]");
			if (i < people.length - 1) {
				System.out.print(",");
			}
		}
		System.out.print("]");
		scn.close();
	}

	public static int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] A, int[] B) {
				if (A[0] == B[0]) {
					return A[1] - B[1];
				} else {
					return B[0] - A[0];
				}
			}
		});
		List<int[]> list = new ArrayList<>();
		for (int[] p : people) {
			list.add(p[1], p);
		}
		return list.toArray(new int[list.size()][]);
	}

}
