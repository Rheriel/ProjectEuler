package net.algorithms.sieve;

import java.util.Arrays;

public class Eratosthenes {
	
	private static int numberOfPrimes = 1000000;
	
	protected boolean[] isPrime = new boolean[numberOfPrimes + 1];
	
	public Eratosthenes(){
		
		Arrays.fill(isPrime, true);
		
		int rootBound = (int) Math.sqrt(numberOfPrimes);
		
		/*		
 		For all numbers m: 2 .. sqrt(n), if m is unmarked:
		add m to primes list;
		mark all it's multiples, starting from square, 
		lesser or equal than n (k * m <= n, k >= m);
		otherwise, if m is marked, then it is a composite number;
		check all numbers in range sqrt(n) .. n. 
		All found unmarked numbers are primes, add them to list.
		 */
		for(int i = 2; i <= rootBound; i++){
			for (int j= i*i; j <= numberOfPrimes; j+=i){
				isPrime[j] = false;
			}
		}
		
		
		
	}
    
	public static void main(String[] args) {
		Eratosthenes primeGenerator = new Eratosthenes();
        for (int i = 0; i <= numberOfPrimes; i++) {
            if (primeGenerator.isPrime[i]) System.out.println(i);
        }
        
		
		
	}

}
