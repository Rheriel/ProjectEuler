package net.projecteuler;


public class LargestProductInAGrid {

	private static final int GRID_SIZE = 20;
	int[][] grid = new int[][]{
			{8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8},
			{49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0},
			{81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65},
			{52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91},
			{22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80},
			{24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50},
			{32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70},
			{67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21},
			{24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72},
			{21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95},
			{78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92},
			{16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57},
			{86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58},
			{19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40},
			{4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66},
			{88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69},
			{4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36},
			{20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16},
			{20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54},
			{1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48}
	};

	protected enum ORIENTATION {
		VERTICAL_UP, VERTICAL_DOWN, HORIZONTAL_RIGHT, HORIZONTAL_LEFT, DIAGONAL_RIGHT, DIAGONAL_LEFT;
	}

	public volatile long largestProduct = 0;

	public Object lock = new Object();

	public ORIENTATION orientation;

	public int startingColumn = 0;
	public int startingRow = 0;

	final static LargestProductInAGrid instance = new  LargestProductInAGrid();
	private static final boolean IS_RIGHT_ORIENTED = true;
	private static final boolean IS_LEFT_ORIENTED = false;
	private static final boolean IS_UP_ORIENTED = true;
	private static final boolean IS_DOWN_ORIENTED = false;

	public static void main(String[] args) {

		instance.printGrid(0,0);
		//		new LargestProductInAGrid().printGrid();

//		System.out.println("Test Problem Horizontal Left: " + instance.calculateProductOfNFactors(4, 1, 20, ORIENTATION.HORIZONTAL_LEFT));
//		System.out.println("Test Problem Horizontal Right: " + instance.calculateProductOfNFactors(4, 1, 1, ORIENTATION.HORIZONTAL_RIGHT));
//		System.out.println("Test Problem Vertical Up: " + instance.calculateProductOfNFactors(4, 20, 1, ORIENTATION.VERTICAL_UP));
//		System.out.println("Test Problem Vertical Down: " + instance.calculateProductOfNFactors(4, 1, 1, ORIENTATION.VERTICAL_DOWN));
//		System.out.println("Test Problem Diagonal Right: " + instance.calculateProductOfNFactors(4, 6, 8, ORIENTATION.DIAGONAL_RIGHT));
//		System.out.println("Test Problem Diagonal Left: " + instance.calculateProductOfNFactors(4, 6, 8, ORIENTATION.DIAGONAL_LEFT));

		Thread horizontalThread = new Thread(new Runnable(){
			public void run(){
				for(int i = 1, j = 1; i <= GRID_SIZE - 4; i++){
					if(j < GRID_SIZE && i == (GRID_SIZE - 4)){
						j++;
						i = 1;
					}
					synchronized (instance.lock) {
					long product = instance.calculateProductOfNFactors(4, j, i, ORIENTATION.HORIZONTAL_RIGHT);
						if (product > instance.largestProduct) {
							instance.largestProduct = product;
						}
					}
				}
			}
		});
		
		Thread verticalThread = new Thread(new Runnable(){
			public void run(){
				for(int i = 1, j = 1; i <= GRID_SIZE - 4; i++){
					if(j < GRID_SIZE && i == (GRID_SIZE - 4)){
						j++;
						i = 1;
					}
					synchronized (instance.lock) {
					long product = instance.calculateProductOfNFactors(4, i, j, ORIENTATION.VERTICAL_DOWN);
						if (product > instance.largestProduct) {
							instance.largestProduct = product;
						}
					}
				}
			}
		});
		
		Thread diagonalRightThread = new Thread(new Runnable(){
			public void run(){
				for(int i = 1, j = 1; i <= GRID_SIZE - 4; i++){
					if(j < (GRID_SIZE - 3) && i == (GRID_SIZE - 3)){
						j++;
						i = 1;
					}
					synchronized (instance.lock) {
					long product = instance.calculateProductOfNFactors(4, i, j, ORIENTATION.DIAGONAL_RIGHT);
						if (product > instance.largestProduct) {
							instance.largestProduct = product;
						}
					}
				}
			}
		});
		
		Thread diagonalLeftThread = new Thread(new Runnable(){
			public void run(){
				for (int i = 1, j = 20; j >= 4; j--){
					if (i < (GRID_SIZE - 3) && j == 4){
						j = 20;
						i++;
					}
					synchronized (instance.lock) {
					long product = instance.calculateProductOfNFactors(4, i, j, ORIENTATION.DIAGONAL_LEFT);
						if (product > instance.largestProduct) {
							instance.largestProduct = product;
						}
					}
				}
			}
		});
		
		long startTime = System.currentTimeMillis();

		horizontalThread.start();
		verticalThread.start();
		diagonalLeftThread.start();
		diagonalRightThread.start();
		
		long endTime = System.currentTimeMillis();

		System.out.println("\n\n\nLargest: " + instance.largestProduct + " Found in : " + (endTime - startTime) + " miliseconds.");

	}

	private void printGrid(int startingRow, int startingColumn){

		System.out.print("" + grid[startingColumn][startingRow] + " ");

		if ((startingRow == GRID_SIZE - 1) && 
				(startingColumn == GRID_SIZE - 1)){
			return;
		}

		if ((startingRow == GRID_SIZE - 1)) {
			System.out.println("");
			printGrid(0, startingColumn + 1);
		}
		else {
			printGrid(startingRow + 1, startingColumn);
		}

	}

	private void printGrid() {
		for (int[] row : grid){
			for (int n :row) {
				System.out.print(n);
			}
			System.out.println();
		}
	}

	public long calculateProductOfNFactors(int nFactors, int startingRowIndex, int startingColumnIndex, ORIENTATION orientation){

		long product = 0;

		// Sanity Check
		if (orientation == null)
			throw new IllegalArgumentException("Error: Orientation cannot be null.");
		if (nFactors <= 0)
			throw new IllegalArgumentException("Error: Number of factors must be greater than 0: " + nFactors);
		if (startingRowIndex > GRID_SIZE)
			throw new IllegalArgumentException("Error: Starting row index cannot be greater than the number of values in the grid: " + startingRowIndex + " Number of Grid values: " + GRID_SIZE);
		if (startingColumnIndex > GRID_SIZE)
			throw new IllegalArgumentException("Error: Starting column index cannot be greater than the number of values in the grid: " + startingColumnIndex + " Number of Grid values: " + GRID_SIZE);
		if (startingRowIndex < 0)
			throw new IllegalArgumentException("Error: Starting row index cannot be less than 0: " + startingRowIndex);
		if (startingColumnIndex < 0)
			throw new IllegalArgumentException("Error: Starting column index cannot be less than 0: " + startingColumnIndex);
		if ((orientation.equals(ORIENTATION.HORIZONTAL_RIGHT) && (startingColumnIndex + nFactors) > GRID_SIZE)
				|| (orientation.equals(ORIENTATION.VERTICAL_DOWN)  && (startingRowIndex + nFactors) > GRID_SIZE )
				){
			throw new IllegalArgumentException("Error: Starting column index and number of factors will exceed grid size: " + startingColumnIndex + " Number of Factors: " + nFactors);
		}
		if ((orientation.equals(ORIENTATION.HORIZONTAL_LEFT) && (startingColumnIndex - nFactors) < 0)
				|| (orientation.equals(ORIENTATION.VERTICAL_UP) && (startingRowIndex - nFactors) < 0)
				){
			throw new IllegalArgumentException("Error: Starting column index and number of factors will be less than 0: " + startingColumnIndex + " Number of Factors: " + nFactors);
		}

		if (orientation.equals(ORIENTATION.HORIZONTAL_RIGHT)){
			product = calculateProductOfNFactorsHorizontal(nFactors, IS_RIGHT_ORIENTED, startingRowIndex - 1, startingColumnIndex - 1);
		} else if (orientation.equals(ORIENTATION.HORIZONTAL_LEFT)) {
			product = calculateProductOfNFactorsHorizontal(nFactors, IS_LEFT_ORIENTED, startingRowIndex - 1, startingColumnIndex - 1);
		} else if (orientation.equals(ORIENTATION.VERTICAL_UP)) {
			product = calculateProductOfNFactorsVertical(nFactors, IS_UP_ORIENTED, startingRowIndex - 1, startingColumnIndex - 1);
		} else if (orientation.equals(ORIENTATION.VERTICAL_DOWN)) {
			product = calculateProductOfNFactorsVertical(nFactors, IS_DOWN_ORIENTED, startingRowIndex - 1, startingColumnIndex - 1);
		} else if (orientation.equals(ORIENTATION.DIAGONAL_RIGHT)) {
			product = calculateProductOfNFactorsDiagonalRight(nFactors, startingRowIndex - 1, startingColumnIndex - 1);
		} else if (orientation.equals(ORIENTATION.DIAGONAL_LEFT)) {
			product = calculateProductOfNFactorsDiagonalLeft(nFactors, startingRowIndex - 1, startingColumnIndex - 1);
		} else {
			throw new IllegalArgumentException("Error: Orientation unknown: " + orientation);
		}

		return product;
	}

	private long calculateProductOfNFactorsHorizontal(int nFactors, boolean isRightOriented, int startingRowIndex, int startingColumnIndex){
		long product = 1;

		if (grid[startingRowIndex][startingColumnIndex] == 0) {
			return 0;
		}
		else {
			if (isRightOriented) {
				for (int i = startingColumnIndex, counter = 0; counter < nFactors; i++, counter++) {
					int factor = grid[startingRowIndex][i];
					if (factor == 0){
						return 0;
					} else {
						product = product * factor;
					}
				}
			} else {
				for (int i = startingColumnIndex, counter = 0; counter < nFactors; i--, counter++) {
					int factor = grid[startingRowIndex][i];
					if (factor == 0){
						return 0;
					} else {
						product = product * factor;
					}
				}
			}

		}

		return product;
	}

	private long calculateProductOfNFactorsVertical(int nFactors, boolean isUpOriented, int startingRowIndex, int startingColumnIndex){
		long product = 1;

		if (grid[startingRowIndex][startingColumnIndex] == 0) {
			return 0;
		}
		else {
			if (isUpOriented) {
				for (int i = startingRowIndex, count = 0; count < nFactors; i--, count++) {
					int factor = grid[i][startingColumnIndex];
					if (factor == 0){
						return 0;
					} else {
						product = product * factor;
					}
				}
			} else {
				for (int i = startingRowIndex, count = 0; count < nFactors; i++, count++) {
					int factor = grid[i][startingColumnIndex];
					if (factor == 0){
						return 0;
					} else {
						product = product * factor;
					}
				}
			}
		}

		return product;
	}

	private long calculateProductOfNFactorsDiagonalRight(int nFactors, int startingRowIndex, int startingColumnIndex){
		long product = 1;

		if (grid[startingRowIndex][startingColumnIndex] == 0) {
			return 0;
		}
		else {

			for (int i = startingRowIndex, j = startingColumnIndex, counter = 0; counter < nFactors; i++, j++, counter++) {
				int factor = grid[i][j];
				if (factor == 0){
					return 0;
				} else {
					product = product * factor;
				}
			}

		}

		return product;
	}

	private long calculateProductOfNFactorsDiagonalLeft(int nFactors, int startingRowIndex, int startingColumnIndex){
		long product = 1;

		if (grid[startingRowIndex][startingColumnIndex] == 0) {
			return 0;
		}
		else {

			for (int i = startingRowIndex, j = startingColumnIndex, counter = 0; counter < nFactors; i++, j--, counter++) {
				int factor = grid[i][j];
				if (factor == 0){
					return 0;
				} else {
					product = product * factor;
				}
			}

		}

		return product;
	}



}
