public class Zadanie3 {
	static<E extends Comparable> int countInRange(E[] arr, E begin, E end) {
		RangePredicate<E> predicate = new RangePredicate<E>(begin, end);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if(predicate.test(arr[i])) {
				sum++;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[]{43, 20, 12, 1, 8, 9};
		System.out.println(countInRange(arr, 5, 17));
	}
}
