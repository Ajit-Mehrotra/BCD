import java.lang.Math;

public class Driver {
	public static int factorial1(int num) {
		int factorial = 1;
		for(int i = 1; i <= num; i++) {
			factorial = factorial*i;
		}
		num = factorial;
		return num;
	}

	public static void main(String[] arg) {
		//System.out.println("BCD 3 is Correct: " + bcd3driver());
		System.out.println(bcd6());
		System.out.println(bcd61());
		//bcd5case(10,0);

	}

	public static boolean bcd3driver() {
		String expectedResult = "0";
		String expectedResult1 = "1,234";
		String expectedResult2 = "12,345";
		String expectedResult3 = "123,456,789";
		String expectedResult4 = "100,000,000";
		String expectedResult5 = "2,147,483,647";

		BCD myBCD = new BCD(0);
		BCD myBCD1= new BCD(1234);
		BCD myBCD2 = new BCD(12345);
		BCD myBCD3 = new BCD(123456789);
		BCD myBCD4 = new BCD(100000000);
		BCD myBCD5 = new BCD(2147483647);

		if (myBCD.toString().equals(expectedResult) 
				&& myBCD1.toString().equals(expectedResult1) &&
				myBCD2.toString().equals(expectedResult2) && 
				myBCD3.toString().equals(expectedResult3) && 
				myBCD4.toString().equals(expectedResult4) &&
				myBCD5.toString().equals(expectedResult5))
			return true;
		else
			return false;


	}

	public static boolean bcd5() {
		boolean cont = true;
		for(int i = 1; i < 3000 && cont; i++ ) {
			for(int j  = 0; j < 3000 && cont; j++) {
				cont = bcd5case(i,j);
			}
		}
		return cont;
	}


	private static boolean bcd5case(int num1, int num2) {
		BCD a5 = new BCD(num1);

		BCD b5 = new BCD(num2);

		BCD expected = new BCD(num1*num2);
		BCD ans = a5.multiplyBCDs(b5);

		System.out.println("EXPECTED: " + expected + "    ACTUAL: " + ans);

		if (ans.toString().equals("00")) {
			System.out.println("NUM1: " + num1 + "    NUM2: " + num2);
		}

		return expected.toString().equals(ans.toString());


	}
	private static boolean bcd6PowDriver(int num1, int num2) {
		BCD a5 = new BCD(num1);

		double i = Math.pow(num1,num2);
		int d = (int) i;
		BCD a6 = new BCD(d);
		return a5.pow(num2).toString().equals(a6.toString());

	}
	public static boolean bcd6() {
		boolean cont = true;
		for(int i = 1; i < 2 && cont; i++ ) {
			for(int j  = 0; j < 31 && cont; j++) {
				cont =  bcd6PowDriver(i,j);
			}
		}
		return cont;
	}
	private static boolean bcd6DFacriver(int num1) {		
		int i = factorial1(num1);
		BCD a6 = new BCD(i);
		return BCD.factorial(num1).toString().equals(a6.toString());

	}
	public static boolean bcd61() {
		boolean cont = true;
		for(int i = 1; i < 13  && cont; i++ ) {
			cont =  bcd6DFacriver(i);

		}
		return cont;
	}
}



