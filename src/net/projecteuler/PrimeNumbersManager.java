package net.projecteuler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeNumbersManager {

	private static int _numberOfPrimes = 10000;

	private static int _maxValueOfPrime = 2000000;


	protected static List<Long> primes = new ArrayList<Long>();

	private static int i = 0;

	static {
		//		load();
		loadToMaxValue();
	}

	private static void load() {

		for(long i=1; i < _numberOfPrimes;i++){
			if (isPrime(i)){
				primes.add(i);
			}
		}

		Collections.sort(primes);
		primes = Collections.synchronizedList(primes);
	}

	private static void loadToMaxValue(){

		long prime = 0;
		while(prime < _maxValueOfPrime){
			System.out.println(prime);
			if (isPrime(prime)){
				primes.add(prime);
			}
			prime++;
		}

		Collections.sort(primes);
	}

	public static void reload(){
		load();
	}

	public PrimeNumbersManager(int numberOfPrimes){
		_numberOfPrimes = numberOfPrimes;
		load();
	}

	public PrimeNumbersManager(){
		load();
	}

	public Long getNthPrime(int n){
		return primes.get(n);
	}

	public static boolean isPrime(long number){

		boolean isPrime = true;

		if (number < 14) {
			if(number ==  2 ||
					number == 3 ||
					number == 5 ||
					number == 7	||
					number == 11 ||
					number == 13){
				isPrime = true;
			} else {
				isPrime = false;
			}
		} 
		else {

			for(int j = 0; j < primes.size(); j++){
				if(number%primes.get(j)==0){
					isPrime = false;
					break;
				}
			}

		}

		return isPrime;
	}

	public void setNumberOfPrimes(int numberOfPrimes) {
		_numberOfPrimes = numberOfPrimes;
		reload();
	}

	public static void main(String[] args) {
		long sumOfPrimes = 0;
		int problemLimit = 2000000;
		int exampleLimit = 10;


		for (Long prime : primes) {
			if (prime > exampleLimit) 
				break;

			sumOfPrimes += prime;
		}

		System.out.println("The sum in the example is: " + sumOfPrimes + " and it was supposed to be: 17");
		sumOfPrimes = 0;

		for (Long prime : primes) {

			if (prime > problemLimit) {
				System.out.println("Debug...");
				break;
			}

			sumOfPrimes += prime;
		}

		System.out.println("The sum for the problem is: " + sumOfPrimes);

	}

}
