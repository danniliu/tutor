package app.array.two;

/**
 * Leetcode: 54. Spiral Matrix
 * Reference: https://leetcode.com/problems/spiral-matrix/
 * Additional Info: tag: array; difficulty: medium 
 * ************************** Description:
    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
    Example 1:
    Input:
    [
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
    ]
    Output: [1,2,3,6,9,8,7,4,5]

    Example 2:
    Input:
    [
    [1, 2, 3, 4],
    [5, 6, 7, 8],
    [9,10,11,12]
    ]
    Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * ************************** Analysis:
 * time and space: O(row*col)
 */
import java.util.*;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        //base case
        if(matrix == null || matrix.length == 0) {
            return result;
        }
        //Start traversal the outer layers one by one
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length -1;
        int size = matrix.length * matrix[0].length;
        while(result.size() < size){
            //traverse top row
            for(int i=left; i<=right && result.size() < size; i++){
                result.add(matrix[top][i]);
            }
            top++;
            //traverse right col
            for(int i=top; i<=bottom && result.size() < size; i++){
                result.add(matrix[i][right]);
            }
            right --;
            //traverse bottom row
            for(int i=right; i>=left && result.size() < size; i--){
                result.add(matrix[bottom][i]);
            }
            bottom --;
            //traverse right col
            for(int i=bottom; i>=top && result.size() < size; i--){
                result.add(matrix[i][left]);
            }
            left ++;
        }
        
        return result;
    }
    public static void main(String[] args) throws Exception {
        int[][] input = {
            {1,2,3}, {4,5,6}, {7,8,9}
        };

        List<Integer> result = spiralOrder(input);
        for(int i: result){
            System.out.print(i + " ,");
        }
    }
}