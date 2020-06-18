package Week3;

public class HIndexII {
	public int hIndex(int[] citations) {
		int lo = 0;
		int hi = citations.length - 1;
		int len = citations.length;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (citations[mid] == len - mid) {
				return len - mid;
			} else if (citations[mid] > len - mid) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return len - lo;
	}
}
