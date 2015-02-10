package net.projecteuler;

public class SpecialPitagoreanTriplet {

	public static void main(String[] args) {

		end:
		for(long c = 0; c < 1000; c++){
			for(long b = 0; b < c; b++){
				for(long a = 0; a < b; a++){
					if (isPitagorean(a, b, c)) {
						if ((a + b + c) == 1000) {
							System.out.println("A: " + a + " B: " + b + " C: " + c);
							System.out.println("Product of ABC: " + (a * b * c));
							break end;
						}
					}
					
				}
			}
				
		}
		
	}
	
	public static boolean isPitagorean(long a, long b, long c) {
		if (Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2))
			return true;
		else
			return false;
	}

	public static long pitagoreanA(long c, long b){
		long aSquare = (long) (Math.pow(c,2) - Math.pow(b,2));
		return aSquare;
	}

	public static long pitagoreanB(long c, long a){
		long bSquare = (long) (Math.pow(c,2) - Math.pow(a,2));
		return bSquare;
	}

	public static long pitagoreanC(long a, long b){
		long cSquare = (long) (Math.pow(a,2) + Math.pow(b,2));
		return cSquare;
	}

}
