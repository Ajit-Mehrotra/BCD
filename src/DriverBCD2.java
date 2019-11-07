
public class DriverBCD2 {
	public static void main(String[] args) {
		System.out.println("This is Test for an Array filled with one digit numbers");
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		for (int i = 0; i<=9; i++) {
			System.out.print(a[i] + ",");
		}
		BCD b = new BCD(a);
		System.out.println( b.numberOfDigits());
		System.out.println("Nth digit parameter equal to 0:");
		System.out.println(b.nthDigit(0) );
		System.out.println("Nth digit parameter equal to 7:");
		System.out.println(b.nthDigit(7));
		System.out.println("Nth digit parameter equal to 9:");
		System.out.println(b.nthDigit(9));
		System.out.println("Nth digit parameter equal to 45:");
		System.out.println(b.nthDigit(45));
		System.out.println("Adding 9 to digit and printing"
				+ " out the last digit of digit array(should be equal to 9):");
		b.addADigit(9);
		System.out.println(b.nthDigit(b.numberOfDigits()-1));
		System.out.println("\n");

		System.out.println("This is Test for an Array filled with nothing");
		int[] c = {};
		BCD d = new BCD(c);
		System.out.println( d.numberOfDigits());
		System.out.println("Nth digit parameter equal to 0:");
		System.out.println(d.nthDigit(0) );
		System.out.println("Nth digit parameter equal to 7:");
		System.out.println(d.nthDigit(7));
		System.out.println("Nth digit parameter equal to 9:");
		System.out.println(d.nthDigit(9));
		System.out.println("Nth digit parameter equal to 45:");
		System.out.println(d.nthDigit(45));
		System.out.println("Adding 9 to digit and printing"
				+ " out the last digit of digit array(should be equal to 9):");
		d.addADigit(9);
		System.out.println(d.nthDigit(d.numberOfDigits()-1));
		System.out.println("\n");

		System.out.println("This is Test for an Array filled with two digit numbers");
		int[] e = {12,22,32,42,52,62,72,82,92,10,77};
		for (int i = 0; i<=9; i++) {
			System.out.print(e[i] + ",");
		}		
		BCD f = new BCD(e);
		System.out.println( f.numberOfDigits());
		System.out.println("Nth digit parameter equal to 0:");
		System.out.println(f.nthDigit(0) );
		System.out.println("Nth digit parameter equal to 7:");
		System.out.println(f.nthDigit(7));
		System.out.println("Nth digit parameter equal to 9:");
		System.out.println(f.nthDigit(9));
		System.out.println("Nth digit parameter equal to 45:");
		System.out.println(f.nthDigit(45));
		System.out.println("Adding 9 to digit and printing"
				+ " out the last digit of digit array(should be equal to 9):");		
		f.addADigit(9);
		System.out.println(f.nthDigit(f.numberOfDigits()-1));
		System.out.println("\n");

		System.out.println("This is Test for an Array filled with three digit numbers");
		int[] g = {123,223,323,423,523,623,723,823,923,103,773};
		for (int i = 0; i<=9; i++) {
			System.out.print(g[i] + ",");
		}
		BCD h = new BCD(g);
		System.out.println( h.numberOfDigits());
		System.out.println("Nth digit parameter equal to 0:");
		System.out.println(h.nthDigit(0) );
		System.out.println("Nth digit parameter equal to 7:");
		System.out.println(h.nthDigit(7));
		System.out.println("Nth digit parameter equal to 9:");
		System.out.println(h.nthDigit(9));
		System.out.println("Nth digit parameter equal to 45:");
		System.out.println(h.nthDigit(45));
		System.out.println("Adding 9 to digit and printing"
				+ " out the last digit of digit array(should be equal to 9):");
		h.addADigit(9);
		System.out.println(h.nthDigit(h.numberOfDigits()-1));
		System.out.println("\n");

	}

}
