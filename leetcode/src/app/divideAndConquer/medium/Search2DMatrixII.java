package app.divideAndConquer.medium;
/**
 * 240. Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * ------------ Analysis
 * Use divide and conquer
 * Time complexity : O(nlogn)
 * Space complexity : O(logn): Although this approach does not fundamentally require greater-than-constant addition memory, its use of recursion means that it will use memory proportional to the height of its recursion tree. Because this approach discards half of matrix on each level of recursion (and makes two recursive calls), the height of the tree is bounded by logn.
 */

public class Search2DMatrixII {
    private int[][] matrix;
    private int target;

    private boolean searchRec(int up, int down, int left, int right) {
        // this submatrix has no height or no width.
        if (left > right || up > down) {
            return false;
        // `target` is already larger than the largest element or smaller
        // than the smallest element in this submatrix.
        } else if (target < matrix[up][left] || target > matrix[down][right]) {
            return false;
        }

        int midCol = left + (right-left)/2;

        // Locate `row` such that matrix[row-1][midCol] < target < matrix[row][midCol]
        int row = up;
        while (row <= down && matrix[row][midCol] <= target) {
            if (matrix[row][midCol] == target) {
                return true;
            }
            row++;
        }

        return searchRec(row, down, left, midCol-1) || searchRec(up, row-1, midCol+1, right);
    }

    public boolean searchMatrix(int[][] mat, int targ) {
        // cache input values in object to avoid passing them unnecessarily
        // to `searchRec`
        matrix = mat;
        target = targ;

        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        return searchRec(0, matrix.length-1, 0, matrix[0].length-1);
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
