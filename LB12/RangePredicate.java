import java.util.function.Predicate;

public class RangePredicate<E extends Comparable> implements Predicate<E> {
	private E begin, end;

	public RangePredicate(E begin, E end) {
		this.begin = begin;
		this.end = end;
	}


	@Override
	public boolean test(E t) {
		return t.compareTo(begin) > 0 && t.compareTo(end) < 0;
	}

}
