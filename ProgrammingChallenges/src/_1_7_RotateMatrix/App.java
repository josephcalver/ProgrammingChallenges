package _1_7_RotateMatrix;

public class App {

	public static void main(String[] args) {
		
		int[][] matrix = { {1, 2, 3, 4}, 
						   {5, 6, 7, 8}, 
						   {9, 10, 11, 12},
						   {13, 14, 15, 16}};
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		rotate(matrix);
		System.out.println();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		rotate(matrix);
		System.out.println();
	
	}
	
	public static boolean rotate(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				
				// keep top on one side
				int top = matrix[first][i];
				
				// left --> top
				matrix[first][i] = matrix[last - offset][first];
				
				// bottom --> left
				matrix[last][last - offset] = matrix[i][last];
				
				// right --> bottom
				matrix[last][last - offset] = matrix[i][last];
				
				// top --> right
				matrix[i][last] = top;
			}
		}
		return true;
	}
	
}
