package net.projecteuler;

public class LargestPalindromeProduct {
	
	private static final long palindromeLong = 10001;
	
	public static void main(String[] args) {
		
		System.out.println("Test palindrome function: ");
		System.out.println(isPalindrome(palindromeLong));
		long largestPalindrome = 0;
		
		for(int x=999; x>99; x--){
			for(int y=999; y>99; y--){
				if (isPalindrome(x*y)){
					if(largestPalindrome< (x*y))
						largestPalindrome = x*y;
					System.out.println("X:" + x + " Y:" + y + " largest palindrome: " + largestPalindrome);
				}
			}
		}
	}
	
	private static boolean isPalindrome(long value){
		
		boolean isPalindrome = true;
		
		String valueStr = String.valueOf(value);
		
		if (valueStr.length()%2==0){
			
			String valueStr1 = valueStr.substring(0, valueStr.length()/2);
			StringBuilder valueStr2 = new StringBuilder(valueStr.substring(valueStr.length()/2, valueStr.length()));
			
			if(!valueStr1.equals(valueStr2.reverse().toString())){
				isPalindrome = false;
			}
			
		} else {
		
			int cursor = 0;
			
			for(int i = valueStr.length() - 1; i>=cursor; i--){
				if(valueStr.charAt(i) != valueStr.charAt(cursor)){
					isPalindrome = false;
				}
				cursor++;
			}
			
			
		
		} 
		
		return isPalindrome;		
		
	}

}
