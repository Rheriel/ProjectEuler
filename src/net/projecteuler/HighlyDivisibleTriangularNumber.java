package net.projecteuler;

import java.awt.font.NumericShaper;

public class HighlyDivisibleTriangularNumber {
	
	static long divisors = 0;
	
	public static void main(String[] args) {
		System.out.println(new HighlyDivisibleTriangularNumber().triangularNumbers(10));
		System.out.println(new HighlyDivisibleTriangularNumber().numberOfDivisors(10));
		
		long counter = 1;
		long highestDivisors = 1;
		
		while (divisors <= 500 ){
			divisors = (long) 0;
			long triangularNumber = triangularNumbers(counter);
			if ((long) Math.sqrt(triangularNumber) >= 500) {
				numberOfDivisors(triangularNumber);
				System.out.println("" + counter + "th Triangular: " + triangularNumber + " has: " + divisors + " divisors.");
			}
			counter= counter + 1;
		}
		
		System.out.println("" + counter + "th Triangular number: " + triangularNumbers(counter) + " has: " + divisors + " divisors.");
		System.out.println("so...");
		
	}
	
	public static long triangularNumbers(long n){
		if(n==0){
			return 0;
		} else {
			return (n * n + n) / 2;
		}
	}
	
	public static long numberOfDivisors(long n){
		for (long i = 1; i<(long) Math.sqrt(n); i++){
			if (n%i==0)
				divisors+=2;
		}
		
		return divisors;
	}
	
	public static long numberOfDivisors2(long n){
		for (long i = 0; i>Math.sqrt(n); i++){
			if (n%i==0) 
				divisors+=2;			
		}
		
		return divisors;
	}

}
