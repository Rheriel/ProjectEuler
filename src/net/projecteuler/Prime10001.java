package net.projecteuler;

import java.util.ArrayList;
import java.util.List;

public class Prime10001 {

	static final int nthPrime = 30000;
	static int[] primeNumbers = new int[nthPrime];
	static int i = 6;

	static {
		primeNumbers[0] = 2;
		primeNumbers[1] = 3;
		primeNumbers[2] = 5;
		primeNumbers[3] = 7;
		primeNumbers[4] = 11;
		primeNumbers[5] = 13;
	}

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		for(int l = 0; i < nthPrime; l++){
			isPrime(l);
		}
		long endTime = System.currentTimeMillis();

		System.out.println("Prime number " + nthPrime + "th is: " + getNthPrimeNumber(nthPrime) + " obtained in: " + (endTime - startTime) + " seconds.");
	}

	public static int getNthPrimeNumber(int n){
		return primeNumbers[n - 1];
	}

	public static boolean isPrime(int number){

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
			for(int j = 0; j < i; j++){
				if(number%primeNumbers[j]==0){
					isPrime = false;
					break;
				}
			}
			
			if (isPrime) {
				primeNumbers[i] = number;
				i++;
			}
			
		}

		

		return isPrime;
	}

}
