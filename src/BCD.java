
public class BCD {
	private int[] digits;

	BCD(int[] bcdDigits){
		digits = new int[bcdDigits.length];
		for (int counter = 0; counter < bcdDigits.length; counter++ ) {
			digits[counter] = bcdDigits[counter];
		}
	}

	BCD(int num){
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
	public BCD addBCDs(BCD other){
		int[] newArray;
		int thisBcdLeng = this.digits.length;
		int otherBcdLeng = other.digits.length;
		int elementAdded;
		int carryOverNumber = 0;
		int mod;

		if((thisBcdLeng>=otherBcdLeng)){
			newArray = new int[thisBcdLeng];
			for(int i =0; i < thisBcdLeng; i++) {
				elementAdded = this.nthDigit(i) + other.nthDigit(i);
				elementAdded += carryOverNumber;
				mod = elementAdded%10;
				newArray[i] = mod;
				carryOverNumber = elementAdded/10;

				/*if (carryOverNumber != 0) {// this maybe the reason
						elementAdded = this.nthDigit(i); //Other Digit is 0
						elementAdded += carryOverNumber;
						mod = elementAdded%10;
						newArray[i] = mod;
						carryOverNumber = elementAdded/10;
					} else {
						newArray[i] = this.nthDigit(i);
					}*/
			}
		} else {
			//thisBCDLeng < otherBcdLeng
			newArray = new int[otherBcdLeng];
			for(int i =0; i < otherBcdLeng; i++) {
				elementAdded = this.nthDigit(i) + other.nthDigit(i);
				elementAdded += carryOverNumber;
				mod = elementAdded%10;
				newArray[i] = mod;
				carryOverNumber = elementAdded/10;
				/*if (carryOverNumber != 0) {
						elementAdded = other.nthDigit(i); //This Digit is 0
						elementAdded += carryOverNumber;
						mod = elementAdded%10;
						newArray[i] = mod;
						carryOverNumber = elementAdded/10;
					} else {
						newArray[i] = other.nthDigit(i);
					}*/
			}
		}


		BCD resultBCD = new BCD(newArray);
		if (carryOverNumber != 0) {
			resultBCD.addADigit(carryOverNumber); //Add a '1' to the BCD
		}
		return resultBCD;
	}


	public BCD multiplyBCDs(BCD other){
		if ((this.numberOfDigits() == 1 && this.nthDigit(0) == 0) ||
				(other.numberOfDigits() == 1 && other.nthDigit(0) == 0)) {
			//If either are 0, return 0
			return new BCD(0);
		}

		int[][] A;
		int thisBcdLeng = this.digits.length;
		int otherBcdLeng = other.digits.length;
		int elementMultiplied;
		int x = 0;
		int y = 0;
		BCD xBCD = null;
		BCD yBCD = null;
		if( thisBcdLeng >= otherBcdLeng) {
			x = thisBcdLeng;
			y = otherBcdLeng;
			xBCD = this;
			yBCD = other;
		}else {
			x = otherBcdLeng;
			y = thisBcdLeng;
			xBCD = other;
			yBCD = this;
		}
		A = new int[x][y];
		//System.out.println("initX: " + x + "    initY: " + y);

		for(int l = 0; l< x;l++){
			for( int u = 0; u < y; u++ ){
				elementMultiplied = xBCD.nthDigit(l) * yBCD.nthDigit(u);
				A[l][u] = elementMultiplied;
				//System.out.println("X: " + l + "    Y: " + u + "    Res: " + elementMultiplied);
				//System.out.println( xBCD.nthDigit(l) + "*" + yBCD.nthDigit(u) + "=" + newArray[l][u]);
			}

		}

		int [] arrayDiagSum = addDiagonals(A);
		int remaining = 0;
		int ones = 0;
		int [] newBCD = new int [arrayDiagSum.length +1];
		int[] initArray = new int[0];
		BCD answerBCD = new BCD(initArray);
		int sum = 0;
		for (int revCounter = 0; revCounter < arrayDiagSum.length; revCounter ++) {
			sum = arrayDiagSum[revCounter];
			sum += remaining;
			ones = sum % 10;
			remaining = sum / 10;
			//System.out.println(ones);
			answerBCD.addADigit(ones);
		}

		while (remaining > 0) {
			ones = remaining % 10;
			remaining /= 10;
			answerBCD.addADigit(ones);
		}

		return answerBCD;

	}
	private int diagonalSum(int[][] lattice,int column, int row) {
		int total = 0;
		int j = column;
		int i =row;
		while(  i>=0 && j<=lattice[0].length -1) {
			total += lattice[i][j];
			i--;
			j++;
			//System.out.println("COL: " + column + "    ROW: " + row + "    I: " + i + "    J: " + j + "    TOTAL: " + total);
		}
		/*for( j = 1, i = row ; j<column; i--, j++) {
			total += lattice[i][j];
			//System.out.println("COL: " + column + "    ROW: " + row + "    I: " + i + "    J: " + j + "    TOTAL: " + total);
		}*/
		return total;
	}

	private int [] addDiagonals(int[][] lattice) {
		int height =lattice.length;
		int width = lattice[0].length;
		int diagonals = width + height-1;
		int[] result = new int[diagonals]; 
		int diag = diagonals - 1;
		//Add the diagonals that end at the bottom 
		for(int col=width-1; col>=0; col--) {
			result[diag] = diagonalSum(lattice,col,height-1);
			//System.out.println("Width result Diag: " + result[diag]);
			diag--;
		}
		//Add the diagonals that end at the left side
		for(int row  = height -2; row >= 0; row--) {
			result[diag] = diagonalSum(lattice,0,row);
			diag--;
		}
		for(int i = 0; i < result.length;i++) {
			//System.out.println(result[i]);
		}

		return result;
	}




	public static BCD factorial (int num) {
		BCD fac;
		BCD fac1;
		if (num==0) {
			fac1 = new BCD(1);
			return fac1;
		}

		fac = new BCD(1);
		for(int i = 1; i<=num; i++) {
			fac1 = new BCD(i);
			fac = fac.multiplyBCDs(fac1);
		}

		return fac;
	}

	public BCD pow (int num) {
		BCD base1 = this;
		BCD power0 = new BCD(1);
		if (num ==1)
			return this;
		else if (num==0)
			return power0;
		else 
			for(int i = 1; i <= num; i++)
				base1 = base1.multiplyBCDs(this);

		return base1;
	}


	public static void main(String[] args){
		BCD bcd1 = new BCD(2);
		BCD bcd2 = new BCD(12345);
		bcd1.multiplyBCDs(bcd2);

		System.out.println(bcd1.pow(127));

	}


}
