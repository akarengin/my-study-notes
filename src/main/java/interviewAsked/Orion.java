package interviewAsked;

public class Orion {

// You are given an NxN 2D matix that represents an image.

    //// Rotate the image rby 90 degrees clockwise.
// Input:
//        [[1, 2, 3], // 0,1  -> 1,2  | 0,1 -> 1,0 | 0,2 -> 2,2   [l-i][j] [j][i]
//         [4, 5, 6],
//         [7, 8, 9]]
// Output:
//        [[7, 4, 1],
//         [8, 5, 2],
//         [9, 6, 3]]
    public static void main(String[] args) {
        Orion solution = new Orion();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = solution.rotateArray(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    
    
    public int[][] rotateArray(int[][] arr) {
        int[][] array = new int[arr.length][arr.length];
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                array[j][length-i-1] = arr[i][j];
            }
        }
        return array;
    } 

}
