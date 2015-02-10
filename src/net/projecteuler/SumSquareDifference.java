package net.projecteuler;

public class SumSquareDifference {

	
	public static void main(String[] args) {
		System.out.println(sumOfSquare(100));
		System.out.println(squareOfSum(100));
		System.out.println(differenceBetweenSquareAndSum(squareOfSum(100), sumOfSquare(100)));

	}
	
	private static long sumOfSquare(int limit){
		int sum = 0;
		
		for(int i = 1; i<=limit; i++){
			sum += Math.pow(i, 2);
		}
		
		return sum;
	}
	
	private static long squareOfSum(int limit){
		
		int sum = 0;
		
		for(int i = 1; i<=limit; i++){
			sum += i;
		}
		
		return (long)Math.pow(sum,2);
		
	}
	
	private static long differenceBetweenSquareAndSum(long square, long sum){
		return square - sum;
	}

}
