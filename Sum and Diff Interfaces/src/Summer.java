
public class Summer implements SumInterface, DiffInterface{

	@Override
	public int sum(int i, int j) {
		return i + j;
	}

	@Override
	public long sum(long l, long m) {
		return l + m;
	}

	@Override
	public double sum(double d, double e) {
		return d + e;
	}

	@Override
	public int diff(int i, int j) {
		return i - j;
	}

	@Override
	public long diff(long l, long m) {
		return l - m;
	}

	@Override
	public double diff(double d, double e) {
		return d - e;
	}



}
