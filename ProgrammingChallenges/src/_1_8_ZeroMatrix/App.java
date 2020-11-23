package _1_8_ZeroMatrix;

public class App {
	
	/*
	 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, 
	 * its entire row and column are set to 0.
	 */
	
	public static void main(String[] args) {
		
		int[][] matrix = {{1, 1, 1, 1, 1},
						  {1, 1, 1, 1, 1},
						  {1, 1, 1, 1, 1}, 
						  {1, 1, 1, 1, 1},
						  {1, 1, 1, 1, 1},
					      {1, 1, 1, 1, 1},
						  {1, 1, 1, 0, 1},
						  {1, 1, 1, 1, 1},
						  {1, 1, 1, 1, 1}};
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		zeroMatrix(matrix);
		System.out.println();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static boolean zeroMatrix(int[][] matrix) {
		
		int zeroRow = -1, zeroCol = -1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					zeroRow = i;
					zeroCol = j;
					break;
				}
			}
		}
		if (zeroRow == -1 && zeroCol == -1) return false;
		
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][zeroCol] = 0;
		}
		
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[zeroRow][i] = 0;
		}
		return true;
	}

}
