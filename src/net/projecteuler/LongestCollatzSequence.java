package net.projecteuler;

public class LongestCollatzSequence {

	private static final int STARTING_POINT = 1000000;
	private static int highestNumberOfElementsInTheSequence = 0;
	private static int largestNumberOfElementsGenerator = 0;
	private static int numberOfElements = 0;

	public static void main(String[] args){

		for (int i = STARTING_POINT; i > 0; i--) {
			numberOfElements = 0;
			System.out.println("Starting with: " + i);
			int highestNumberOfElementsInCurrentSequence = getNumberOfElementsInTheSequence(i);
			if (highestNumberOfElementsInCurrentSequence > highestNumberOfElementsInTheSequence){
				highestNumberOfElementsInTheSequence = highestNumberOfElementsInCurrentSequence;
				largestNumberOfElementsGenerator = i;
			}

		}

		System.out.println("Highest number of elements in the sequence: " + highestNumberOfElementsInTheSequence);
		System.out.println("Starting with: " + largestNumberOfElementsGenerator);
	}


	private static int getNumberOfElementsInTheSequence(long startingPoint){
		++numberOfElements;
		printElementOfTheSequence(startingPoint);
		if (startingPoint == 1){
			System.out.println("");
		} else {
			if (isEven(startingPoint)){
				getNumberOfElementsInTheSequence(getNextElementWithEvenFormula(startingPoint));
			} else {
				getNumberOfElementsInTheSequence(getNextElementWithOddFormula(startingPoint));
			}
		}
		
		return numberOfElements;

	}

	private static long getNextElementWithOddFormula(long startingPoint) {
		return (startingPoint * 3) + 1;
	}


	private static long getNextElementWithEvenFormula(long startingPoint) {
		return startingPoint / 2;
	}


	private static boolean isEven(long startingPoint) {
		return startingPoint%2==0?true:false;
	}


	private static void printElementOfTheSequence(long startingPoint){
		System.out.print("->" + startingPoint);
	}

}
