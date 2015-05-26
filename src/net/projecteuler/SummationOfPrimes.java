package net.projecteuler;

public class SummationOfPrimes {
	
	static int exampleLimit = 10;
	static int problemLimit = 2000000;
	
	public static void main(String[] args) {
		
		long sumOfPrimes = 0;
		
		// Test ProjectEuler example
		PrimeNumbersManager problemPrimesManager = new PrimeNumbersManager(problemLimit);
		
		for (Long prime : problemPrimesManager.primes) {
			if (prime > exampleLimit) 
				break;
				
			sumOfPrimes += prime;
		}
		
		System.out.println("The sum in the example is: " + sumOfPrimes + " and it was supposed to be: 17");
		sumOfPrimes = 0;
		
		
		for (Long prime : problemPrimesManager.primes) {
			
			if (prime > problemLimit) {
				System.out.println("Debug...");
				break;
			}
			
			sumOfPrimes += prime;
		}
		
		System.out.println("The sum for the problem is: " + sumOfPrimes);

	}
	
	

}
