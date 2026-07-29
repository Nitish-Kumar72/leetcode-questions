class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int startrow = 0;
        int startcol = 0;
        int endrow = matrix.length-1;
        int endcol = matrix[0].length-1;

        while(startrow<=endrow && startcol<=endcol){

        for(int i = startrow; i <= endcol; i++){
            res.add(matrix[startrow][i]);
        }
        for(int i = startrow+1; i <= endrow; i++){
            res.add(matrix[i][endcol]);

        }

        for(int j = endcol-1; j >=startcol; j--){
            if(startrow==endrow){
                break;
            }
            res.add(matrix[endrow][j]);
        }

        for(int j = endrow-1; j >= startrow+1; j--){
            if(startcol==endcol){
                break;
            }
            res.add(matrix[j][startcol]);
        }

        startrow++;
        startcol++;
        endrow--;
        endcol--;
     }
        return res;

    }    
    
}

