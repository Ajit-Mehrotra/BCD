
public class FactorialCalculator {
	public static int factorial(int num) {
		int factorial = 1;
		for(int i = 1; i <= num; i++) {
			factorial = factorial*i;
		}
		num = factorial;
		return num;
	}
	public static void driverFactCalc() {
		for (int i = 1; i <= 20; i++){
			System.out.println(i + "\t"  + factorial(i));
		}
		
	}
	public static void main(String[] args){
		driverFactCalc();
	}
}
