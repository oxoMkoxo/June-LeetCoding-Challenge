/*
 * 380. Insert Delete GetRandom O(1) 
 * 
 * Design a data structure that supports all following operations in average O(1) time.
 * 
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * 
 * 	Example:
 * 
 * 		// Init an empty set.
 * 		RandomizedSet randomSet = new RandomizedSet();
 * 
 * 		// Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * 		randomSet.insert(1);
 * 
 * 		// Returns false as 2 does not exist in the set.
 * 		randomSet.remove(2);
 * 
 * 		// Inserts 2 to the set, returns true. Set now contains [1,2].
 * 		randomSet.insert(2);
 * 
 * 		// getRandom should return either 1 or 2 randomly.
 * 		randomSet.getRandom();
 * 
 * 		// Removes 1 from the set, returns true. Set now contains [2].
 * 		randomSet.remove(1);
 * 
 * 		// 2 was already in the set, so return false.
 * 		randomSet.insert(2);
 * 
 * 		// Since 2 is the only number in the set, getRandom always return 2.
 * 		randomSet.getRandom();
 */
package Week2;

import java.util.*;

public class InsertDeleteGetRandom {

	class RandomizedSet {
		ArrayList<Integer> array;
		HashMap<Integer, Integer> map;
		Random rndm;

		/** Initialize your data structure here. */
		public RandomizedSet() {
			array = new ArrayList<>();
			map = new HashMap<>();
			rndm = new Random();
		}

		/**
		 * Inserts a value to the set. Returns true if the set did not already contain
		 * the specified element.
		 */
		public boolean insert(int val) {
			if (map.containsKey(val)) {
				return false;
			} else {
				array.add(val);
				map.put(val, array.size() - 1);
				return true;
			}
		}

		/**
		 * Removes a value from the set. Returns true if the set contained the specified
		 * element.
		 */
		public boolean remove(int val) {
			if (map.containsKey(val)) {
				int lastIndx = array.size() - 1;
				int indx = map.get(val);
				if (indx == lastIndx) {
					array.remove(indx);
					map.remove(val);
					return true;
				}
				array.set(indx, array.get(lastIndx));
				array.remove(lastIndx);
				map.put(array.get(indx), indx);
				map.remove(val);
				return true;
			} else {
				return false;
			}
		}

		/** Get a random element from the set. */
		public int getRandom() {
			int temp = rndm.nextInt(array.size());
			return array.get(temp);
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		String t = scn.nextLine();
		StringTokenizer st1 = new StringTokenizer(s, "[\\[\\],\"]");
		StringTokenizer st2 = new StringTokenizer(t, "[\\[\\],]");
		InsertDeleteGetRandom ds = new InsertDeleteGetRandom();
		RandomizedSet obj = null;
		System.out.print("[");
		while (st1.hasMoreTokens()) {
			switch (st1.nextToken()) {
			case "RandomizedSet":
				obj = ds.new RandomizedSet();
				System.out.print("null");
				break;
			case "insert":
				System.out.print("," + obj.insert(Integer.parseInt(st2.nextToken())));
				break;
			case "remove":
				System.out.print("," + obj.remove(Integer.parseInt(st2.nextToken())));
				break;
			case "getRandom":
				System.out.print("," + obj.getRandom());
				break;
			default:
				break;
			}
		}
		System.out.print("]");
		scn.close();
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */
