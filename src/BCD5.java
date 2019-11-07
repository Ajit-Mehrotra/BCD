
public class BCD5 {
	private int[] digits;

	BCD5(int[] bcdDigits){
		digits = new int[bcdDigits.length];
		for (int counter = 0; counter < bcdDigits.length; counter++ ) {
			digits[counter] = bcdDigits[counter];
		}
	}

	BCD5(int num){
		int digit = num % 10;
		num /= 10;
		digits = new int[1];
		digits[0] = digit;
		while(num > 0) {
			digit = num % 10;
			addADigit(digit);
			num /= 10;
		}


	}

	public int numberOfDigits() {
		return digits.length;
	}

	public int nthDigit(int n) {

		if (n>=digits.length|| n < 0) {
			return 0;
		}
		else {
			return digits[n];
		}
	}

	public void addADigit(int newDigit) {
		int[] newDigits = new int[digits.length +1];
		for (int counter = 0; counter < digits.length; counter ++) {
			newDigits[counter ] = digits[counter]; 
		}
		newDigits[newDigits.length -1] = newDigit;
		digits = newDigits;
	}

	public String toString(){
		String newStringarray = "" ;

		for (int i = digits.length-1; i >= 0; i--){
			newStringarray += digits[i];
			if (i != 0 && i%3 == 0 ) {
				newStringarray += ",";
			}
		}

		return newStringarray;

	}
	public BCD5 multiplyBCDs(BCD5 other){
		int[][] newArray ;
		int thisBcdLeng = this.digits.length;
		int otherBcdLeng = other.digits.length;
		int elementMultiplied;
		

		
		/*if((thisBcdLeng>=otherBcdLeng)){
				newArray = new int[thisBcdLeng][otherBcdLeng];
				
				for(int i =0; i < thisBcdLeng; i++) {
					if(i<= otherBcdLeng) {
						for(int j = 0; j< thisBcdLeng; j++)
						elementMultiplied = this.nthDigit(i) * other.nthDigit(i);
						newArray[i][i] = elementMultiplied;
						System.out.println(newArray[i][i]);
						//k++;
					}
					//l = i-k;
					if(i> otherBcdLeng) {
						elementMultiplied = this.nthDigit(i) * other.nthDigit(otherBcdLeng-1);
						newArray[i][otherBcdLeng-1] = elementMultiplied;
						System.out.println(newArray[i][otherBcdLeng-1]);
					}
				}
			} else {
				newArray = new int[thisBcdLeng][otherBcdLeng];
				for(int i =0; i < otherBcdLeng; i++) {
					if(i< thisBcdLeng) {
						elementMultiplied = this.nthDigit(i) * other.nthDigit(i);
						newArray[i][i] = elementMultiplied;
						System.out.println(newArray[i][i]);
						//k++;
					}
					//l = i-k;
					if(i>= thisBcdLeng) {
						elementMultiplied = this.nthDigit(thisBcdLeng-1) * other.nthDigit(i);
						newArray[thisBcdLeng-1][i] = elementMultiplied;
						System.out.println(newArray[thisBcdLeng-1][i]);
					}
				}
			}*/
			return null;
			
	}

	public static void main(String[] args){
		BCD5 bcd1 = new BCD5(12345);
		BCD5 bcd2 = new BCD5(1234);
		bcd1.multiplyBCDs(bcd2);
	}







	


}
