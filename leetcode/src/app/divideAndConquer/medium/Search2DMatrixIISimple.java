package app.divideAndConquer.medium;

/**
 * 240. Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * ------------ Analysis
 * Use search space reduction, more like greedy approach
 * Because the rows and columns of the matrix are sorted (from left-to-right and top-to-bottom, respectively), we can prune O(m) or O(n) elements when looking at any particular value.
 *  we initialize a (row,col) pointer to the bottom-left of the matrix. This would work equally well with a pointer initialized to the top-right. Neither of the other two corners would work, as pruning a row/column might prevent us from achieving the correct answer. 
 * Time: O(m+n)
 * Space: O(1)
 */
public class Search2DMatrixIISimple {

    public boolean searchMatrix(int[][] matrix, int target) {
        // edge case
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        // init a (row, col) pointer to the bottom left
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length){
            if(matrix[row][col] < target) {
                col++;
            } else if(matrix[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) throws Exception {
        int[][] input = {
            {1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}
        };

        Search2DMatrixII test = new Search2DMatrixII();
        boolean result = test.searchMatrix(input, 5);
        System.out.print(result);
        
    }
    
}
