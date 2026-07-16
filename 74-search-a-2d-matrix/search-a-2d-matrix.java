class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return solve(matrix , target , 0 , matrix[0].length-1);
    }

    public boolean solve(int[][] matrix, int target , int row , int col){
        int n = matrix.length;
        int m = matrix[0].length;

        if(row >= n || col >= m || row < 0 || col < 0){
            return false;
        }

        if(matrix[row][col] == target){
            return true;
        }

        if(matrix[row][col] > target){
           return solve(matrix , target , row , col-1);
        }else{
             return solve(matrix , target , row+1 , col);
        }

    }
}