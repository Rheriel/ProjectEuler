package net.projecteuler;

public class SmallestMultiple {
	
	private static int smallestMultiple = 1;

	public static void main(String[] args) {

		
		long smallestMultiple = 1;
		int maxFactor = 20;
		
		boolean divided = false;
		int x = 1;
		
		double initTime = System.currentTimeMillis();
		while(!divided){
			for(int i= 1; i<= maxFactor; i++){
				if(smallestMultiple%i==0){
					divided = true;
				} else {
					x++;
					divided = false;
					break;
				}
			}
			smallestMultiple = x;
		}
		
		double endTime = System.currentTimeMillis(); // Previous was 10329.0

		System.out.println("" + smallestMultiple + " time: " + (endTime-initTime)); // 10640
	}
	
}
